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

public class DriverSearchController{

    //FXML annotations to inject components from FXML file
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
    private Label headerLabel;

    //Method triggered when the "Search" button is pressed
    @FXML
    void searchDriver(ActionEvent event) throws IOException, InterruptedException {

        //Retrieve the driver name from the search text field
        String driverName = searchTextField.getText().trim();

        //Call the Formula 1 API to get information about the driver
        ApiResponse apiResponse = APIUtility.callAPI(driverName);

        //Check if the API response contains data and the search text is not empty
        if (apiResponse.getResponse() != null && !driverName.isEmpty()) {
            //Show the titles VBox, clear the list view, add the API response data to the list view
            titlesVBox.setVisible(true);
            listView.getItems().clear();
            listView.getItems().addAll(apiResponse.getResponse());
            headerLabel.setVisible(false);

            //Update the results message label and hide the error message label
            resultsMsgLabel.setText("Showing " + listView.getItems().size() + " of " + apiResponse.getResults());
            msgLabel.setVisible(false);
        } else {
            //Show the titles VBox, clear the list view, update the results message label, show the error message label
            titlesVBox.setVisible(true);
            listView.getItems().clear();
            headerLabel.setVisible(true);
            resultsMsgLabel.setText("Showing " + listView.getItems().size() + " of " + apiResponse.getResults());
            msgLabel.setVisible(true);
            msgLabel.setText("Enter driver name and press search.");
        }
    }

    //Method called during the initialization of the controller
    @FXML
    void initialize() {
        //Hide the selected VBox, titles VBox, and error message label
        selectedVBox.setVisible(false);
        titlesVBox.setVisible(false);
        msgLabel.setVisible(false);

        //Listener for selection changes in the list view
        listView.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, oldValue, driverSelected) -> {
                    //Check if a driver is selected
                    if (driverSelected != null) {
                        //Show the selected VBox and set the driver's image
                        selectedVBox.setVisible(true);
                        try {
                            driverImageView.setImage(new Image(driverSelected.getDriverImage()));
                        } catch (IllegalArgumentException e) {
                            //Handle the case where the image is not found
                            driverImageView.setImage(new Image(Main.class.getResourceAsStream("/images/img.png")));
                        }
                    } else {
                        //Hide the selected VBox if no driver is selected
                        selectedVBox.setVisible(false);
                    }
                });
    }

    //When the details button is pressed it changes scenes to the details page
    @FXML
    void getDriverDetails(ActionEvent event) throws IOException, InterruptedException {
        Driver driverSelected = listView.getSelectionModel().getSelectedItem();
        SceneChanger.changeScenes(event, "driver-details.fxml", driverSelected.getDriverId());
    }
}
