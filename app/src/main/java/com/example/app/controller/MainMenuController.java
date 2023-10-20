package com.example.app.controller;

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
    public Label fill_firstName;

    @FXML
    public Label fill_lastName;

    @FXML
    private Button logout_button;

    @FXML
    private Button editprofile_button;

    @FXML
    private Button addNewPost_button;

    @FXML
    private Button getPostById_button;

    @FXML
    private Button deletePostById_button;

    @FXML
    private Button getTopNLikes_button;

    @FXML
    private Button exportPostById_button;

    @FXML
    private Button upgradeToVIPView_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logout_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DatabaseController.changeScene(actionEvent, "landing-view.fxml","Logged out", null,null);
            }
        });

        editprofile_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DatabaseController.changeScene(actionEvent, "profile_edit-view.fxml","Edit profile", null,null);
            }
        });

        addNewPost_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseController.changeScene(event, "add_new_post-view.fxml", "Add new Post", null,null);
            }
        });

        getPostById_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseController.changeScene(event, "get_post_by_id-view.fxml", "Get User's Post", null,null);
            }
        });

        deletePostById_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseController.changeScene(event, "delete_post-view.fxml", "Delete Post", null,null);
            }
        });

        getTopNLikes_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseController.changeScene(event, "get_most_likes-view.fxml", "Get Top N Likes", null,null);
            }
        });

        exportPostById_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseController.changeScene(event,"export_post-view.fxml","Export Post", null,null);
            }
        });
        upgradeToVIPView_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseController.changeScene(event, "upgrade-view.fxml", "UPGRADE TO VIP", null, null);
            }
        });


    }

    public void setUserInfo(String firstName, String lastName){
        fill_firstName.setText(firstName);
        fill_lastName.setText(lastName);
    }
}
