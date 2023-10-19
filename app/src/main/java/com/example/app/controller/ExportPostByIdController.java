package com.example.app.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ExportPostByIdController implements Initializable {

    FileChooser fc = new FileChooser();

    @FXML
    private TextField tf_IdToExport;

    @FXML
    private Button backToMainMenu_button;

    @FXML
    private  Button exportPostById_button;

    @FXML
    void export(MouseEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        backToMainMenu_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DatabaseController.changeScene(actionEvent, "mainmenu-view.fxml","Welcome", null);
            }
        });

        exportPostById_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                // to save it from in specific extension (.csv)
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
                fc.getExtensionFilters().add(extFilter);
                File file = fc.showSaveDialog(new Stage());
                DatabaseController.exportPost(event, file, tf_IdToExport.getText());

            }
        });

    }
}
