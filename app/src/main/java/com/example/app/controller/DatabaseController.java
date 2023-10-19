package com.example.app.controller;
import com.example.app.model.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class DatabaseController {


    public static void changeScene(ActionEvent event, String fxmlFile,String title, String firstName, String lastName){


        Parent root = null;

        // scene loader
        if (firstName != null){
            try{
                FXMLLoader loader = new FXMLLoader(DatabaseController.class.getResource(fxmlFile));
                root = loader.load();
                MainMenuController mainMenuController = loader.getController();
                mainMenuController.setUserInfo(firstName, lastName);


            }   catch (IOException e){
                e.printStackTrace();
            }
        } else {
            try{
                root = FXMLLoader.load(DatabaseController.class.getResource(fxmlFile));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 800,569));
        stage.show();
    }


    // signup method
    public static void signUp(ActionEvent event, String username, String password, String firstName, String lastName){

        Signup signup = new Signup(event, username, password, firstName, lastName);

    }


    // Login Method
    public static void login(ActionEvent event, String username, String password){

        Login login = new Login(event, username, password);

    }

    //edit Method
    public static void editProfile(ActionEvent event, String username, String newUsername, String password, String firstName, String lastName){

        EditProfile editProfile = new EditProfile(event, username, newUsername, password, firstName, lastName);

    }

    public static void addNewPost(ActionEvent event, String postId, String content, String author, String likes, String shares, String date, String path){

        AddNewPost addNewPost = new AddNewPost(event, postId, content, author, likes, shares, date, path);

    }




    public static Posts getPostById(ActionEvent event, String postId){

        FetchPostById f = new FetchPostById(event, postId);
        return f.FetchPostById(event, postId);

    }

    public static void deletePost(ActionEvent event, String postId){

        Delete delete = new Delete(postId);

    }

    public static StringBuilder mostLikes(ActionEvent event, int n_likes){

        TopNLikes topNLikes = new TopNLikes();
        return topNLikes.TopNLikes(n_likes);

    }

    public static void exportPost(ActionEvent event, File file, String postId){

        ExportPostById exportPostById = new ExportPostById(event, file,postId);

    }
}
