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
 * Git Repository:
 * https://github.com/Vanier-ComputerScience/420-sf3-re-assignmnet-02-2025-fall-jameshuyha.git
 *
 * @author Huy James Vien Ha (6324151)
 */
public class MarathonController {

    // Qualifiers for all runners
    private int index = 0;
    private Image[] images;
    private String[] names = {"questioning monkey", "girl wait", "alex with hat", "rip nicholas", "alex with tongue"};
    private String[] numbers = {"1", "2", "3", "4", "5"};
    private String[] colors = {"Blue", "Pink", "Orange", "Purple", "Yellow"};
    private SequentialTransition currentTransition;
    private MediaPlayer player;

    @FXML
    private Label runnerLabel;

    @FXML
    private Label distanceLabel;

    @FXML
    private Label introLabel;

    @FXML
    private Button playPauseButton;

    @FXML
    private Button resetButton;

    @FXML
    private ImageView introImageView;

    @FXML
    public void initialize() {
        // Puts images in an array
        images = new Image[5];
        for (int i = 0; i < 5; i++) {
            images[i] = new Image("file:media/" + String.valueOf(i + 1) + ".png");
        }

        // Starts at 0th position of array
        introImageView.setImage(images[0]);
        introLabel.setText("Name: " + names[0] + " | Number: " + numbers[0] + " | Color: " + colors[0]);

        // Plays music
        Media sound = new Media(getClass().getResource("/sound/bgmusic.mp3").toExternalForm());
        player = new MediaPlayer(sound);
        player.setCycleCount(MediaPlayer.INDEFINITE); // Loop music
        player.play();

        startSlideshow();

        // Pauses and plays transition and sound when button is pressed
        playPauseButton.setOnAction(e -> {
            if (currentTransition != null) {
                if (currentTransition.getStatus() == Animation.Status.RUNNING) {
                    currentTransition.pause();
                    player.pause();
                    playPauseButton.setText("Play");
                } else {
                    currentTransition.play();
                    player.play();
                    playPauseButton.setText("Pause");
                }
            }
        });

        // Reset button to restart slideshow and replay music
        resetButton.setOnAction(e -> {
            index = 0;
            if (currentTransition != null) {
                currentTransition.stop();
            }

            if (player != null) {
                player.stop();
                player.play();
            }

            introImageView.setImage(images[0]);
            introLabel.setText("Name: " + names[0] + " | Number: " + numbers[0] + " | Color: " + colors[0]);
            startSlideshow();
        });
    }

    // What happens in slideshow
    private void startSlideshow() {
        // When image fades in
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), introImageView);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        // Pause to let the image sit in full opacity
        PauseTransition pause = new PauseTransition(Duration.seconds(2));

        // When image fades out
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), introImageView);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        currentTransition = new SequentialTransition(fadeIn, pause, fadeOut);

        // Every time the current image has been cycled through
        currentTransition.setOnFinished(e -> {
            index++;
            if (index < 5) {
                // Recursion to move on to next image
                introImageView.setImage(images[index]);
                introLabel.setText("Name: " + names[index] + " | Number: " + numbers[index] + " | Color: " + colors[index]);
                startSlideshow();
            } else {
                // Stops music
                if (player != null) {
                    player.stop();
                }
                try {
                    // Creates new stage for actual marathon race
                    Stage currentStage = (Stage) introImageView.getScene().getWindow();
                    currentStage.close();
                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/marathonRace.fxml"));
                    Scene scene = new Scene(loader.load());
                    stage.setTitle("Marathon Simulator");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(MarathonController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        currentTransition.play();
        playPauseButton.setText("Pause");
    }
}
