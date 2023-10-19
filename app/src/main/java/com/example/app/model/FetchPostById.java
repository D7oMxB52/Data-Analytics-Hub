package com.example.app.model;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FetchPostById {

    private ActionEvent ev;

    private String postId;
    public FetchPostById(ActionEvent event, String postId) {
        this.ev = event;
        this.postId = postId;
    }



    public Posts FetchPostById(ActionEvent ev, String postId){
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

            Search searchById = new Search(postId , postsList);
            if (searchById.searchById() == null){
                throw new NullPointerException();
            }
            return searchById.searchById();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Post ID must be a number!");
            alert.show();

        } catch (NullPointerException e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Post ID does not Exist!");
            alert.show();


        }

        return null;

    }
}
