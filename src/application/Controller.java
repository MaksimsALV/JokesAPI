package application;

import API.JokesAPI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;


public class Controller {

    @FXML
    private Button btnGetJoke;
        public void btnGetJoke() throws IOException, InterruptedException {
            String joke = JokesAPI.requestAPI();
            fieldJoke.setText(joke);
        }


    @FXML
    private Button btnSave;

    @FXML
    private Button btnViewSavedJokes;

    @FXML
    private TextArea fieldJoke;
}
