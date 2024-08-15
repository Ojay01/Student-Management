module kingstech {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires kernel;
    requires layout;
    requires java.desktop;
    requires io;
    requires org.apache.poi.ooxml;
    requires org.apache.poi.poi;
    requires javafx.graphics;

    opens kingstech to javafx.fxml, javafx.controls;
    exports kingstech;
}
