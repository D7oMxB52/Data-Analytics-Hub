package com.example.app.model;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.sql.*;

import static com.example.app.controller.DatabaseController.changeScene;

public class UpgradeToVIP {
    public  UpgradeToVIP(ActionEvent event, String firstName, String lastName){

        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psUserInfo = null;
        ResultSet resultSet = null;


        // establish a connection to the database
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_db", "root", "root");
            psUserInfo = connection.prepareStatement("SELECT * FROM users WHERE first_name = ? AND last_name = ?");
            psUserInfo.setString(1,"first_name");
            psUserInfo.setString(2,"last_name");
            resultSet = psUserInfo.executeQuery();

            // to check if the username taken or not
            if (resultSet.isBeforeFirst()){
                System.out.println("the user is already exists!!!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use it");
                alert.show();
            }

            // in case the username does not exist, the database will sign up the user
            else {
                psInsert = connection.prepareStatement("UPDATE users SET vip = \"1\"  WHERE first_name = ? AND last_name = ?");
                psInsert.setString(1,firstName);
                psInsert.setString(2,lastName);
                psInsert.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Please log out and log in again to access VIP functionalities.");
                alert.show();
                changeScene(event, "mainmenu-view.fxml","Welcome", firstName,lastName);
            }
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

            if (psUserInfo != null) {
                try{
                    psUserInfo.close();
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
