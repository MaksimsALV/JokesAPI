package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

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
    private Button btnAddNewJoke;

    @FXML
    private Button btnRateJoke;

    @FXML
    private TextField fldCategory;

    @FXML
    private TextField fldJoke;

    @FXML
    private TextField fldPunchline;

    @FXML
    private Slider sliderRating;

    @FXML
    private Button btnReturn;

    static ObservableList<Joke> listOfJokes = FXCollections.observableArrayList();

    public void openStage1() {
        Run.stage1.show();
        Run.stage2.close();
    }

    public void initialize() { //FXMLLoader automatically calls this method when launching 2nd scene
        sliderRating.disableProperty().bind(tableOfJokes.getSelectionModel().selectedItemProperty().isNull()); //disabling slider unless row is selected; this helps with rating only selected joke

        clmnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmnJoke.setCellValueFactory(new PropertyValueFactory<>("joke"));
        clmnPunchline.setCellValueFactory(new PropertyValueFactory<>("punchline"));
        clmnCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        clmnDate_created.setCellValueFactory(new PropertyValueFactory<>("date_created"));
        clmnDate_updated.setCellValueFactory(new PropertyValueFactory<>("date_updated"));
        clmnRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        tableOfJokes.setItems(listOfJokes);
    }

    public static void addJoke(Joke joke) {
        listOfJokes.add(joke);
    }

    public void btnAddNewJoke() {
        String joke = fldJoke.getText();
        String punchline = fldPunchline.getText();
        String category = fldCategory.getText();

        Joke addNewJoke = new Joke(joke, punchline, category);
        listOfJokes.add(addNewJoke);
    }

    public void btnRateJoke() {
        Joke selectedJoke = tableOfJokes.getSelectionModel().getSelectedItem();
        String slider = String.format("%.0f", sliderRating.getValue()); //I tried integers and failed, so i went with Strings, and then just trimming values to one number
        selectedJoke.setRating(slider);
        tableOfJokes.refresh();
    }
}
