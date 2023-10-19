package com.example.app.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class getMostLikesController implements Initializable {

    @FXML
    private Button backToMainMenu_button;

    @FXML
    private TextField tf_mostLikes;

    @FXML
    private Button getMostLikePosts_Button;

    @FXML
    private Label t_posts;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        backToMainMenu_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DatabaseController.changeScene(actionEvent, "mainmenu-view.fxml","Welcome", null);
            }
        });

        getMostLikePosts_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t_posts.setText(DatabaseController.mostLikes(event, Integer.parseInt(tf_mostLikes.getText())).toString());
            }
        });
    }
}
