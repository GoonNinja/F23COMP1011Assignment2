package com.example.f23comp1011assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class DriverDetailsController implements DriverLoader{

    @FXML
    private Label birthplaceLabel;

    @FXML
    private Label careerPointsLabel;

    @FXML
    private Label grandPrixLabel;

    @FXML
    private Label headerLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label nameLabel;

    @FXML
    private Label nationalityLabel;

    @FXML
    private Label podiumsLabel;

    @FXML
    private Label worldChampionshipsLabel;

    @FXML
    void backToPrevious(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "driver-search-view.fxml");
    }

    public void loadDriver(String driverName){
        System.out.printf(driverName);
    }

}
