package com.aleksiyflekssiy.base.controller;

import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileController {

    File path;
    FileChooser fileChooser = new FileChooser();

    Pane pane;
    TextArea textArea;

    public FileController(Pane pane, TextArea textArea){
        this.pane = pane;
        this.textArea = textArea;
    }

    public void open() throws IOException {

        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
        File file = fileChooser.showOpenDialog(pane.getScene().getWindow());
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
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setTitle(path.getName()+" - Notepad");
    }

    public void saveAs() throws IOException {
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
        File data = fileChooser.showSaveDialog(pane.getScene().getWindow());
        if (data.exists()) {
            Files.createFile(data.toPath());
        }
        Files.writeString(data.toPath(),textArea.getText());
        path = data;
    }}
