package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Run {
    public static void main(String[] args) throws IOException {
        Platform.startup(() -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Run.class.getResource("/application/Window1.fxml"));
                Parent root = fxmlLoader.load();
                Stage primaryStage = new Stage();
                primaryStage.setScene(new Scene(root));
                primaryStage.setTitle("Random Joke Generator");
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
