package controller.library;

import controller.Path;
import controller.SwitchScene;
import controller.saveandreadfile.SaveInFile;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class AddLibraryController extends SwitchScene {
    @FXML
    public TextField id_nameMovie;
    public Button id_addMovie;
    @FXML
    private ComboBox<Integer> id_yearCreateMovie;
    @FXML
    private TextField id_ratingMovie;
    @FXML
    public ComboBox id_categoryMovie;
    @FXML
    private Label id_informatonSuccessfulLabel;
    @FXML
    private Slider id_sliderReating;
    SaveInFile saveInFile;
    Movie movie;
    String nameMovie, categoryMovie;
    int yearCreateMovie;
    double ratingMovie;

    @FXML
    void initialize() {
        saveInFile = new SaveInFile();
        id_ratingMovie.textProperty().bind(
                Bindings.format("%.1f", id_sliderReating.valueProperty())
        );
       categoryMovie();
        id_categoryMovie.valueProperty().addListener((observable, oldValue, newValue) -> {
            categoryMovie = String.valueOf(newValue);
        });
        for (int year = 2020; year >= 1980; year--) {
            id_yearCreateMovie.getItems().add(year);
        }
    }

    public void categoryMovie() {
        ObservableList<MovieCategory> category = FXCollections.observableArrayList(
                MovieCategory.AKCJA,
                MovieCategory.ANIMACJA,
                MovieCategory.DRAMAT,
                MovieCategory.HORROR,
                MovieCategory.KOMEDIA,
                MovieCategory.KRYMINALNY,
                MovieCategory.PRZYGODOWY,
                MovieCategory.ROMANTYCZNY,
                MovieCategory.SCIENCE_FICTION,
                MovieCategory.THRILLER
        );
        id_categoryMovie.getItems().addAll(category);
    }

    public void addMovie() throws ParseException {
        nameMovie = id_nameMovie.getText();
        yearCreateMovie = id_yearCreateMovie.getSelectionModel().getSelectedItem();
        formatNumber();

        saveInFile.saveToFile(nameMovie, categoryMovie, Path.PATH_MOVIES,
                false, yearCreateMovie, ratingMovie
        );
        movie = new Movie(nameMovie, yearCreateMovie, categoryMovie, ratingMovie);

        id_informatonSuccessfulLabel.setText("Prawidłowo dodano film do biblioteki");
    }

    private void formatNumber() throws ParseException {
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        Number number = format.parse(String.valueOf(id_ratingMovie.getText()));
        ratingMovie = number.doubleValue();
    }
}
