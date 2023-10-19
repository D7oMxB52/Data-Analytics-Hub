package com.example.app.model;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AddNewPost {
    public AddNewPost(ActionEvent event, String postId, String content, String author, String likes, String shares, String date, String path){

        String csvFile = path;
        Path pathToCsv = Paths.get(csvFile);
        String line = "";
        String delimiter = ",";
        List<Posts> postsList = new ArrayList<>();
        boolean validPost = true;
        // reading csv file
        try (BufferedReader br = Files.newBufferedReader(pathToCsv)) {
            // skipping the header
            br.readLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(delimiter);
                postsList.add(new Posts(Integer.parseInt(fields[0]), fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), fields[5]));
            }

            Posts newPost = new Posts();


            if(Integer.parseInt(postId) >= 0 ){
                newPost.setId(Integer.parseInt(postId));
            } else{
                validPost = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please insert ID , must be a positive number ");
                alert.show();
            }

            newPost.setAuthor(author);
            newPost.setContent(content);

            if(Integer.parseInt(shares) >= 0 ){
                newPost.setShares(Integer.parseInt(shares));
            } else{
                validPost = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please insert valid number of shares");
                alert.show();
            }

            if(Integer.parseInt(likes) >= 0){
                newPost.setLikes(Integer.parseInt(likes));
            } else{
                validPost = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please insert valid number of likes");
                alert.show();
            }



            TimeValidator isValidDate = new TimeValidator(date);
            if (isValidDate.isValidDate(date)){
                newPost.setDateTime(date);

            } else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("WRONG DATE FORMAT");
                alert.show();
                validPost = false;
            }

            if (validPost){

                postsList.add(newPost);

                System.out.println("The post has been added to the collection!");

                System.out.println(newPost);

                try {
                    // Check if the size of the file is 0 (meaning the file is empty)
                    if (Files.size(Paths.get(csvFile)) == 0) {
                        // If the file is empty, create a BufferedWriter to write to the file
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true))) {
                            // Writing the header to the CSV file in case there is new file
                            writer.append("ID,content,author,likes,shares,date-time");
                            writer.newLine();
                        }
                    }

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true))) {
                        // append new post inside the csv file
                        writer.append(newPost.getId()
                                + "," + newPost.getContent()
                                + "," + newPost.getAuthor()
                                + "," + newPost.getLikes()
                                + "," + newPost.getShares()
                                + "," + newPost.getDateTime());
                        writer.newLine();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Post has been Added  !");
                        alert.show();

                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please insert valid input");
                alert.show();
            }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("ID, Likes, and shares must be numbers");
            alert.show();
        }


    }

    public AddNewPost() {

    }
}
