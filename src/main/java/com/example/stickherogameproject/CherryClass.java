package com.example.stickherogameproject;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class CherryClass {

    private static CherryClass instance;

    private GameController gameController;
    private HelloController helloController;

    private CherryClass() {
    }

    public static CherryClass getInstance() {
        if (instance == null) {
            instance = new CherryClass();
        }
        return instance;
    }

    public void cherry_plus(Label cherryCountLabel, GameController gameController) {
        int count = Integer.parseInt(cherryCountLabel.getText());
        count++;
        gameController.setB(count);
        cherryCountLabel.setText(String.valueOf(count));
    }

    public void generateCherry(List<Rectangle> pillars, int m, AnchorPane anchorPane, List<ImageView> cherries) {
        double C_X = pillars.get(m - 1).getBoundsInParent().getMaxX();
        double nextX = pillars.get(m).getBoundsInParent().getMinX();

        double randomX = C_X + Math.random() * (nextX - C_X);
        double y = 192.0;

        Image cherryImage = new Image(CherryClass.class.getResourceAsStream("Cherry.png"));
        ImageView cherry = new ImageView(cherryImage);
        cherry.setLayoutX(randomX);
        cherry.setLayoutY(y);

        double cherryWidth = 20.0;
        double cherryHeight = 20.0;
        cherry.setFitWidth(cherryWidth);
        cherry.setFitHeight(cherryHeight);

        anchorPane.getChildren().add(cherry);
        cherries.add(cherry);
    }
}
