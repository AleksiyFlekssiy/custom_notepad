module base {
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.controls;
    exports com.aleksiyflekssiy.base;
    opens com.aleksiyflekssiy.base to javafx.fxml;
    exports com.aleksiyflekssiy.base.controller;
    opens com.aleksiyflekssiy.base.controller to javafx.fxml;
    exports com.aleksiyflekssiy.base.inject;
    opens com.aleksiyflekssiy.base.inject to javafx.fxml;
}