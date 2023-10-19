package com.example.app.model;

import javafx.event.ActionEvent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExportPostById {

    public ExportPostById(ActionEvent event, File file, String postId){


        FetchPostById f = new FetchPostById(event, postId);

        try {
            // Check if the size of the file is 0 (meaning the file is empty)
            if (file != null) {
                // If the file is empty, create a BufferedWriter to write to the file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                    // Writing the header to the CSV file in case there is new file
                    writer.append("ID,content,author,likes,shares,date-time");
                    writer.newLine();
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                // append new post inside the csv file
                writer.append(postId
                        + "," + f.FetchPostById(event, postId).getContent()
                        + "," + f.FetchPostById(event, postId).getAuthor()
                        + "," + f.FetchPostById(event, postId).getLikes()
                        + "," + f.FetchPostById(event, postId).getShares()
                        + "," + f.FetchPostById(event, postId).getDateTime());
                writer.newLine();

            }
        }catch (IOException e){
            e.printStackTrace();
        }
        catch (NullPointerException e){
            System.out.println("ID does not exist");
        }

    }



}
