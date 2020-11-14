package controller.library;

import controller.Path;
import controller.SwitchScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeleteLibraryController extends SwitchScene implements Path {
    public Button id_deleteButtonMovie;
    @FXML
    private ComboBox<String> id_deleteMovie;
    @FXML
    private Label id_informatonSuccessfulLabel;
    int chooseNumber;

    @FXML
    void initialize() {
        id_deleteMovie.getItems().addAll(listOfMovie);
    }

    public void deleteMovie(ActionEvent actionEvent) throws IOException {
        String myString = id_deleteMovie.getValue();
        if(myString != null) {
            Pattern p = Pattern.compile("\\d");
            Matcher m = p.matcher(myString);
            List<Integer> ints = new ArrayList<>();

            while (m.find()) {
                String i = m.group();
                ints.add(Integer.valueOf(i));
            }
            //-------  ENTERING THE FIRST VALUE FROM THE "INIT" TABLE TO THE VARIABLE  -----------------------------------
            chooseNumber = ints.get(0);
            deleteRecordInFile(id_deleteMovie.getValue());
            id_informatonSuccessfulLabel.setText("Usunięcie filmu " + id_deleteMovie.getValue()
                    + " zakończyło się powodzeniem.");
        } else {
            id_informatonSuccessfulLabel.setText("Usunięcie filmu zakończyło się NIEPOWODZENIEM!");
        }

    }

    // -----    DELETE MOVIE    ------------------------------------------------------
    public void deleteRecordInFile(String lineToRemove) throws IOException {
        File oldFile = new File(Path.PATH_MOVIES);
        File newFile = new File(Path.PATH_MOVIESTEMP);

        BufferedReader reader = new BufferedReader(new FileReader(oldFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));

        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            //-------  Trim newline when comparing with lineToRemove  -----------------------------------
            String trimmedLine = currentLine.trim();
            if (trimmedLine.equals(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.flush();
        writer.close();
        reader.close();

        //-------  delete old file and replace him newFile about new name file  -----------------------------------
        if(oldFile.exists()) {
            oldFile.delete();
        }
        newFile.renameTo(oldFile);

    }

}
