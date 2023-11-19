package com.example.f23comp1011assignment2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    private static final String RAPID_API_KEY = "3022d24a06msh9e571101e8fa8f0p186114jsn7208f8743876";
    private static final String RAPID_API_HOST = "formula-1-standings.p.rapidapi.com";

    public static void callDriversApi() throws IOException, InterruptedException {
        callApi("https://formula-1-standings.p.rapidapi.com/standings/drivers", "drivers.json");
    }

    public static void callConstructorsApi() throws IOException, InterruptedException {
        callApi("https://formula-1-standings.p.rapidapi.com/standings/constructors", "constructors.json");
    }

    public static void callRacesApi() throws IOException, InterruptedException {
        // Add more methods as needed for additional API endpoints
        callApi("https://formula-1-standings.p.rapidapi.com/races", "races.json");
    }

    private static void callApi(String endpoint, String fileName) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .header("X-RapidAPI-Key", RAPID_API_KEY)
                .header("X-RapidAPI-Host", RAPID_API_HOST)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<Path> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get(fileName)));
    }

    public static void main(String[] args) {
        try {
            callDriversApi();
            callConstructorsApi();
            callRacesApi();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
