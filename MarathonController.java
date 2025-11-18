package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * GitHub:
 * https://github.com/Vanier-ComputerScience/420-sf3-re-assignmnet-02-2025-fall-Nads24
 *
 * Author: Nads
 */
public class MarathonController {

    private static final int RUNNER_COUNT = 5;

    private final String[] names = {
            "Swift Sam",
            "Rapid Rachel",
            "Turbo Tom",
            "Lightning Lucy",
            "Blaze Ben"
    };

    private final String[] numbers = { "1", "2", "3", "4", "5" };

    private final String[] colors = {
            "Crimson",
            "Emerald",
            "Sapphire",
            "Violet",
            "Gold"
    };

    private Image[] images = new Image[RUNNER_COUNT];
    private int index = 0;

    @FXML private Label runnerLabel;
    @FXML private Label distanceLabel;
    @FXML private Label introLabel;
    @FXML private Button playPauseButton;
    @FXML private Button resetButton;
    @FXML private ImageView introImageView;

    private SequentialTransition currentTransition;
    private MediaPlayer player;

    @FXML
    public void initialize() {
        loadImages();
        updateRunnerInfo(0);
        setupMusic();
        startSlideshow();
        setupButtons();
    }

    private void loadImages() {
        for (int i = 0; i < RUNNER_COUNT; i++) {
            images[i] = new Image("file:media/" + (i + 1) + ".png");
        }
    }

    private void setupMusic() {
        Media sound = new Media(getClass().getResource("/sound/bgmusic.mp3").toExternalForm());
        player = new MediaPlayer(sound);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();
    }

    private void setupButtons() {
        playPauseButton.setOnAction(e -> {
            if (currentTransition == null) return;

            if (currentTransition.getStatus() == Animation.Status.RUNNING) {
                currentTransition.pause();
                player.pause();
                playPauseButton.setText("Play");
            } else {
                currentTransition.play();
                player.play();
                playPauseButton.setText("Pause");
            }
        });

        resetButton.setOnAction(e -> resetSlideshow());
    }

    private void startSlideshow() {
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), introImageView);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        PauseTransition pause = new PauseTransition(Duration.seconds(2));

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), introImageView);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        currentTransition = new SequentialTransition(fadeIn, pause, fadeOut);

        currentTransition.setOnFinished(e -> {
            index++;
            if (index < RUNNER_COUNT) {
                updateRunnerInfo(index);
                startSlideshow();
            } else {
                finishIntro();
            }
        });

        currentTransition.play();
        playPauseButton.setText("Pause");
    }

    private void updateRunnerInfo(int i) {
        introImageView.setImage(images[i]);
        introLabel.setText(
                "Name: " + names[i] +
                " | Number: " + numbers[i] +
                " | Color: " + colors[i]
        );
    }

    private void resetSlideshow() {
        index = 0;

        if (currentTransition != null) currentTransition.stop();

        if (player != null) {
            player.stop();
            player.play();
        }

        updateRunnerInfo(0);
        startSlideshow();
    }

    private void finishIntro() {
        if (player != null) player.stop();

        try {
            Stage currentStage = (Stage) introImageView.getScene().getWindow();
            currentStage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/marathonRace.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = new Stage();
            stage.setTitle("Marathon Simulator");
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(MarathonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
