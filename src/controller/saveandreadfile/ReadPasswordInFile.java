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
                } else {
                    loadDataFromFile(br, dataList);
                    br.close();
                }

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Plik nie istnieje.");
        }
    }

    public void loadDataFromFile(BufferedReader br, ObservableList<Movie> dataList) {
        try {
            String line;
            String FieldDelimiter = ", ";

            int lineNextVerse=0;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);

                if( lineNextVerse < 4) {
                    //line wyswietla pierwsza linie, br.readLine kolejne
                    Movie movie = new Movie(fields[0],
                            Integer.parseInt(fields[1]),
                            fields[2],
                            Double.parseDouble(fields[3])
                );
                    // dodanie danych do wierwsza
                    dataList.add(movie);
                    lineNextVerse++;
                }
                lineNextVerse = 0;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("pierwszy catch: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Drugi catch: " + ex.getMessage());
        }
    }

    public boolean conditionLogin(BufferedReader br) throws IOException {
        int lines = 0;
        String line;

        while ((line = br.readLine()) != null) {
            lines++;
            // sprawdzenie parzystosci ostatniego bitu liczby (lines & 1)
            if (name.equals(line) && ((lines & 1) != 0)) {
                System.out.println("Login: " + name);
                //TODO uzyj br.readLine do kolejnego wiersza
            } else if (password.equals(line) && ((lines & 1) == 0)) {
                label.setText("BRAWO, wszystko się zgadza!");
                System.out.println("PASS: " + password);
                return true;
            } else {
                label.setText("Nazwa użytkownika bądź hasło jest nieprawidłowe!");
                return false;
            }
        }
        return false;
    }

}
