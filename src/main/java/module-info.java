module com.example.typemaster {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.poi.ooxml;


    opens com.example.typemaster to javafx.fxml;
    exports com.example.typemaster;
}