package application;

import API.JokesAPI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

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

    ObservableList<Joke> listOfJokes = FXCollections.observableArrayList();

    public void openStage1() {
        Run.stage1.show();
        Run.stage2.close();
    }

    public void initialize() {
        clmnJoke.setCellValueFactory(new PropertyValueFactory<Joke, String>("joke"));
        //clmnPunchline.setCellValueFactory(new PropertyValueFactory<Joke, String>("punchline"));
        //clmnCategory.setCellValueFactory(new PropertyValueFactory<Joke, String>("category"));
        populate();
    }

    public void populate() {
        Joke joke1 = new Joke("Knock, Knock");

        listOfJokes.add(joke1);
        tableOfJokes.setItems(listOfJokes);
    }

}
