package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller2 {

    @FXML
    private TableView<Joke> tableOfJokes;

    @FXML
    private TableView<Joke> tableOfJokes_deleted;

    @FXML
    private TableColumn<Joke, String> clmnId; //todo change to UUID

    @FXML
    private TableColumn<Joke, String> clmnId_deleted;

    @FXML
    private TableColumn<Joke, String> clmnJoke;

    @FXML
    private TableColumn<Joke, String> clmnJoke_deleted;

    @FXML
    private TableColumn<Joke, String> clmnPunchline;

    @FXML
    private TableColumn<Joke, String> clmnPunchline_deleted;

    @FXML
    private TableColumn<Joke, String> clmnCategory;

    @FXML
    private TableColumn<Joke, String> clmnCategory_deleted;

    @FXML
    private TableColumn<Joke, String> clmnRating; //todo change to integer

    @FXML
    private TableColumn<Joke, String> clmnRating_deleted; //todo change to integer

    @FXML
    private TableColumn<Joke, String> clmnDate_created; //todo change to timestamp

    @FXML
    private TableColumn<Joke, String> clmnDate_updated; //todo change to timestamp

    @FXML
    private TableColumn<Joke, String> clmnDate_deleted_deleted;

    @FXML
    private Button btnAddNewJoke;

    @FXML
    private Button btnRateJoke;

    @FXML
    private Button btnUpdateJoke;

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
    static ObservableList<Joke> listOfJokes_deleted = FXCollections.observableArrayList();

    public void openStage1() {
        Run.stage1.show();
        Run.stage2.close();
    }

    public void initialize() { //FXMLLoader automatically calls this method when launching 2nd scene
        sliderRating.disableProperty().bind(tableOfJokes.getSelectionModel().selectedItemProperty().isNull()); //disabling slider unless row is selected; this helps with rating only selected joke

        //Saved jokes tab
        clmnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmnJoke.setCellValueFactory(new PropertyValueFactory<>("joke"));
        clmnPunchline.setCellValueFactory(new PropertyValueFactory<>("punchline"));
        clmnCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        clmnDate_created.setCellValueFactory(new PropertyValueFactory<>("date_created"));
        clmnDate_updated.setCellValueFactory(new PropertyValueFactory<>("date_updated"));
        clmnRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        tableOfJokes.setItems(listOfJokes);

        //Archive tab
        clmnId_deleted.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmnJoke_deleted.setCellValueFactory(new PropertyValueFactory<>("joke"));
        clmnPunchline_deleted.setCellValueFactory(new PropertyValueFactory<>("punchline"));
        clmnCategory_deleted.setCellValueFactory(new PropertyValueFactory<>("category"));
        clmnDate_deleted_deleted.setCellValueFactory(new PropertyValueFactory<>("date_deleted"));
        clmnRating_deleted.setCellValueFactory(new PropertyValueFactory<>("rating"));
        tableOfJokes_deleted.setItems(listOfJokes_deleted);
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
        selectedJoke.setDate_updated(); //updating date_updated everytime we rate
        tableOfJokes.refresh();
    }

    public void btnUpdateJoke() {
        Joke selectedJoke = tableOfJokes.getSelectionModel().getSelectedItem();
        selectedJoke.setJoke(fldJoke.getText());
        selectedJoke.setPunchline(fldPunchline.getText());
        selectedJoke.setCategory(fldCategory.getText());
        selectedJoke.setDate_updated(); //updating date_updated everytime we update
        tableOfJokes.refresh();
    }

    public void btnDeleteJoke() {
        Joke selectedJoke = tableOfJokes.getSelectionModel().getSelectedItem();
        listOfJokes_deleted.add(selectedJoke);
        selectedJoke.setDate_deleted();
        listOfJokes.remove(selectedJoke);
        tableOfJokes.refresh();
        tableOfJokes_deleted.refresh();
    }
}
