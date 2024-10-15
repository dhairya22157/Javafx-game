package com.example.stickherogameproject;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class Pillars {

    public static void addFirstPilar(List<Rectangle> pillars,AnchorPane anchorPane) {
        double X = 79;
        double Width = 86;
        double Height = 103;
        Rectangle firstPillar = new Rectangle(X, 204.0, Width, Height);
        anchorPane.getChildren().add(firstPillar);
        pillars.add(firstPillar);
    }
}
