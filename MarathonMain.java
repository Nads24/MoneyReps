import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * GitHub:
 * https://github.com/Vanier-ComputerScience/420-sf3-re-assignmnet-02-2025-fall-Nads24
 *
 * Author: Nads
 */
public class MarathonMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/marathon.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Marathon Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
