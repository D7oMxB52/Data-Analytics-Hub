package com.example.app.model;

import javafx.event.ActionEvent;

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
    public AddNewPost(ActionEvent event, String postId, String content, String author, String likes, String shares, String date){

        String csvFile = "C:\\Users\\devab\\Documents\\GitHub\\Data-Analytics-Hub\\app\\src\\main\\java\\com\\example\\app\\posts.csv";
        Path pathToCsv = Paths.get(csvFile);
        String line = "";
        String delimiter = ",";
        List<Posts> postsList = new ArrayList<>();
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
            newPost.setId(Integer.parseInt(postId));
            newPost.setAuthor(author);
            newPost.setContent(content);
            newPost.setShares(Integer.parseInt(shares));
            newPost.setLikes(Integer.parseInt(likes));
            newPost.setDateTime(date);
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
                    System.out.println("INSIDE WRITERS");

                }
            }catch (IOException e){
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
