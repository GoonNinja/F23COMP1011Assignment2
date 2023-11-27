package com.example.f23comp1011assignment2;

import com.google.gson.annotations.SerializedName;

// Represents information about a Formula 1 driver
public class Driver {

    // Annotating fields to map them to specific JSON keys using Gson
    @SerializedName("grands_prix_entered")
    private Number grandPrixEntered;

    @SerializedName("world_championships")
    private Number worldChampionships;

    @SerializedName("career_points")
    private String careerPoints;

    @SerializedName("image")
    private String driverImage;

    // Basic driver information
    private String name;
    private String nationality;
    private String birthplace;
    private String birthdate;
    private Number podiums;

    // Getter methods for accessing private fields

    public Number getGrandPrixEntered() {
        return grandPrixEntered;
    }

    public Number getWorldChampionships() {
        return worldChampionships;
    }

    public String getCareerPoints() {
        return careerPoints;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public Number getPodiums() {
        return podiums;
    }

    public String getDriverImage() {
        return driverImage;
    }

    // Custom toString method for better representation in the UI or debugging
    public String toString() {
        return String.format("%s", name);
    }
}
