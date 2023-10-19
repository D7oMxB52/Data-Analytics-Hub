package com.example.app.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class UpgradeUserController implements Initializable {

    String firstName,lastName;

    @FXML
    private Button backToMainMenu_button;

    @FXML
    private Button upgradeToVIP_Button;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        upgradeToVIP_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseController.upgradeToVIP(event, firstName, lastName);
            }
        });
    }
    public void setUserInfo(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}