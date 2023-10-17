package com.example.app.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TopNLikes {
    public StringBuilder TopNLikes(int n_likes){
        String csvFile = "C:\\Users\\devab\\Documents\\GitHub\\Data-Analytics-Hub\\app\\src\\main\\java\\com\\example\\app\\posts.csv";
        Path pathToCsv = Paths.get(csvFile);
        String line = "";
        String delimiter = ",";
        List<Posts> postsList = new ArrayList<>();
        StringBuilder posts = new StringBuilder();
        // reading csv file
        try (BufferedReader br = Files.newBufferedReader(pathToCsv)) {
            // skipping the header
            br.readLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(delimiter);
                postsList.add(new Posts(Integer.parseInt(fields[0]), fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), fields[5]));
            }
            postsList.sort(Comparator.comparingInt(Posts::getLikes).reversed());
            for (int i = 0; i < n_likes; i++){

                posts.append(i+1+": ");
                posts.append("ID:" + postsList.get(i).getId());
                posts.append(", Author: " + postsList.get(i).getAuthor());
                posts.append(", Likes: " + postsList.get(i).getLikes());
                posts.append("\n");


            }
            System.out.println(posts);
            return posts;




        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}

