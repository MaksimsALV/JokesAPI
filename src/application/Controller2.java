package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.Instant;

public class Controller2 {

    @FXML
    private TableView<Joke> tableOfJokes;

    @FXML
    private TableColumn<Joke, String> clmnId; //todo change to UUID

    @FXML
    private TableColumn<Joke, String> clmnJoke;

    @FXML
    private TableColumn<Joke, String> clmnPunchline;

    @FXML
    private TableColumn<Joke, String> clmnCategory;

    @FXML
    private TableColumn<Joke, String> clmnRating; //todo change to integer

    @FXML
    private TableColumn<Joke, String> clmnDate_created; //todo change to timestamp

    @FXML
    private TableColumn<Joke, String> clmnDate_updated; //todo change to timestamp


    @FXML
    private Button btnReturn;

    static ObservableList<Joke> listOfJokes = FXCollections.observableArrayList();

    public void openStage1() {
        Run.stage1.show();
        Run.stage2.close();
    }

    public void initialize() { //FXMLLoader automatically calls this method when launching 2nd scene
        clmnJoke.setCellValueFactory(new PropertyValueFactory<Joke, String>("joke"));
        clmnPunchline.setCellValueFactory(new PropertyValueFactory<Joke, String>("punchline"));
        clmnCategory.setCellValueFactory(new PropertyValueFactory<Joke, String>("category"));
        clmnDate_created.setCellValueFactory(new PropertyValueFactory<Joke, String>("date_created"));
        tableOfJokes.setItems(listOfJokes);
    }

    public static void addJoke(Joke joke) {
        listOfJokes.add(joke);
    }

}
