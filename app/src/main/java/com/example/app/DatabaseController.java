package com.example.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

public class DatabaseController {

    public static void changeScene(ActionEvent event, String fxmlFile,String title, String username){

        Parent root = null;

        // scene loader
        if (username != null){
            try{
                FXMLLoader loader = new FXMLLoader(DatabaseController.class.getResource(fxmlFile));
                root = loader.load();
                MainMenuController mainMenuController = loader.getController();
                mainMenuController.setUserInfo(username);
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
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }


    // signup method
    public static void signUp(ActionEvent event, String username, String password, String firstName, String lastName){
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psUserAlreadyExist = null;
        ResultSet resultSet = null;


        // establish a connection to the database
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_db", "root", "root");
            psUserAlreadyExist = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            psUserAlreadyExist.setString(1,"username");
            resultSet = psUserAlreadyExist.executeQuery();

            // to check if the username taken or not
            if (resultSet.isBeforeFirst()){
                System.out.println("the user is already exists!!!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use it");
                alert.show();
            }

            // in case the username does not exist, the database will signup the user
            else {
                psInsert = connection.prepareStatement("INSERT INTO users (username, password, firstName, lastName VALUES (?, ?, ?, ? ))");
                psInsert.setString(1,username);
                psInsert.setString(2,password);
                psInsert.setString(3,firstName);
                psInsert.setString(4,lastName);
                psInsert.executeQuery();


                changeScene(event, "login-view.fxml","Welcomee", username);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        // to close the connection to avoid memory leaks
          finally {
            if (resultSet != null) {
                try{
                    resultSet.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (psUserAlreadyExist != null) {
                try{
                    psUserAlreadyExist.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try{
                    connection.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (psInsert != null) {
                try{
                    psInsert.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }

        }
    }
}
