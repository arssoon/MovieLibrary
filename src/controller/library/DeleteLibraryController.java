package controller.library;

import controller.Path;
import controller.SwitchScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DeleteLibraryController extends SwitchScene implements Path {
    ShowLibraryController showLibraryController;
    @FXML
    private ComboBox<String> id_deleteMovie;
    @FXML
    private Button id_deleteButtonMovie;

    @FXML
    void initialize() {
        id_deleteMovie.getItems().addAll(contentColumnNameMovie);
    }
    public void deleteMovie(ActionEvent actionEvent) throws FileNotFoundException {
        System.out.println(id_deleteMovie.getValue());

    }
}
