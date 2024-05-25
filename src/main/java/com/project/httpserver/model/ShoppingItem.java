package main.java.com.project.httpserver.model;

public class ShoppingItem {
    private int id;
    private String name;

    public ShoppingItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // getters
    public int getId() {return id;}
    public String getName() {return name;}

    //setters
    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
}
