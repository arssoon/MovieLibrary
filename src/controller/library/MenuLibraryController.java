package controller.library;

import controller.Path;
import controller.SwitchScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuLibraryController extends SwitchScene implements Path {

    public Button id_showMovie;
    public Button id_addMovie;
    public Button id_deleteMovie;
    public Button id_rankingMovie;

    public void rankingMovie() {
        mainController.loadRankingLibraryWindow(Path.PATH_RANKING_LIBRARY);
    }

    public void deleteMovie() {
        mainController.loadDeleteLibraryWindow(Path.PATH_DELETE_LIBRARY);
    }

    public void addMovie() {
        mainController.loadAddLibraryWindow(Path.PATH_ADD_LIBRARY);
    }

    public void showMovie() {
        mainController.loadShowLibraryWindow(Path.PATH_SHOW_LIBRARY);
    }

}
