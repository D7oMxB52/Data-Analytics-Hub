package com.example.app.controller;

import com.example.app.controller.DatabaseController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button login_button;

    @FXML
    private Button signup_button;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        login_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DatabaseController.changeScene(actionEvent, "login-view.fxml","Login Page",null,null);
            }
        });

        signup_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DatabaseController.changeScene(actionEvent, "signup-view.fxml","signup Page",null,null);

            }
        });

    }
}