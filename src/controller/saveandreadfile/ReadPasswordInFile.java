package controller.saveandreadfile;

import controller.SwitchScene;
import controller.library.Movie;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

import java.io.*;

public class ReadPasswordInFile extends SwitchScene {
    public boolean successfulLogin;
    String name, password;
    Label label;
    ObservableList<Movie> dataList;

    public ReadPasswordInFile(String name, String password, Label label) {
        this.name = name;
        this.password = password;
        this.label = label;
    }

    public ReadPasswordInFile(ObservableList<Movie> dataList) {
        this.dataList = dataList;
    }

    public void loadFromFile(String file, boolean isPasswordFile) {
        File log = new File(file);
        BufferedReader br;

        if (log.exists()) {
            try {
                br = new BufferedReader(new FileReader(file));
                if (isPasswordFile) {
                    successfulLogin = conditionLogin(br);
                    br.close();
                } else {
                    loadDataFromFile(br, dataList);
                    br.close();
                }
            } catch (FileNotFoundException ex) {
                ex.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Plik nie istnieje.");
        }
    }

    public void loadDataFromFile(BufferedReader br, ObservableList<Movie> dataList) throws IOException {
        String line;
        //-------  WORDS IN A ROW SEPARATOR  -----------------------------------
        String FieldDelimiter = ", ";

        while ((line = br.readLine()) != null) {
            String[] fields = line.split(FieldDelimiter, -1);

            //-------  LINE SHOWS THE FIRST LINE BUT br.readLine THE NEXT   -----------------------------------
            Movie movie = new Movie(fields[0],
                    Integer.parseInt(fields[1]),
                    fields[2],
                    Double.parseDouble(fields[3])
            );
            //-------  ADDING DATA TO THE ROW   -----------------------------------
            dataList.add(movie);
        }
    }

    public boolean conditionLogin(BufferedReader br) throws IOException {
        String line;
        String FieldDelimiter = ", ";

        while ((line = br.readLine()) != null) {
            String[] fields = line.split(FieldDelimiter, -1);
            //-------  CHECK LOGIN AND PASSWORD   -----------------------------------
            if (name.equals(fields[0]) && password.equals(fields[1])) {
                label.setText("Logowanie powiodło się.");
                return true;
            } else {
                label.setText("Nazwa użytkownika bądź hasło jest nieprawidłowe!");
            }
        }
        return false;
    }

}
