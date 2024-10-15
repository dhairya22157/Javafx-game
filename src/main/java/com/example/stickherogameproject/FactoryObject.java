package com.example.stickherogameproject;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class FactoryObject {
    public static void generatePillars(List<Rectangle> pillars, int m, AnchorPane anchorPane) {
        Rectangle last = pillars.get(pillars.size() - 1);
        double C_X = last.getBoundsInParent().getMaxX();
        double width = Math.random() * 50 + 20;
        double height = 103.0;
        double x = C_X + Math.random() * 140 + 30;
        double y = 204.0;
        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(Color.BLACK);
        anchorPane.getChildren().add(rectangle);
        pillars.add(rectangle);
    }

}
