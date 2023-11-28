package com.example.f23comp1011assignment2;

import com.google.gson.annotations.SerializedName;

// Represents detailed information about a Formula 1 driver
public class DriverDetails {

    // Annotating fields to map them to specific JSON keys using Gson
    @SerializedName("world_championships")
    private Number worldChampionships;

    @SerializedName("career_points")
    private String careerPoints;

    @SerializedName("grands_prix_entered")
    private Number grandPrixEntered;

    private String nationality;
    private Number podiums;
    private String birthplace;
    private String name;
    private String image;

    // Getter methods for accessing private fields

    public Number getWorldChampionships() {
        return worldChampionships;
    }

    public String getCareerPoints() {
        return careerPoints;
    }

    public Number getGrandPrixEntered() {
        return grandPrixEntered;
    }

    public String getNationality() {
        return nationality;
    }

    public Number getPodiums() {
        return podiums;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
