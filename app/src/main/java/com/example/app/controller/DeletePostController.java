package com.example.app.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DeletePostController implements Initializable {


    @FXML
    private TextField tf_insertedPostIdToDelete;

    @FXML
    private Label t_status;
    @FXML
    private Button deletePostById_Button;

    @FXML
    private Button backToMainMenu_button;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        backToMainMenu_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DatabaseController.changeScene(actionEvent, "mainmenu-view.fxml","Welcomee", null);
            }
        });

        deletePostById_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseController.deletePost(event, tf_insertedPostIdToDelete.getText());
            }
        });
    }
}
