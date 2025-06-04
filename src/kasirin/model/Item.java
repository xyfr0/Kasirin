/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirin.model;

/**
 *
 * @author jabba
 */
public class Item {
    private String itemID;
    private String itemName;
    private double price;
    private int stock;

    public Item(String itemID, String itemName, double price, int stock) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
        this.stock = stock;
    }
        

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
    
    
    
}
