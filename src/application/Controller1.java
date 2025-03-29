package application;

import API.JokesAPI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;


public class Controller1 {

    @FXML
    private Button btnGetJoke;
        public void btnGetJoke() throws IOException, InterruptedException {
            fieldJoke.setText(JokesAPI.requestAPI());
        }


    @FXML
    private Button btnSave;

    @FXML
    private Button btnViewSavedJokes;
        public void openStage2() {
            Run.stage2.show();
            Run.stage1.close();
        }

    @FXML
    private TextArea fieldJoke;
}
