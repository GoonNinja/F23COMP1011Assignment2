package com.example.f23comp1011assignment2;

import java.io.IOException;

public class TempTester {

    public static void main(String[] args) throws IOException, InterruptedException {

        try{
            APIUtility.callAPI("Max Verstappen");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
