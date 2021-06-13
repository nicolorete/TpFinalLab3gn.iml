package com.company;

import java.util.UUID;

public class ItemRent {

    private UUID uuid;
    private String name;
    private double price;
    private int stock;
    public ItemRent() {
    }

    public ItemRent(String name, double price, int stock) {
        this.uuid = uuid.randomUUID();
        this.name = name;
        this.price = price;
        this.stock = 1;
    }

    ///region GETTERS AND SETTERS

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    ///endregion


    @Override
    public String toString() {
        return " ItemRent{" +
                "\n id: " + uuid.toString().substring(1,10) +
                "\n name: " + name +
                "\n price: $" + price +
                "\n stock: " + stock +
                '}';
    }
}
