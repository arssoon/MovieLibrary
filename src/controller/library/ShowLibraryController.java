package controller.library;

import controller.Path;
import controller.SwitchScene;
import controller.saveandreadfile.ReadPasswordInFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowLibraryController extends SwitchScene implements Initializable {
    @FXML
    private TableView<Movie> table;
    @FXML    public TableColumn<Movie, String> id_nameMovie;
    @FXML
    public TableColumn<Movie, Integer> id_yearMovie;
    @FXML
    public TableColumn<Movie, String> id_directorMovie;
    @FXML
    public TableColumn<Movie, Double> id_reatMovie;
    ReadPasswordInFile readPasswordInFile;
    ObservableList<Movie> dataList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataList = FXCollections.observableArrayList();
        readPasswordInFile = new ReadPasswordInFile(dataList);

        id_nameMovie.setCellValueFactory(new PropertyValueFactory<>("nameMovie"));
        id_yearMovie.setCellValueFactory(new PropertyValueFactory<>("yearCreateMovie"));
        id_directorMovie.setCellValueFactory(new PropertyValueFactory<>("directorMovie"));
        id_reatMovie.setCellValueFactory(new PropertyValueFactory<>("reatingMovie"));

        readPasswordInFile.loadFromFile(Path.PATH_MOVIES, false);

        //dodanie elementów (wszystkich) do tablicy
        table.setItems(dataList);

        // -----    zapisanie filmów do listy    ------------------------------------------------------
        setContentColumnNameMovie(getMovies());
    }

    public ObservableList<String> getMovies() {
        ObservableList<String> columnData = FXCollections.observableArrayList();

        // dodanie do listy id i nazwy filmu do COMBOX'a w celu ich wyswietlenia
        for (Movie item : table.getItems()) {
            columnData.add(id_nameMovie.getCellObservableValue(item).getValue() + ", " +
                    id_yearMovie.getCellObservableValue(item).getValue() + ", " +
                    id_directorMovie.getCellObservableValue(item).getValue() + ", " +
                    id_reatMovie.getCellObservableValue(item).getValue()
            );
        }
        return columnData;
    }

}
