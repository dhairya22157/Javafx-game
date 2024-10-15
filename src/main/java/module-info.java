module com.example.stickherogameproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
    requires java.desktop;


    opens com.example.stickherogameproject to javafx.fxml;
    exports com.example.stickherogameproject;
}