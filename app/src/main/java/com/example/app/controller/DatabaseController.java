package com.example.app.controller;
import com.example.app.model.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
//                EditProfileController editProfileController = loader.getController();
//                editProfileController.setUserInfo(username);

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
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }


    // signup method
    public static void signUp(ActionEvent event, String username, String password, String firstName, String lastName){

        Signup signup = new Signup(event, username, password, firstName, lastName);


//        Connection connection = null;
//        PreparedStatement psInsert = null;
//        PreparedStatement psUserAlreadyExist = null;
//        ResultSet resultSet = null;
//
//
//        // establish a connection to the database
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_db", "root", "root");
//            psUserAlreadyExist = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
//            psUserAlreadyExist.setString(1,"username");
//            resultSet = psUserAlreadyExist.executeQuery();
//
//            // to check if the username taken or not
//            if (resultSet.isBeforeFirst()){
//                System.out.println("the user is already exists!!!");
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("You cannot use it");
//                alert.show();
//            }
//
//            // in case the username does not exist, the database will sign up the user
//            else {
//                psInsert = connection.prepareStatement("INSERT INTO users (username, password, first_name, last_name) VALUES (?, ?, ?, ? )");
//                psInsert.setString(1,username);
//                psInsert.setString(2,password);
//                psInsert.setString(3,firstName);
//                psInsert.setString(4,lastName);
//                psInsert.executeUpdate();
//
//
//                changeScene(event, "mainmenu-view.fxml","Welcomee", username);
//            }
//        }
//        catch (SQLIntegrityConstraintViolationException e) {
//            System.out.println("The username is already in use. Please choose another one.");
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("user already exist");
//            alert.show();
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//        // to close the connection to avoid memory leaks
//          finally {
//            if (resultSet != null) {
//                try{
//                    resultSet.close();
//                } catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//
//            if (psUserAlreadyExist != null) {
//                try{
//                    psUserAlreadyExist.close();
//                } catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//
//            if (connection != null){
//                try{
//                    connection.close();
//                } catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//
//            if (psInsert != null) {
//                try{
//                    psInsert.close();
//                } catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//
//        }
    }


    // Login Method
    public static void login(ActionEvent event, String username, String password){

        Login login = new Login(event, username, password);

//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_db", "root", "root");
//            statement = connection.prepareStatement("SELECT password FROM users WHERE username = ?");
//            statement.setString(1, username);
//            resultSet = statement.executeQuery();
//
//            // if the username does not exist:
//            if (!resultSet.isBeforeFirst()){
//                System.out.println("the inserted username does not exits");
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("incorrect credentials");
//                alert.show();
//            }
//            //in case the username do exist:
//            else {
//                while (resultSet.next()){
//                    String fetchPassword = resultSet.getString("password");
//                    System.out.println(fetchPassword);
//
//                    // if the password is correct:
//                    if (fetchPassword.equals(password)){
//                        System.out.println(fetchPassword.equals(password));
//                        changeScene(event, "mainmenu-view.fxml", "Welcome!", username);
//                    }
//                    // if the password is incorrect:
//                    else {
//                        System.out.println("password is not correct");
//                        Alert alert = new Alert(Alert.AlertType.ERROR);
//                        alert.setContentText("incorrect credentials");
//                        alert.show();
//                    }
//                }
//            }
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
//        finally {
//            if (resultSet != null) {
//                try{
//                    resultSet.close();
//                } catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//
//            if (statement != null) {
//                try{
//                    statement.close();
//                } catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//
//            if (connection != null) {
//                try{
//                    connection.close();
//                } catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//        }

    }

    //edit Method
    public static void editProfile(ActionEvent event, String username, String newUsername, String password, String firstName, String lastName){

        EditProfile editProfile = new EditProfile(event, username, newUsername, password, firstName, lastName);

//        Connection connection = null;
//        PreparedStatement psInsert = null;
//        PreparedStatement psUserInfo = null;
//        ResultSet resultSet = null;
//
//
//        // establish a connection to the database
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_db", "root", "root");
//            psUserInfo = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
//            psUserInfo.setString(1,"username");
//            resultSet = psUserInfo.executeQuery();
//
//            // to check if the username taken or not
//            if (resultSet.isBeforeFirst()){
//                System.out.println("the user is already exists!!!");
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("You cannot use it");
//                alert.show();
//            }
//
//            // in case the username does not exist, the database will sign up the user
//            else {
//                psInsert = connection.prepareStatement("UPDATE users SET username = ?, password = ?, first_name = ?, last_name = ? WHERE username = ?");
//                psInsert.setString(1,newUsername);
//                psInsert.setString(2,password);
//                psInsert.setString(3,firstName);
//                psInsert.setString(4,lastName);
//                psInsert.setString(5,username);
//                System.out.println(psInsert.executeUpdate());
//                psInsert.executeUpdate();
//
//                changeScene(event, "mainmenu-view.fxml","Welcomee", newUsername);
//            }
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//        // to close the connection to avoid memory leaks
//        finally {
//            if (resultSet != null) {
//                try{
//                    resultSet.close();
//                } catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//
//            if (psUserInfo != null) {
//                try{
//                    psUserInfo.close();
//                } catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//
//            if (connection != null){
//                try{
//                    connection.close();
//                } catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//
//            if (psInsert != null) {
//                try{
//                    psInsert.close();
//                } catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//
//        }
    }

    public static void addNewPost(ActionEvent event, String postId, String content, String author, String likes, String shares, String date){

        AddNewPost addNewPost = new AddNewPost(event, postId, content, author, likes, shares, date);

//        String csvFile = "C:\\Users\\devab\\Documents\\GitHub\\Data-Analytics-Hub\\app\\src\\main\\java\\com\\example\\app\\posts.csv";
//        Path pathToCsv = Paths.get(csvFile);
//        String line = "";
//        String delimiter = ",";
//        List<Posts> postsList = new ArrayList<>();
//        // reading csv file
//        try (BufferedReader br = Files.newBufferedReader(pathToCsv)) {
//            // skipping the header
//            br.readLine();
//
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
//            while ((line = br.readLine()) != null) {
//                String[] fields = line.split(delimiter);
//                postsList.add(new Posts(Integer.parseInt(fields[0]), fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), fields[5]));
//            }
//
//            Posts newPost = new Posts();
//            newPost.setId(Integer.parseInt(postId));
//            newPost.setAuthor(author);
//            newPost.setContent(content);
//            newPost.setShares(Integer.parseInt(shares));
//            newPost.setLikes(Integer.parseInt(likes));
//            newPost.setDateTime(date);
//            postsList.add(newPost);
//
//            System.out.println("The post has been added to the collection!");
//
//            System.out.println(newPost);
//
//            try {
//                // Check if the size of the file is 0 (meaning the file is empty)
//                if (Files.size(Paths.get(csvFile)) == 0) {
//                    // If the file is empty, create a BufferedWriter to write to the file
//                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true))) {
//                        // Writing the header to the CSV file in case there is new file
//                        writer.append("ID,content,author,likes,shares,date-time");
//                        writer.newLine();
//                    }
//                }
//
//                try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true))) {
//                    // append new post inside the csv file
//                    writer.append(newPost.getId()
//                            + "," + newPost.getContent()
//                            + "," + newPost.getAuthor()
//                            + "," + newPost.getLikes()
//                            + "," + newPost.getShares()
//                            + "," + newPost.getDateTime());
//                    writer.newLine();
//                    System.out.println("INSIDE WRITERS");
//
//                }
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }




    public static Posts getPostById(ActionEvent event, String postId){

        FetchPostById f = new FetchPostById(event, postId);
        return f.FetchPostById(event, postId);

//        String csvFile = "C:\\Users\\devab\\Documents\\GitHub\\Data-Analytics-Hub\\app\\src\\main\\java\\com\\example\\app\\posts.csv";
//        Path pathToCsv = Paths.get(csvFile);
//        String line = "";
//        String delimiter = ",";
//        List<Posts> postsList = new ArrayList<>();
//
//        // reading csv file
//        try (BufferedReader br = Files.newBufferedReader(pathToCsv)) {
//            // skipping the header
//            br.readLine();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
//            while ((line = br.readLine()) != null) {
//                String[] fields = line.split(delimiter);
//                postsList.add(new Posts(Integer.parseInt(fields[0]), fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), fields[5]));
//            }
//
//            Search searchById = new Search(postId , postsList);
//            return searchById.searchById();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
    }

    public static void deletePost(ActionEvent event, String postId){

        Delete delete = new Delete(postId);

//        String csvFile = "C:\\Users\\devab\\Documents\\GitHub\\Data-Analytics-Hub\\app\\src\\main\\java\\com\\example\\app\\posts.csv";
//        Path pathToCsv = Paths.get(csvFile);
//        String line = "";
//        String delimiter = ",";
//        List<Posts> postsList = new ArrayList<>();
//        // reading csv file
//        try (BufferedReader br = Files.newBufferedReader(pathToCsv)) {
//            // skipping the header
//            br.readLine();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
//            while ((line = br.readLine()) != null) {
//                String[] fields = line.split(delimiter);
//                postsList.add(new Posts(Integer.parseInt(fields[0]), fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), fields[5]));
//            }
//
//            //lambda function to delete the post by id
//            postsList.removeIf(post -> post.getId() == Integer.parseInt(postId));
//
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
//                // Writing the header
//                writer.write("ID,content,author,likes,shares,date-time");
//                writer.newLine();
//
//                // Writing updated posts
//                for (Posts post : postsList) {
//                    writer.append(post.getId()
//                            + "," + post.getContent()
//                            + "," + post.getAuthor()
//                            + "," + post.getLikes()
//                            + "," + post.getShares()
//                            + "," + post.getDateTime());
//                    writer.newLine();
//                    System.out.println("INSIDE WRITERS");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//

    }

    public static StringBuilder mostLikes(ActionEvent event, int n_likes){

        TopNLikes topNLikes = new TopNLikes();
        return topNLikes.TopNLikes(n_likes);


//        String csvFile = "C:\\Users\\devab\\Documents\\GitHub\\Data-Analytics-Hub\\app\\src\\main\\java\\com\\example\\app\\posts.csv";
//        Path pathToCsv = Paths.get(csvFile);
//        String line = "";
//        String delimiter = ",";
//        List<Posts> postsList = new ArrayList<>();
//        StringBuilder posts = new StringBuilder();
//        // reading csv file
//        try (BufferedReader br = Files.newBufferedReader(pathToCsv)) {
//            // skipping the header
//            br.readLine();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
//            while ((line = br.readLine()) != null) {
//                String[] fields = line.split(delimiter);
//                postsList.add(new Posts(Integer.parseInt(fields[0]), fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), fields[5]));
//            }
//            postsList.sort(Comparator.comparingInt(Posts::getLikes).reversed());
//            for (int i = 0; i < n_likes; i++){
//
//                posts.append(i+1+": ");
//                posts.append("ID:" + postsList.get(i).getId());
//                posts.append(", Author: " + postsList.get(i).getAuthor());
//                posts.append(", Likes: " + postsList.get(i).getLikes());
//                posts.append("\n");
//
//
//            }
//            System.out.println(posts);
//            return posts;
//
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;

    }

}
