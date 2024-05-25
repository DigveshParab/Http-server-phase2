package main.java.com.project.httpserver.model;

public class ResponseA {
    private int id;
    private Employee employeeData;

    public ResponseA(int id, Employee employeeData) {
        this.id = id;
        this.employeeData = employeeData;
    }

    public int getId() {
        return id;
    }

    public Employee getEmployeeData() {
        return employeeData;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmployeeData(Employee employeeData) {
        this.employeeData = employeeData;
    }
}
