package com.example.f23comp1011assignment2;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class APIUtility {

    //This method calls the Formula 1 API with a driver name passed in as an arguement
    public static ApiResponse callAPI(String driverName) throws IOException, InterruptedException {

        //If we received "Lewis Hamilton", we need to translate that to be "Lewis%20Hamilton"
       driverName = driverName.replaceAll(" ", "%20");


//        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api-formula-1.p.rapidapi.com/drivers?search=" + driverName))
                .header("X-RapidAPI-Key", "3022d24a06msh9e571101e8fa8f0p186114jsn7208f8743876")
                .header("X-RapidAPI-Host", "api-formula-1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

//        HttpResponse<Path> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers
//                                         .ofFile(Paths.get("drivers.json")));


        HttpResponse<String> httpResponse = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(httpResponse.body(), ApiResponse.class);
    }
}
