package com.example.app.controller;

import com.example.app.model.Posts;
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

public class SearchPostByIdController implements Initializable {



    @FXML
    private TextField tf_insertedPostId;

    @FXML
    private Label t_content;

    @FXML
    private Label t_author;

    @FXML
    private Label t_likes;

    @FXML
    private Label t_shares;

    @FXML
    private Label t_date;


    @FXML
    private Button searchPostById_Button;

    @FXML
    private Button backToMainMenu_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try{
            searchPostById_Button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Posts fetchedPost = DatabaseController.getPostById(event, tf_insertedPostId.getText());
                    t_content.setText(fetchedPost.getContent());
                    t_author.setText(fetchedPost.getAuthor());
                    t_shares.setText(Integer.toString(fetchedPost.getShares()));
                    t_likes.setText(Integer.toString(fetchedPost.getLikes()));
                    t_date.setText(fetchedPost.getDateTime());
                    System.out.println(fetchedPost.getDateTime());


                }
            });
        } catch (NullPointerException e){
            System.out.println("Caught in controller");
            Alert alert_2 = new Alert(Alert.AlertType.ERROR);
            alert_2.setContentText("Post ID does not exist!");
            alert_2.show();
        }


        backToMainMenu_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DatabaseController.changeScene(actionEvent, "mainmenu-view.fxml","Welcome", null,null);
            }
        });


    }

}
