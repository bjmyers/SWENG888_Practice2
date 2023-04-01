package com.example.practice2;

import java.io.Serializable;

public class Item implements Serializable {

    private final int identifier;
    private final String name;
    private final double price;

    public Item(int identifier, String name, double price) {
        this.identifier = identifier;
        this.name = name;
        this.price = price;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
