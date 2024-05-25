package main.java.com.project.httpserver.handlers;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import main.java.com.project.httpserver.model.Employee;
import main.java.com.project.httpserver.model.ResponseA;
import main.java.com.project.httpserver.storage.EmployeeStorage;

import java.io.IOException;
import java.io.InputStreamReader;


public class EmployeeHandler extends BaseHandler{

    private EmployeeStorage storage = new EmployeeStorage();
    private Gson gson = new Gson();

    @Override
    protected void handleDelete(HttpExchange exchange) throws IOException {
        String[] path = exchange.getRequestURI().getPath().split("/");
        if (path.length == 3){
            int id = Integer.parseInt(path[2]);

            Employee currEmployee = storage.getEmployee(id);
            if (currEmployee != null){
                storage.removeEmployee(id);
                String response = "{\"message\": \"Employee record deleted successfully.\"}";
                sendJsonResponse(exchange,response,200);
            }else{
                String response = "{\"message\": \"Employee record not found.\"}";
                sendJsonResponse(exchange,response,404);
            }
        }
    }

    @Override
    protected void handlePut(HttpExchange exchange) throws IOException {
        String[] path = exchange.getRequestURI().getPath().split("/");
        if(path.length == 3){
            // getting id from the URI
            int id = Integer.parseInt(path[2]);

            // getting data from the request body
            InputStreamReader isr = new InputStreamReader(exchange.getRequestBody());
            Employee employee = gson.fromJson(isr, Employee.class);

            // updating data from storage
            Employee currEmployee = storage.getEmployee(id);
            if(currEmployee != null){
                storage.updateEmployee(id,employee);
                String response = "{\"message\": \"Data updated Successfully.\"}";
                sendJsonResponse(exchange,response,200);
            }else{
                String response = "{\"message\": \"Employee with the given id doesn't exist.\"}";
                sendJsonResponse(exchange,response,404);
            }
        }
    }

//     handling put req but instead of id being send in url its send as params
//    @Override
//    protected void handlePut(HttpExchange exchange) throws IOException {
//        // get the data send by user in body
//        InputStreamReader isr = new InputStreamReader(exchange.getRequestBody());
//
//        // deserialize the data
//        ResponseA employeeData = gson.fromJson(isr, ResponseA.class);
//        int updId = employeeData.getId();
//        Employee currEmployee = employeeData.getEmployeeData();
//
//        if(storage.getEmployee(updId) != null){
//            storage.updateEmployee(updId,currEmployee);
//            String response =  "{\"message\": \"Employee data updated.\"}";
//            sendJsonResponse(exchange,response,200);
//
//        }else{
//            String response =  "{\"message\": \"Employee with the provided id doesn't exist.\"}";
//            sendJsonResponse(exchange,response,200);
//        }
//    }

    @Override
    protected void handlePost(HttpExchange exchange) throws IOException {
        // creat a input stream to read the request body in UTF-8 encoding
        InputStreamReader isr = new InputStreamReader(exchange.getRequestBody());
        System.out.println(exchange.getRequestBody());
        // deserialize the json data to employee object

        Employee employeeData = gson.fromJson(isr,Employee.class);
        //The gson.fromJson method converts the JSON data from the InputStreamReader into an Employee object.
        // This requires the Employee class to be defined appropriately with the necessary fields.

        // add this employee to storage
        storage.addEmployee(employeeData);

        // create a success message
        String response = "{\"message\": \"Employee Data added successfully\"}";

        sendResponse(exchange,response,200);

    }

    @Override
    protected void handleGet(HttpExchange exchange) throws IOException {
        String response;
        int statusCode = 200;
        // extract the path segments from the client req url
        String[] path = exchange.getRequestURI().getPath().split("/");
        // exchange.getRequestURI() will return the URL client made req to  - http://localhost:8080/employee/all"
        // exchange.getRequestURI().getPath() return the path - /employee/all
        // exchange.getRequestURI().getPath().split("/") this will split the path into a array
        // path = {"","employee","all"}

        if(path.length == 3 && path[2].equals("all")){
            // request is for all employee data
            response = gson.toJson(storage.getAllEmployees());
        }
        else if(path.length == 3){
            // request is for specific employee by id
            int id = Integer.parseInt(path[2]);
            Employee currEmployee = storage.getEmployee(id);
            if(currEmployee != null){
                // if the employee is found send the data
                response = gson.toJson(currEmployee);
            }else{
                // if employee is not found send error message
                response = "Employee not found";
                statusCode = 404;
            }
        }else{
            // if the req is not for all and neither for specific employee poor URI
            response = "Invalid request";
            statusCode = 400;
        }

        sendJsonResponse(exchange,response,statusCode);
    }
}
