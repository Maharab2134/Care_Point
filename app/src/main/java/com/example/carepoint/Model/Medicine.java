package com.example.carepoint.Model;

public class Medicine {

    private String name;
    private String brand;
    private String usage;
    private String dosage;
    private double price;
    private int imageResId;

    // Constructor
    public Medicine(String name, String brand, String usage, String dosage, double price, int imageResId) {
        this.name = name;
        this.brand = brand;
        this.usage = usage;
        this.dosage = dosage;
        this.price = price;
        this.imageResId = imageResId;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getUsage() {
        return usage;
    }

    public String getDosage() {
        return dosage;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResId() {
        return imageResId;
    }
}
