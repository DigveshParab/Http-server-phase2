package main.java.com.project.httpserver.model;

public class ResponseB {
    private int id;
    private ShoppingItem item;

    public ResponseB(int id, ShoppingItem itemData) {
        this.id = id;
        this.item = itemData;
    }

    public int getId() {
        return id;
    }

    public ShoppingItem getItem() {
        return item;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItem(ShoppingItem item) {
        this.item = item;
    }
}
