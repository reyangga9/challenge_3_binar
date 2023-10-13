package com.binarfud.binarfud.Model;

// Menu item buat ArrayList
public class MenuItem {
    private String name;
    private int id;
    private int price;
    private int qty;

    public MenuItem(){}

    public MenuItem(int id,String name, int price) {
        this.id =id;
        this.name = name;
        this.price = price;
    }

    public MenuItem(String name, int price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public int getId() {
        return id;
    }

    public int setQty(int qty) {

        return this.qty += qty;
    }
}
