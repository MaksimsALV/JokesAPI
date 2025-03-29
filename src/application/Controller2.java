package application;

import API.JokesAPI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller2 {

    @FXML
    private Button btnReturn;
        public void openStage1() {
            Run.stage1.show();
            Run.stage2.close();
        }
}
