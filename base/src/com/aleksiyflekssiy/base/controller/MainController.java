package com.aleksiyflekssiy.base.controller;

import com.aleksiyflekssiy.base.MainApplication;
import com.aleksiyflekssiy.base.inject.Injector;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {

    @FXML
    AnchorPane pane;
    @FXML
    TextArea textArea;
    @FXML
    MenuItem appear;
    @FXML
    ImageView imageView;
    int fontSize = 18;
    private FileController fileController;
    private final MainApplication mainApplication;
    private AppearanceController appearanceController;

    public MainController(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

    public void openFile() throws IOException {
        fileController.open();
    }

    public void saveFile() throws IOException {
        fileController.save();
    }

    public void saveAsFile() throws IOException {
        fileController.saveAs();
    }

    public void close() {
        Platform.exit();
    }

    public void increaseFontSize() {
        if(fontSize <= 50){
            appearanceController.increaseFontSize();
        }
    }

    public void decreaseFontSize() {
        if (fontSize >= 10) {
            appearanceController.decreaseFontSize();
        }
    }
    public void setAppearanceController(AppearanceController appearanceController){
        this.appearanceController = appearanceController;
    }

    public void openAppearanceWindow(){
        try {
            mainApplication.openAppearanceWindow();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void initialize() {
        appearanceController = Injector.getInstance(AppearanceController.class);
        fileController = new FileController(pane, textArea);
    }

    public void contextMenu(){

    }
}