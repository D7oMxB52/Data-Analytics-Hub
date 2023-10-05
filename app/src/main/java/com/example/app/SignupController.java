package com.example.app;

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

public class SignupController implements Initializable {

    @FXML
    private Button backToMenu_button;

    @FXML
    private Button singingUp_button;
    @FXML
    private TextField tf_username;
     @FXML
    private TextField tf_password;
     @FXML
    private TextField tf_firstName;
     @FXML
    private TextField tf_lastName;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        backToMenu_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DatabaseController.changeScene(actionEvent, "landing-view.fxml","Landing page",null);
            }
        });

        singingUp_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //if the contents filled and not empty
                if (!tf_username.getText().trim().isEmpty() &&
                    !tf_password.getText().trim().isEmpty() &&
                    !tf_firstName.getText().trim().isEmpty() &&
                    !tf_lastName.getText().trim().isEmpty())   {

                    DatabaseController.signUp(actionEvent, tf_username.getText(),
                                                           tf_password.getText(),
                                                           tf_firstName.getText(),
                                                           tf_lastName.getText());
                }

                else {
                    System.out.println("Please fill the the blanks");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("you need to fill all the blanks to sign up");
                    alert.show();
                }
            }
        });


    }
}
