package com.example.f23comp1011assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class PageOneViewController {

    @FXML
    private ListView<?> listView;

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
        APIUtility.callAPI(driverName);
    }

    @FXML void initialize(){
        selectedVBox.setVisible(false);
        titlesVBox.setVisible(false);
        msgLabel.setVisible(false);
    }



}
