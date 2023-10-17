package com.example.app.model;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.sql.*;

import static com.example.app.controller.DatabaseController.changeScene;

public class Signup {
    public Signup(ActionEvent event, String username, String password, String firstName, String lastName){
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

            // in case the username does not exist, the database will sign up the user
            else {
                psInsert = connection.prepareStatement("INSERT INTO users (username, password, first_name, last_name) VALUES (?, ?, ?, ? )");
                psInsert.setString(1,username);
                psInsert.setString(2,password);
                psInsert.setString(3,firstName);
                psInsert.setString(4,lastName);
                psInsert.executeUpdate();


                changeScene(event, "mainmenu-view.fxml","Welcomee", username);
            }
        }
        catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("The username is already in use. Please choose another one.");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("user already exist");
            alert.show();
        }
        catch (SQLException e){
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
