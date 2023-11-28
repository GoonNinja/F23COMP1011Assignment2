package com.example.f23comp1011assignment2;

import com.google.gson.annotations.SerializedName;

// Represents information about a Formula 1 driver
public class Driver {

    // Annotating fields to map them to specific JSON keys using Gson
    @SerializedName("image")
    private String driverImage;

    // Basic driver information
    private String name;

    @SerializedName("id")
    private Number driverId;

    // Getter methods for accessing private fields
    public String getName() {

        return name;
    }
    public String getDriverImage() {

        return driverImage;
    }
    public Number getDriverId(){
        return driverId;
    }

    // Custom toString method for better representation in the UI or debugging
    public String toString() {

        return String.format("%s", name);
    }
}
