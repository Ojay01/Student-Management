module kingstech {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires itextpdf;

    opens kingstech to javafx.fxml;
    exports kingstech;
}
