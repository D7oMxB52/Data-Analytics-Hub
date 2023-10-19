package com.example.app.model;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.sql.*;

import static com.example.app.controller.DatabaseController.changeScene;

public class Login {
    public Login(ActionEvent event, String username, String password){

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_db", "root", "root");
            statement = connection.prepareStatement("SELECT password, first_name, last_name FROM users WHERE username = ?");
            statement.setString(1, username);
            resultSet = statement.executeQuery();

            // if the username does not exist:
            if (!resultSet.isBeforeFirst()){
                System.out.println("the inserted username does not exits");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("the inserted username does not exits, incorrect credentials");
                alert.show();
            }
            //in case the username do exist:
            else {
                while (resultSet.next()){
                    String fetchPassword = resultSet.getString("password");
                    String fetchedFirstName = resultSet.getString("first_name");
                    String fetchedLastName = resultSet.getString("last_name");
                    System.out.println(fetchPassword);

                    // if the password is correct:
                    if (fetchPassword.equals(password)){
                        System.out.println(fetchPassword.equals(password));
                        changeScene(event, "mainmenu-view.fxml", "Welcome!", fetchedFirstName, fetchedLastName);
                    }
                    // if the password is incorrect:
                    else {
                        System.out.println("password is not correct");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("incorrect credentials");
                        alert.show();
                    }
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if (resultSet != null) {
                try{
                    resultSet.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try{
                    statement.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try{
                    connection.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }


    }
}
