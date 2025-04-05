package application;

import API.JokesAPI;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

import java.io.IOException;

public class Controller1 {

    @FXML
    private Button btnGetJoke;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnViewSavedJokes;

    @FXML
    private TextArea fieldJoke;

    private Joke visibleJoke; //need this to return "visible joke" in UI and then pass that result to btnSave() method..

    public void btnGetJoke() throws IOException, InterruptedException {
        visibleJoke = JokesAPI.requestAPI();
        fieldJoke.setText(visibleJoke.getJoke() + "\n" + visibleJoke.getPunchline());
    }

    public void btnSave() {
        Controller2.addJoke(visibleJoke);
        btnSave.setDisable(true);
        btnSave.setText("Saving...");
        new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            btnSave.setDisable(false);
            btnSave.setText("Save");
        })).play();
    }

    public void openStage2() {
        Run.stage2.show();
        Run.stage1.close();
    }
}

