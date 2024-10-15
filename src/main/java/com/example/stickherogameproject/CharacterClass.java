package com.example.stickherogameproject;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;

public class CharacterClass  {
    public static void flipCharacter(ImageView Character) {
        Character.setScaleY(-1);
        Character.setTranslateY(Character.getTranslateY() + Character.getFitHeight());
    }
    public static void resetCharacterFlip(ImageView Character) {
        Character.setScaleY(1);
        Character.setTranslateY(Character.getTranslateY() - Character.getFitHeight());
    }







}
