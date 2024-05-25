package main.java.com.project.httpserver.storage;

import main.java.com.project.httpserver.model.Employee;

import java.util.HashMap;
import java.util.Map;

//this class will manage the employee data using hashmap
public class EmployeeStorage {
    private Map<Integer, Employee> employees = new HashMap<>();

    // read
    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    // create
    public void addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    // update
    public void updateEmployee(int id,Employee employee) {
        employees.put(id, employee);
    }

    //delete
    public void removeEmployee(int id) {
        employees.remove(id);
    }

    public Map<Integer,Employee> getAllEmployees(){
        return employees;
    }

}
