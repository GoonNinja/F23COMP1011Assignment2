package com.example.f23comp1011assignment2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    // API key and host constants
    private static final String RAPID_API_KEY = "3022d24a06msh9e571101e8fa8f0p186114jsn7208f8743876";
    private static final String RAPID_API_HOST = "formula-1-standings.p.rapidapi.com";

    // Method to call the Formula 1 drivers' standings API
    public static void callDriversApi() throws IOException, InterruptedException {
        callApi("https://formula-1-standings.p.rapidapi.com/standings/drivers", "drivers.json");
    }

    // Method to call the Formula 1 constructors' standings API
    public static void callConstructorsApi() throws IOException, InterruptedException {
        callApi("https://formula-1-standings.p.rapidapi.com/standings/constructors", "constructors.json");
    }

    // Method to call the Formula 1 races' standings API
    public static void callRacesApi() throws IOException, InterruptedException {
        callApi("https://formula-1-standings.p.rapidapi.com/races", "races.json");
    }

    // Common method to make API calls
    private static void callApi(String endpoint, String fileName) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .header("X-RapidAPI-Key", RAPID_API_KEY)
                .header("X-RapidAPI-Host", RAPID_API_HOST)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<Path> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get(fileName)));

            // Check if the API call was successful (HTTP status code 200)
            if (httpResponse.statusCode() == 200) {
                System.out.println("Data received successfully.");
            } else {
                System.out.println("Failed to retrieve data. HTTP Status Code: " + httpResponse.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            // Print any exceptions that occur during the API call
            e.printStackTrace();
        }
    }

    // Main method to demonstrate calling different API endpoints
    public static void main(String[] args) {
        try {
            callDriversApi();
            callConstructorsApi();
            callRacesApi();
        } catch (IOException | InterruptedException e) {
            // Print any exceptions that occur during API calls
            e.printStackTrace();
        }
    }
}
