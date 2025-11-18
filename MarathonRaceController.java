package controller;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Runner;

/**
 * GitHub:
 * https://github.com/Vanier-ComputerScience/420-sf3-re-assignmnet-02-2025-fall-Nads24
 *
 * Author: Nads
 */
public class MarathonRaceController {

    private List<Runner> runners = new ArrayList<>();
    private List<ImageView> runnerViews = new ArrayList<>();
    private List<TranslateTransition> transitions = new ArrayList<>();
    private boolean raceStarted = false;
    private String winner = "";

    @FXML private Button exitButton;
    @FXML private GridPane finishPane;
    @FXML private Button pauseButton;
    @FXML private Label resultLabel;
    @FXML private Pane runnerPane;
    @FXML private Button startButton;

    @FXML
    public void initialize() {

        for (int i = 0; i < finishPane.getRowCount(); i++) {
            for (int j = 0; j < finishPane.getColumnCount(); j++) {
                if ((i + j) % 2 == 0) {
                    Pane pane = new Pane();
                    pane.setStyle("-fx-background-color: black");
                    finishPane.add(pane, j, i);
                }
            }
        }

        String[] names = {
                "Swift Sam",
                "Rapid Rachel",
                "Turbo Tom",
                "Lightning Lucy",
                "Blaze Ben"
        };

        String[] numbers = { "1", "2", "3", "4", "5" };

        String[] colors = {
                "Crimson",
                "Emerald",
                "Sapphire",
                "Violet",
                "Gold"
        };

        Image runImage = new Image("file:media/run.gif");

        for (int i = 0; i < 5; i++) {

            Runner runner = new Runner(names[i], numbers[i], colors[i], 0);
            runners.add(runner);

            ImageView view = new ImageView(runImage);
            view.setFitWidth(50);
            view.setFitHeight(50);
            view.setLayoutY(i * 60);
            runnerViews.add(view);
            runnerPane.getChildren().add(view);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(500 / runner.getSpeed()), view);
            tt.setByX(500);
            tt.setOnFinished(e -> {
                if (winner.isEmpty()) {
                    winner = runner.getName();
                    resultLabel.setText(
                            "Winner: " + runner.getName() +
                            " (Number: " + runner.getNumber() +
                            ", Color: " + runner.getColor() + ")\nRace Results: " +
                            runner.getName() + " won!"
                    );
                }
            });

            transitions.add(tt);
        }

        startButton.setOnAction(e -> startRace());
        pauseButton.setOnAction(e -> pauseRace());
        exitButton.setOnAction(e -> exitApp());

        resultLabel.setText("Welcome to the Marathon Race!\nPress Start to begin.");
    }

    private void startRace() {
        startButton.setDisable(true);
        if (!raceStarted) {
            for (TranslateTransition tt : transitions) tt.play();
            raceStarted = true;
            resultLabel.setText("Race started! Good luck runners.");
        } else {
            for (TranslateTransition tt : transitions) tt.play();
        }
    }

    private void pauseRace() {
        startButton.setDisable(false);
        for (TranslateTransition tt : transitions) tt.pause();
        resultLabel.setText("Race paused.");
    }

    private void exitApp() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
