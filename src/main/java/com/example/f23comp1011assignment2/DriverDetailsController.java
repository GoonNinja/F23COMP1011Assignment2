package com.example.f23comp1011assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class DriverDetailsController implements DriverLoader{

    @FXML
    private Label birthplaceLabel;

    @FXML
    private Label careerPointsLabel;

    @FXML
    private Label grandPrixLabel;

    @FXML
    private Label nationalityLabel;

    @FXML
    private Label podiumsLabel;

    @FXML
    private Label worldChampionshipsLabel;

    @FXML
    private Label headerLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label nameLabel;

    @FXML
    private GridPane gridPane;

    @FXML
    void backToPrevious(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "driver-search-view.fxml");
    }

    public void loadDriver(Number driverId) throws IOException, InterruptedException {

        try{
            DriverDetailsResponse driver = APIUtility.getDriverDetails(driverId);
            System.out.println(driver);
            nameLabel.setText(driver.getResponse().get(0).getName());
            birthplaceLabel.setText(driver.getResponse().get(0).getBirthplace());
            careerPointsLabel.setText(driver.getResponse().get(0).getCareerPoints());
            grandPrixLabel.setText(driver.getResponse().get(0).getGrandPrixEntered().toString());
            nationalityLabel.setText(driver.getResponse().get(0).getNationality());
            podiumsLabel.setText(driver.getResponse().get(0).getPodiums().toString());
            worldChampionshipsLabel.setText(driver.getResponse().get(0).getWorldChampionships().toString());
            // Set image or default if it's null
            if (driver.getResponse().get(0).getImage() != null) {
                imageView.setImage(new Image(driver.getResponse().get(0).getImage()));
            } else {
                imageView.setImage(new Image(Main.class.getResourceAsStream("../images/img.png")));
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }

}
