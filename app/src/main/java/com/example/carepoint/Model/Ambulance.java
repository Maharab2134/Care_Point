package com.example.carepoint.Model;

public class Ambulance {

    private String name;
    private String serviceArea;
    private String phoneNumber;
    private String availability;
    private int imageResId;

    public Ambulance(String name, String serviceArea, String phoneNumber, String availability, int imageResId) {
        this.name = name;
        this.serviceArea = serviceArea;
        this.phoneNumber = phoneNumber;
        this.availability = availability;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
