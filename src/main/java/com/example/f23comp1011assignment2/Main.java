package com.example.f23comp1011assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import java.io.IOException;

// The main class that launches the JavaFX application
public class Main extends Application {

    // Entry point for the JavaFX application
    @Override
    public void start(Stage stage) throws IOException {

        // Load a custom font for the application
        Font.loadFont(getClass().getResourceAsStream("/fonts/PixelifySans-Regular.ttf"), 12);

        // Load the main FXML file for the UI
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("driver-details.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Set the stage properties
        stage.setTitle("Formula 1"); // Set the title of the application
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("/images/icon.png"))); // Set the application icon
        stage.setScene(scene); // Set the scene to display
        stage.show(); // Display the stage
    }

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch();
    }
}
