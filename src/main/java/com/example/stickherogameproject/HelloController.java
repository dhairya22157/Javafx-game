package com.example.stickherogameproject;
import java.io.IOException;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import javafx.util.Duration;
import javafx.animation.Interpolator;
import javafx.scene.shape.Rectangle;
import java.net.URL;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;
public class HelloController implements  Initializable {
    private GameController gameController;
    private HelloController helloController;
    private Stage stage;
    private Scene scene;
    private Parent root;

    private Timeline timeline;

    @FXML
    private ImageView Character;

    @FXML
    private Line Stick;
    @FXML
    private Rectangle Pillar;

    @FXML
    private ImageView Cherry;

    @FXML
    private AnchorPane anchorPane;
    CherryClass cherryInstance = CherryClass.getInstance();

    @FXML
    private Label Score;

    @FXML
    private Label cherrycount;

    @FXML
    private Button Revive;

    @FXML
    private Label Instruct;

    private boolean isMousePressed = false;
    private boolean isMouseLeftPressed = false;

    private int points;

    private int a = 0;
    private int b = 0;

    private int i = 0;

    private int n = 0;

    private int m = 0;

    private List<ImageView> cherries = new ArrayList<>();
    private List<Rectangle> pillars = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameController = GameController.getInstance();
        Animation an = new Animation();
        if (anchorPane != null) {
            Pillars.addFirstPilar(pillars,anchorPane);
            FactoryObject.generatePillars(pillars,m,anchorPane);
            m++;
            an.setmessage(n,Instruct);
            cherryInstance.generateCherry(pillars, m, anchorPane, cherries);
            if (gameController.getC() == 1) {
                int l = gameController.getB() - 1;
                cherrycount.setText(String.valueOf(l));
                Score.setText("Score: " + gameController.getA());
                Score.setStyle("-fx-font-weight: bold; -fx-font-size: 16; -fx-text-fill: #00008B;");
            } else if (gameController.getC() == 2) {
                cherrycount.setText(String.valueOf(gameController.getB()));
                Score.setText("Score: " + gameController.getA());
                Score.setStyle("-fx-font-weight: bold; -fx-font-size: 16; -fx-text-fill: #00008B;");
            } else {
                cherrycount.setText(String.valueOf(0));
            }
            gameController.setC(0);
        }
    }

    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToScene3(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InstructionScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void switchToScene4(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("GameOver.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    private void reviveGame(ActionEvent event) throws IOException {
        gameController.setC(1);
        if (gameController.getB() >=1) {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
            Parent root = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    @BeforeEach
    public void setup() {
        helloController = new HelloController();
        gameController = GameController.getInstance();
    }

    @Test
    public void testReviveGame() throws IOException {
        gameController.setB(1);
        helloController.reviveGame(new ActionEvent());
        assertEquals(2, gameController.getB());
    }

    @Test
    public void testResumeGame() throws IOException {
        gameController.setB(2);

        helloController.ResumeGame(new ActionEvent());
        assertEquals(1, gameController.getB());
    }

    @FXML
    private void ResumeGame(ActionEvent event) throws IOException {
        gameController.setC(2);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    private void delay_in_Scene4(Stage stage) {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(1),
                event -> switchToScene4(stage)
        ));
        timeline.setCycleCount(1);
        timeline.play();
    }
    @FXML
    private void handleMousePressed(MouseEvent event) {
        if (event.getButton() == MouseButton.SECONDARY) {
            isMousePressed = true;
            increaseLength();
        } else if (event.getButton() == MouseButton.PRIMARY) {
            isMouseLeftPressed = true;
            CharacterClass.flipCharacter(Character);
        }
    }

    @FXML
    private void handleMouseReleased(MouseEvent event) {
        if (event.getButton() == MouseButton.SECONDARY) {
            isMousePressed = false;
            stopIncreasing();
            MoveCharacter();
        } else if (event.getButton() == MouseButton.PRIMARY) {
            isMouseLeftPressed = false;
            CharacterClass.resetCharacterFlip(Character);
        }
    }
    private void increaseLength() {
        if (i == 0) {
            if (timeline == null) {
                timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> StickClass.stickIncreasing(Stick)));
                timeline.setCycleCount(Timeline.INDEFINITE);
            }
            if (!timeline.getStatus().equals(Timeline.Status.RUNNING)) {
                timeline.play();
            }
            i++;
        }
    }
    private void stopIncreasing() {
        if (timeline != null && timeline.getStatus().equals(Timeline.Status.RUNNING)) {
            timeline.stop();
        }
    }

    private boolean isUpKeyPressed = false;
    private boolean isDownKeyPressed = false;

    @FXML
    private void handleKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.UP) {
            isUpKeyPressed = true;
            increeaseLength();
        }
    }
    private void increeaseLength() {
        if (isUpKeyPressed) {
            Stick.setEndY(Stick.getEndY() - 1.0);
        }
    }

    private void MoveCharacter() {
        double Xi = Stick.getStartX();
        double Yi = Stick.getStartY();
        double endX = Stick.getEndX();
        double endY = Stick.getEndY();
        double rotatedEndX = Xi + (endX - Xi) * Math.cos(Math.toRadians(90)) - (endY - Yi) * Math.sin(Math.toRadians(90));
        double rotatedEndY = Yi;

        Timeline t1 = new Timeline(
                new KeyFrame(Duration.millis(50), event -> CheckCondition.checkCherryCollection(cherries, Character, cherrycount, anchorPane, gameController))
        );
        t1.setCycleCount(Timeline.INDEFINITE);
        t1.play();
        Thread moveCharacterThread = new Thread(() -> {
            Platform.runLater(() -> {
                TranslateTransition translate = new TranslateTransition();
                translate.setNode(Character);
                translate.setByX((rotatedEndX - Xi));
                translate.setByY(rotatedEndY - Yi);
                translate.setInterpolator(Interpolator.LINEAR);
                translate.setCycleCount(1);
                translate.setDuration(Duration.seconds(1));
                translate.setOnFinished(e -> {
                    t1.stop();
                    checkCharacterPosition();
                });
                translate.play();

                TranslateTransition translate2 = new TranslateTransition();
                translate2.setNode(Stick);
                translate2.setByX((rotatedEndX - Xi));
                translate2.setByY(rotatedEndY - Yi);
                translate2.setInterpolator(Interpolator.LINEAR);
                translate2.setCycleCount(1);
                translate2.setDuration(Duration.seconds(1));
                translate2.play();

                double desiredLength = 0.5;
                double Xi2 = Stick.getStartX();
                double Yi2 = Stick.getStartY();
                double endX2 = Stick.getEndX();
                double endY2 = Stick.getEndY();
                double currentLength = Math.sqrt(Math.pow(endX2 - Xi2, 2) + Math.pow(endY2 - Yi2, 2));
                double scaleFactor = desiredLength / currentLength;
                double newEndX = Xi2 + scaleFactor * (endX2 - Xi2);
                double newEndY = Yi2 + scaleFactor * (endY2 - Yi2);
                Stick.setEndX(newEndX);
                Stick.setEndY(newEndY);
            });
        });
        moveCharacterThread.start();
    }

    public  void checkCharacterPosition() {
        if (pillars.size() > 1) {
            double C_X = Character.getBoundsInParent().getMaxX();
            double charMaxX = Character.getBoundsInParent().getMinX();
            double next_X = pillars.get(m).getBoundsInParent().getMinX();
            double pillarWidth = pillars.get(m).getWidth();
            double middle = next_X + pillarWidth / 2.0;
            if (C_X < next_X || charMaxX > next_X + pillarWidth) {
                Animation.fallCharacterAnimation(Character);
                delay_in_Scene4((Stage) anchorPane.getScene().getWindow());
            } else {
                CheckCondition.checkCherryCollection(cherries,Character,cherrycount,anchorPane,gameController);
                Animation.movePillarsAnimation(pillars,m,Character,Stick,cherries);
                double characterPos = Character.getBoundsInParent().getMaxX();
                double maxnextPillarX = pillars.get(m).getBoundsInParent().getMaxX();
                if ((maxnextPillarX - characterPos) > 0) {
                    double m = maxnextPillarX - characterPos;
                    Animation.PillarEndAnimation(m,Character,Stick);
                }
                FactoryObject.generatePillars(pillars,m,anchorPane);
                m++;
                if (Math.random() <= 0.33) {
                    cherryInstance.generateCherry(pillars, m, anchorPane, cherries);
                }

                i = 0;
                if (C_X >= middle - 5 && C_X <= middle + 5) {
                    points += 2;
                    a = points;
                } else {
                    points++;
                    a = points;
                }
                ScoreSystem.scoreUpdate(Score,gameController,points);

            }
        } else {
            System.out.println("Not enough pillars to check");
        }
    }
}


