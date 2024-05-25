package main.java.com.project.httpserver.storage;

import main.java.com.project.httpserver.model.ShoppingItem;

import java.util.HashMap;
import java.util.Map;

public class ItemStorage {

    private Map<Integer, ShoppingItem> items = new HashMap<Integer, ShoppingItem>();

    public void addItem(ShoppingItem list) {
        items.put(list.getId(), list);
    }
    public ShoppingItem getItem(int id) {
        return items.get(id);
    }
    public void removeItem(int id) {
        items.remove(id);
    }
    public void updateItem(int id, ShoppingItem list) {
        items.put(id, list);
    }
    public Map<Integer, ShoppingItem> getAllItems(){
        return items;
    }
}
