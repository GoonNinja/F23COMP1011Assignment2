package com.example.f23comp1011assignment2;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIUtility {

    // This method calls the Formula 1 API with a driver name passed in as an argument
    public static ApiResponse callAPI(String driverName) throws IOException, InterruptedException {

        // If we received "Lewis Hamilton", we need to translate that to be "Lewis%20Hamilton"
        driverName = driverName.replaceAll(" ", "%20");

        // Build the HttpRequest to make a GET request to the Formula 1 API
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api-formula-1.p.rapidapi.com/drivers?search=" + driverName))
                .header("X-RapidAPI-Key", "3022d24a06msh9e571101e8fa8f0p186114jsn7208f8743876")
                .header("X-RapidAPI-Host", "api-formula-1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        // Send the GET request and receive the response as a string
        HttpResponse<String> httpResponse = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        // Use Gson to deserialize the JSON response into an ApiResponse object
        Gson gson = new Gson();
        return gson.fromJson(httpResponse.body(), ApiResponse.class);
    }

    public static DriverDetailsResponse getDriverDetails(Number driverId) throws IOException, InterruptedException {


        // Build the HttpRequest to make a GET request to the Formula 1 API
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api-formula-1.p.rapidapi.com/drivers?id=" + driverId))
                .header("X-RapidAPI-Key", "3022d24a06msh9e571101e8fa8f0p186114jsn7208f8743876")
                .header("X-RapidAPI-Host", "api-formula-1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
       // Send the GET request and receive the response as a string
        HttpResponse<String> httpResponse = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        // Use Gson to deserialize the JSON response into a DriverDetails object
        Gson gson = new Gson();
        return gson.fromJson(httpResponse.body(), DriverDetailsResponse.class);
    }
}
