package com.example.f23comp1011assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    //Method to change scenes
    public static void changeScenes(ActionEvent event, String fxmlFileName) throws IOException {
        // Load the main FXML file for the UI
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());
        //Get the stage from the ActionEvent
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene); // Set the scene to display
        stage.show(); // Display the stage
    }

    public static void changeScenes(ActionEvent event, String fxmlFileName, String driverName) throws IOException {
        // Load the main FXML file for the UI
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());

        //get the controller for the destination view and call the "loadDriver()" method
        DriverLoader controller = fxmlLoader.getController();
        controller.loadDriver(driverName);

        //Get the stage from the ActionEvent
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene); // Set the scene to display
        stage.show(); // Display the stage
    }


}
