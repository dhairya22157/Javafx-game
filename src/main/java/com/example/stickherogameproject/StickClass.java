package com.example.stickherogameproject;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class StickClass {
    private static Timeline timeline;

    private int width;

    private int height;

    private int setX;

    private int setY;

    private int getX;

    private int getY;

    public static void  stickIncreasing(Line Stick) {
        Stick.setEndY(Stick.getEndY() - 1);
        Stick.setVisible(true);
    }

}



