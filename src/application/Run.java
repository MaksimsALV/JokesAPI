package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Run extends Application {

    public static Stage stage1;
    public static Stage stage2;

    public static Controller1 controller1;
    public static Controller2 controller2;

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("Window1.fxml"));
            Parent root1 = fxmlLoader1.load();
            Scene scene1 = new Scene(root1);

            stage1 = primaryStage;
            stage1.setScene(scene1);
            stage1.setTitle("Random Joke Generator");
            stage1.show();

            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("Window2.fxml"));
            Parent root2 = fxmlLoader2.load();
            Scene scene2 = new Scene(root2);

            stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.setTitle("Random Joke Generator");
            //stage2.show();

            controller1 = fxmlLoader1.getController();
            controller2 = fxmlLoader2.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
