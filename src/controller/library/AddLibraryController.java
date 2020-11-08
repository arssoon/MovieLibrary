package controller.library;

import controller.Path;
import controller.SwitchScene;
import controller.saveandreadfile.SavePasswordInFile;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddLibraryController extends SwitchScene {
    @FXML
    public TextField id_nameMovie;
    @FXML
    public TextField id_yearCreateMovie;
    @FXML
    public TextField id_directorMovie;
    @FXML
    public TextField id_ratingMovie;
    SavePasswordInFile savePasswordInFile;
    Movie movie;
    String nameMovie, directorMovie;
    int yearCreateMovie;
    double reatingMovie;

    @FXML
    void initialize() {
        savePasswordInFile = new SavePasswordInFile();
        try {
            // Zliczanie lini całego pliku --- 5 lini jest jako 1 wiersz
            idMovie = Integer.parseInt(String.valueOf((Files.lines(Paths.get(Path.PATH_MOVIES)).count())/5));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addMovie() {
        idMovie++;
        nameMovie = id_nameMovie.getText();
        yearCreateMovie = Integer.parseInt(id_yearCreateMovie.getText());
        directorMovie = id_directorMovie.getText();
        reatingMovie = Double.parseDouble(id_ratingMovie.getText());

        savePasswordInFile.saveToFile(nameMovie, directorMovie, Path.PATH_MOVIES,
                false, yearCreateMovie, reatingMovie, idMovie
        );
        movie = new Movie(idMovie, nameMovie, yearCreateMovie, directorMovie, reatingMovie);

        System.out.println("DODANO");
    }
}
