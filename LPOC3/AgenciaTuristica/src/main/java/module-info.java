module victorramos.agenciaturistica {
    requires javafx.controls;
    requires javafx.fxml;

    opens victorramos.agenciaturistica to javafx.fxml;
    exports victorramos.agenciaturistica;
}
