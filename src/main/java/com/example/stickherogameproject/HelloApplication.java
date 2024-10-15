package com.example.stickherogameproject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.sound.sampled.*;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL url = getClass().getResource("MainScreen.fxml");
        if (url == null) {
            System.out.println("FXML file not found!");
        } else {
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            stage.setTitle("STICK HERO GAME");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
    }
    //Please read the readme  first


    public static void main(String[] args) {
        launch();
    }
}
