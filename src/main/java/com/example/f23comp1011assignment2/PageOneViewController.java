package com.example.f23comp1011assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class PageOneViewController {

    @FXML
    private ListView<Driver> listView;

    @FXML
    private Label msgLabel;

    @FXML
    private Label resultsMsgLabel;

    @FXML
    private HBox searchHBox;

    @FXML
    private TextField searchTextField;

    @FXML
    private VBox selectedVBox;

    @FXML
    private VBox titlesVBox;

    @FXML
    private ImageView driverImageView;

    @FXML
    void searchDriver(ActionEvent event) throws IOException, InterruptedException {

        String driverName = searchTextField.getText().trim();
        ApiResponse apiResponse = APIUtility.callAPI(driverName);

        if(apiResponse.getResponse() != null && !driverName.isEmpty()){
            titlesVBox.setVisible(true);
            listView.getItems().clear();
            listView.getItems().addAll(apiResponse.getResponse());
            resultsMsgLabel.setText("Showing " + listView.getItems().size() + " of " + apiResponse.getResults());
            msgLabel.setVisible(false);
        }
        else{
            titlesVBox.setVisible(true);
            listView.getItems().clear();
            resultsMsgLabel.setText("Showing " + listView.getItems().size() + " of " + apiResponse.getResults());
            msgLabel.setVisible(true);
            msgLabel.setText("Enter driver name and press search.");
        }

    }

    @FXML void initialize(){
        selectedVBox.setVisible(false);
        titlesVBox.setVisible(false);
        msgLabel.setVisible(false);

        listView.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, oldValue, driverSelected)->{

                    if(driverSelected != null) {
                        selectedVBox.setVisible(true);
                        try{
                            driverImageView.setImage(new Image(driverSelected.getDriverImage()));
                        }
                        catch(IllegalArgumentException e){
                            driverImageView.setImage(new Image(Main.class.getResourceAsStream("/images/img.png")));
                        }
                    }
                    else {
                        selectedVBox.setVisible(false);
                    }

                });
    }




}
