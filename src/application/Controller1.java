package application;

import API.JokesAPI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

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

    private Joke visibleJoke;

    public void btnGetJoke() throws IOException, InterruptedException {
        visibleJoke = JokesAPI.requestAPI();
        fieldJoke.setText(visibleJoke.getJoke());
        fieldJoke.setText(visibleJoke.getPunchline());
    }

    //initialize writing to the table
    public void btnSave() {
        Controller2.addJoke(visibleJoke);
    }

    public void openStage2() {
        Run.stage2.show();
        Run.stage1.close();
    }
}

