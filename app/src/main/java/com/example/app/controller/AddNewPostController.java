package com.example.app.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AddNewPostController implements Initializable {


    FileChooser fc = new FileChooser();

    @FXML
    private TextField tf_postId;

    @FXML
    private TextField tf_content;

    @FXML
    private TextField tf_author;

    @FXML
    private TextField tf_likes;

    @FXML
    private TextField tf_shares;

    @FXML
    private TextField tf_date;

    @FXML
    private Button addThePost_button;

    @FXML
    private Button backToMainMenu_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        backToMainMenu_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DatabaseController.changeScene(actionEvent, "mainmenu-view.fxml","Welcome", null,null);
            }
        });

            addThePost_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File file = fc.showOpenDialog(new Stage());
                DatabaseController.addNewPost(event,
                        tf_postId.getText(),
                        tf_content.getText(),
                        tf_author.getText(),
                        tf_likes.getText(),
                        tf_shares.getText(),
                        tf_date.getText(),
                        file.getPath()
                        );
                System.out.println(file.getPath());
            }
        });

    }
}
