module com.example.custom_notepad {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.custom_notepad to javafx.fxml;
    exports com.example.custom_notepad;
}