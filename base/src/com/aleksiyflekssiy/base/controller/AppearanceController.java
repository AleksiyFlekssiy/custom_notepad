package com.aleksiyflekssiy.base.controller;

import com.aleksiyflekssiy.base.inject.Injector;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.File;

public class AppearanceController {

    @FXML
    ColorPicker backgroundColorPicker;
    @FXML
    ColorPicker textColorPicker;
    @FXML
    Button backgroundImageButton;

    Pane pane;

    ImageView imageView;

    TextArea textArea;
    private MainController mainController;
    private String backgroundColor = "White";
    private String textColor = "Black";

    private Image backgroundImage = null;
    private int fontSize;


    public AppearanceController(){

    }

    public void setImage(){
        imageView.fitWidthProperty().bind(pane.widthProperty());
        imageView.fitHeightProperty().bind(pane.heightProperty());
        File file = new FileChooser().showOpenDialog(null);
        String path = file.toURI().toString();
        System.out.println(path);
        backgroundImage = new Image(path);
        imageView.setImage(backgroundImage);
    }

    public void initialize(){
        this.mainController = Injector.getInstance(MainController.class);
        this.pane = mainController.pane;
        this.imageView = mainController.imageView;
        this.textArea = mainController.textArea;
        this.fontSize = (int) textArea.getFont().getSize();
        mainController.setAppearanceController(this);
    }

    public void setBackgroundColor(){
        Color color = backgroundColorPicker.getValue();
        int red = (int) Math.round(color.getRed() * 255);
        int green = (int) Math.round(color.getGreen() * 255);
        int blue = (int) Math.round(color.getBlue() * 255);
        backgroundColor = String.format("#%02X%02X%02X", red, green, blue);
        textArea.setStyle("-fx-control-inner-background: "+backgroundColor + ";" +
                          "-fx-text-fill: " + textColor + ";" +
                          "-fx-font-size: " + fontSize);
    }
    public void setTextColor(){
        Color color = textColorPicker.getValue();
        int red = (int) Math.round(color.getRed() * 255);
        int green = (int) Math.round(color.getGreen() * 255);
        int blue = (int) Math.round(color.getBlue() * 255);
        textColor = String.format("#%02X%02X%02X", red, green, blue);
        textArea.setStyle("-fx-control-inner-background: "+backgroundColor + ";" +
                          "-fx-text-fill: " + textColor + ";" +
                          "-fx-font-size: " + fontSize);
    }
    public void increaseFontSize(){
        fontSize++;
        textArea.setStyle("-fx-control-inner-background: "+backgroundColor + ";" +
                "-fx-text-fill: " + textColor + ";" +
                "-fx-font-size: " + fontSize);
    }
    public void decreaseFontSize(){
        fontSize--;
        textArea.setStyle("-fx-control-inner-background: "+backgroundColor + ";" +
                "-fx-text-fill: " + textColor + ";" +
                "-fx-font-size: " + fontSize);
    }

    private static class ConfigFileManager{
        public void createConfig(){

        }
    }
}
