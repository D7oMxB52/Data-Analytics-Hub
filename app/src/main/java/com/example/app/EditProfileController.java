package com.example.app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditProfileController implements Initializable {


    @FXML
    private TextField tf_usernameToConfirm;
    @FXML
    private TextField tf_newUsername;
    @FXML
    private TextField tf_newPassword;
    @FXML
    private TextField tf_newFirstName;
    @FXML
    private TextField tf_newLastName;

    @FXML
    private Button editProfile_button;

    @FXML
    private Button backToMainMenu_button;

    @FXML
    private Label usern ;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        backToMainMenu_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DatabaseController.changeScene(actionEvent, "mainmenu-view.fxml","Welcomee", null);
            }
        });

        editProfile_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(usern.getText());
                DatabaseController.editProfile(actionEvent, tf_usernameToConfirm.getText(), tf_newUsername.getText(), tf_newPassword.getText(), tf_newFirstName.getText(),tf_newLastName.getText());
            }
        });
    }
    public void setUserInfo(String username){
        usern.setText(username);
    }
}
