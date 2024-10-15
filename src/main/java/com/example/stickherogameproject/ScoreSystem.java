package com.example.stickherogameproject;

import javafx.scene.control.Label;

public class ScoreSystem{
    public static void scoreUpdate(Label Score,GameController gameController,int points) {
        Score.setText("Score: " + points);
        Score.setStyle("-fx-font-weight: bold; -fx-font-size: 16; -fx-text-fill: #00008B;");
        gameController.setA(points);
    }

}
