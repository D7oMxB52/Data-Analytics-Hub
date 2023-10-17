package com.example.app.model;

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

public class Delete {

    public Delete(String postId){
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

            //lambda function to delete the post by id
            postsList.removeIf(post -> post.getId() == Integer.parseInt(postId));

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
                // Writing the header
                writer.write("ID,content,author,likes,shares,date-time");
                writer.newLine();

                // Writing updated posts
                for (Posts post : postsList) {
                    writer.append(post.getId()
                            + "," + post.getContent()
                            + "," + post.getAuthor()
                            + "," + post.getLikes()
                            + "," + post.getShares()
                            + "," + post.getDateTime());
                    writer.newLine();
                    System.out.println("INSIDE WRITERS");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
