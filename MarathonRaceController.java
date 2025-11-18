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
 * Git Repository:
 * https://github.com/Vanier-ComputerScience/420-sf3-re-assignmnet-02-2025-fall-jameshuyha.git
 *
 * @author Huy James Vien Ha (6324151)
 */
public class MarathonRaceController {

    private List<Runner> runners = new ArrayList<>();
    private List<ImageView> runnerViews = new ArrayList<>();
    private List<TranslateTransition> transitions = new ArrayList<>();
    private boolean raceStarted = false;
    private String winner = "";

    @FXML
    private Button exitButton;

    @FXML
    private GridPane finishPane;

    @FXML
    private Button pauseButton;

    @FXML
    private Label resultLabel;

    @FXML
    private Pane runnerPane;

    @FXML
    private Button startButton;

    @FXML
    public void initialize() {
        // Creates checkered pattern for finish line (nested for-loop)
        for (int i = 0; i < finishPane.getRowCount(); i++) {
            for (int j = 0; j < finishPane.getColumnCount(); j++) {
                if ((i + j) % 2 == 0) {
                    Pane pane = new Pane();
                    pane.setStyle("-fx-Background-color: black");
                    finishPane.add(pane, j, i);
                }
            }
        }

        // Redefines names, numbers, and colors from intro transition
        String[] names = {"questioning monkey", "girl wait", "alex with hat", "rip nicholas", "alex with tongue"};
        String[] numbers = {"1", "2", "3", "4", "5"};
        String[] colors = {"Blue", "Pink", "Orange", "Purple", "Yellow"};
        Image runImage = new Image("file:media/run.gif");

        for (int i = 0; i < 5; i++) {
            // Adds each runner into its respective imageView
            Runner runner = new Runner(names[i], numbers[i], colors[i], 0);
            runners.add(runner);
            ImageView view = new ImageView(runImage);
            view.setFitWidth(50);
            view.setFitHeight(50);
            view.setLayoutY(i * 60);
            runnerViews.add(view);
            runnerPane.getChildren().add(view);

            // Translates runner to the finish line
            TranslateTransition tt = new TranslateTransition(Duration.seconds(500 / runner.getSpeed()), view);
            tt.setByX(500);
            tt.setOnFinished(e -> {
                if (winner.isEmpty()) {
                    winner = runner.getName();
                    resultLabel.setText("Winner: " + runner.getName() + " (Number: " + runner.getNumber() + ", Color: " + runner.getColor() + ")\nRace Results: " + runner.getName() + " won!");
                }
            });

            transitions.add(tt);

            // Button handlers
            startButton.setOnAction(e -> startRace());
            pauseButton.setOnAction(e -> pauseRace());
            exitButton.setOnAction(e -> exitApp());
            resultLabel.setText("Welcome to the Marathon Race!\nPress Start to begin.");
        }

    }

    private void startRace() {
        startButton.setDisable(true);
        // Plays translate transitions when button pressed
        if (!raceStarted) {
            for (TranslateTransition tt : transitions) {
                tt.play();
            }
            raceStarted = true;
            resultLabel.setText("Race started! Good luck runners.");
        } else {
            for (TranslateTransition tt : transitions) {
                tt.play();
            }
        }
    }

    private void pauseRace() {
        // Pauses runners' transition when pressed
        startButton.setDisable(false);
        for (TranslateTransition tt : transitions) {
            tt.pause();
        }
        resultLabel.setText("Race paused.");
    }

    // Exits application
    private void exitApp() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
