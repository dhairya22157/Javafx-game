package com.example.stickherogameproject;

import javafx.geometry.Bounds;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Iterator;
import java.util.List;

public class CheckCondition {
    private GameController gameController;
    private HelloController helloController;
    static CherryClass cherryInstance = CherryClass.getInstance();
    public static void checkCherryCollection(List<ImageView> cherries, ImageView Character, Label cherrycount, AnchorPane anchorPane,GameController gameController) {
        Iterator<ImageView> iterator = cherries.iterator();
        while (iterator.hasNext()) {
            ImageView cherry = iterator.next();
            Bounds b1 = cherry.getBoundsInParent();
            Bounds  b2 = Character.getBoundsInParent();
            if (b2.intersects(b1)) {
                iterator.remove();
                anchorPane.getChildren().remove(cherry);
                cherryInstance.cherry_plus(cherrycount, gameController);
            }
        }
    }
}