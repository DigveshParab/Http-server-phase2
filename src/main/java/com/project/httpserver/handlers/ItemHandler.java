package main.java.com.project.httpserver.handlers;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import main.java.com.project.httpserver.model.ResponseB;
import main.java.com.project.httpserver.model.ResponseC;
import main.java.com.project.httpserver.model.ShoppingItem;
import main.java.com.project.httpserver.storage.ItemStorage;

import java.io.IOException;
import java.io.InputStreamReader;

public class ItemHandler extends BaseHandler{
    ItemStorage storage = new ItemStorage();
    Gson gson = new Gson();

    @Override
    protected void handleDelete(HttpExchange exchange) throws IOException {
        String response;
        int statusCode = 200;

        // get data from request body
        InputStreamReader isr = new InputStreamReader(exchange.getRequestBody());
        // deserialize data
        ResponseC itemData = gson.fromJson(isr, ResponseC.class);
        int id = itemData.getId();
        if(storage.getItem(id) != null) {
            storage.removeItem(id);
            response = "{\"message\": \"Item deleted.\"}";
            statusCode = 200;
        }else{
            response = "{\"message\": \"Item not found\"}";
        }

        sendJsonResponse(exchange,response,statusCode);
    }

    @Override
    protected void handlePut(HttpExchange exchange) throws IOException {
        String response;
        int statusCode = 200;
        // get data from request body
        InputStreamReader isr = new InputStreamReader(exchange.getRequestBody());

        // deserialize this data
        ResponseB itemdata = gson.fromJson(isr, ResponseB.class);

        int id = itemdata.getId();
        ShoppingItem currItem = itemdata.getItem();

        // chek if item exist
        if(storage.getItem(id) != null) {
            storage.updateItem(id,currItem);
            response = "{\"message\": \"Item updated.\"}";
            statusCode = 200;
        }else{
            response = "{\"message\": \"Item does not exist\"}";
            statusCode = 404;
        }

        sendJsonResponse(exchange,response,statusCode);


    }

    @Override
    protected void handlePost(HttpExchange exchange) throws IOException {
        String response;
        int statusCode = 200;

        // getting the input by client
        InputStreamReader irs = new InputStreamReader((exchange.getRequestBody()));
        // deserialize the data
        ShoppingItem currItem = gson.fromJson(irs,ShoppingItem.class);

        if(currItem != null) {
            if(storage.getItem(currItem.getId()) != null){
                response = "{\"message\": \"Item with the given id exists\"}";
                statusCode = 201;
            }else{
                storage.addItem(currItem);
                response = "{\"message\": \"Item added\"}";
                statusCode = 200;
            }
        }else{
            response = "{\"message\": \"Provide data.\"}";
            statusCode = 400;
        }

        sendJsonResponse(exchange, response, statusCode);

    }

    @Override
    protected void handleGet(HttpExchange exchange) throws IOException {
        String response;
        int statusCode = 200;
        // get the url which is requested by client
        String[] path = exchange.getRequestURI().getPath().split("/");
        // check if its for all or single item
        if(path.length == 3 && path[2].equals("all")){
            response = gson.toJson(storage.getAllItems());
            statusCode = 200;
        }else if(path.length == 3){
            int id = Integer.parseInt(path[2]);
            ShoppingItem currItem = storage.getItem(id);
            if(currItem != null){
                response = gson.toJson(currItem);
                statusCode = 200;
            }else{
                response = "{\"message\": \"Item dosent exist\"}";
                statusCode = 404;
            }
        }else{
            response = "{\"message\": \"Invalid request\"}";
            statusCode = 400;
        }

        sendJsonResponse(exchange,response,statusCode);

    }
}
