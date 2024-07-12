module kingstech {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens kingstech to javafx.fxml;
    exports kingstech;
}
