package com.example.f23comp1011assignment2;

import java.io.IOException;

public class TempTester {

    public static void main(String[] args) throws IOException, InterruptedException {

        try{
           // APIUtility.callConstructorsApi();
            APIUtility.callDriversApi();
           // APIUtility.callRacesApi();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
