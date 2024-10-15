package com.example.stickherogameproject;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;

public class Animation {
    public void setmessage(int n , Label Instruct ) {
        if (n == 0) {
            Instruct.setText("Hold right click button on mouse to stretch out the stick");
            Instruct.setStyle("-fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 12; -fx-text-fill: #14e6df;");
            n++;
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(2),
                    e -> Instruct.setText("")));
            timeline.setCycleCount(1);
            timeline.play();
        }
    }
    public static void fallCharacterAnimation(ImageView Character) {
        double X = Character.getLayoutX();
        double Y = Character.getLayoutY();
        Character.setLayoutX(X);
        Character.setLayoutY(Y);
        TranslateTransition fallTransition = new TranslateTransition(Duration.seconds(1), Character);
        fallTransition.setByY(200);
        fallTransition.setInterpolator(Interpolator.LINEAR);
        fallTransition.play();
    }

    public static void movePillarsAnimation(List<Rectangle> pillars, int m, ImageView Character, Line Stick,List<ImageView> cherries) {
        double distance = pillars.get(m).getBoundsInParent().getMinX() - pillars.get(m - 1).getBoundsInParent().getMinX();
        double X = Character.getLayoutX() - distance;
        double Y = Character.getLayoutY();
        Character.setLayoutX(X);
        Character.setLayoutY(Y);
        Stick.setStartX(Stick.getStartX() - distance);
        Stick.setEndX(Stick.getEndX() - distance);

        for (Rectangle pillar : pillars) {
            pillar.setX(pillar.getX() - distance);
        }
        for (ImageView cherry : cherries) {
            cherry.setLayoutX(cherry.getLayoutX() - distance);
        }

    }
    public static void PillarEndAnimation(double distance,ImageView Character,Line Stick) {
        double X = Character.getLayoutX() + distance;
        double Y = Character.getLayoutY();
        Character.setLayoutX(X);
        Character.setLayoutY(Y);
        Stick.setStartX(Stick.getStartX() + distance);
        Stick.setEndX(Stick.getEndX() + distance);
    }
}

