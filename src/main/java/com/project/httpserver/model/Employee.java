package main.java.com.project.httpserver.model;


// this represents the employee data
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private String position;

    public Employee(int id, String name, int age, double salary, String position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    // Getters
    public int getId() {return id;}
    public String getName() {return name;}
    public int getAge() {return age;}
    public double getSalary() {return salary;}
    public String getPosition() {return position;}

    //Setters
    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setAge(int age) {this.age = age;}
    public void setSalary(double salary) {this.salary = salary;}
    public void setPosition(String position) {this.position = position;}
}
