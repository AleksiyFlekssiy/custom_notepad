package com.example.custom_notepad;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HelloController {

    @FXML
    AnchorPane pane;

    @FXML
    TextArea textArea;
    @FXML
    MenuItem openFile;
    @FXML
    MenuItem saveFile;
    @FXML
    MenuItem saveAsFile;
    @FXML
    MenuItem closeFile;
    @FXML

    FileChooser FC = new FileChooser();

    File path;

    int fontSize = 18;

    public void open() throws IOException {

        FC.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
        File file = FC.showOpenDialog(pane.getScene().getWindow());
        List<String> strings = Files.readAllLines(Path.of(String.valueOf(file)));
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string).append("\n");
        }
        textArea.setText(stringBuilder.toString());

        path = file;
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setTitle(path.getName()+" - Notepad");
    }

    public void save() throws IOException {
        if (path != null) Files.writeString(path.toPath(), textArea.getText());
        else saveAs();
    }

    public void saveAs() throws IOException {
        FC.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
        File data = FC.showSaveDialog(pane.getScene().getWindow());
        if (data.exists()) {
            Files.createFile(data.toPath());
        }
        Files.writeString(data.toPath(),textArea.getText());
    }
    public void close(){
        Platform.exit();
    }

    public void fontplus(){
        fontSize++;
        textArea.setStyle("-fx-font-size: "+fontSize+" ");
    }
    public void fontminus(){
        if (fontSize >= 10) {
            fontSize--;
            textArea.setStyle("-fx-font-size: "+fontSize+" ");
        }
    }
}