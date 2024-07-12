module kingstech {
    requires javafx.controls;
    requires javafx.fxml;

    opens kingstech to javafx.fxml;
    exports kingstech;
}
