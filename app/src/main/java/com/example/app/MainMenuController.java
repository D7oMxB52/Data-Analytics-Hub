package com.example.app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    private Label filled_username;


    @FXML
    private Button logout_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logout_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DatabaseController.changeScene(actionEvent, "landing-view.fxml","Logged out", null);
            }
        });
    }

    public void setUserInfo(String username){
        filled_username.setText(username);
    }
}