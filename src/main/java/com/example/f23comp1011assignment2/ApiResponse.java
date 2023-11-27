package com.example.f23comp1011assignment2;

import java.util.ArrayList;
/*
* Here I pick what info I want to grab from the API, check the drivers.json
* I'll take the results and because I want something from the response part
* I need to make it an ArrayList<> and create a class for it.
*
* <-GPT Smart version of my comment->
* The ApiResponse class represents the structure of the response obtained from the Formula 1 API.
* It focuses on extracting driver-related information and uses an ArrayList of Driver objects.
*/

public class ApiResponse {

    private String results;

    private ArrayList<Driver> response;

    public String getResults() {
        return results;
    }

    public ArrayList<Driver> getResponse() {
        return response;
    }
}
