package com.aleksiyflekssiy.base;

import com.aleksiyflekssiy.base.controller.AppearanceController;
import com.aleksiyflekssiy.base.controller.MainController;
import com.aleksiyflekssiy.base.inject.Injector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    private FXMLLoader fxmlLoader;
    private Parent mainControllerFXML;
    private Parent appearanceControllerFXML;

    @Override
    public void start(Stage primaryStage) throws IOException {
        loadFXML();
        openMainWindow();
    }

    private void loadFXML() throws IOException {
        MainController mainController = new MainController(this);
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/aleksiyflekssiy/fxml/base-ui.fxml"));
        fxmlLoader.setControllerFactory(param -> mainController);
        mainControllerFXML = fxmlLoader.load();
        Injector.bind(MainController.class, fxmlLoader.getController());

        AppearanceController appearanceController = new AppearanceController();
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/aleksiyflekssiy/fxml/popup.fxml"));
        fxmlLoader.setControllerFactory(param -> appearanceController);
        appearanceControllerFXML = fxmlLoader.load();
        Injector.bind(AppearanceController.class, fxmlLoader.getController());
    }
    
    public void openMainWindow() throws IOException {
        Stage mainStage = new Stage();
        Scene scene = new Scene(mainControllerFXML);
        mainStage.setTitle("Notepad");
        mainStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/aleksiyflekssiy/icons/notepad.png")));
        mainStage.setScene(scene);
        mainStage.show();
    }

    public void openAppearanceWindow() throws IOException {
        Stage appearanceStage = new Stage();
        Scene scene = new Scene(appearanceControllerFXML);
        appearanceStage.setScene(scene);
        appearanceStage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}
