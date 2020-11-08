package controller.saveandreadfile;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SavePasswordInFile {

    public void saveToFile(String name, String password, String fileName,
                           boolean isSavePassword, int yearCreateMovie, double reatingMovie, int idMovie
    ) {
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream(fileName, true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            if(isSavePassword) {
                out.append(name + "\n" + password);
            } else {

                out.append(idMovie + "\n"
                        + name + "\n"
                        + yearCreateMovie + "\n"
                        + password + "\n"
                        + reatingMovie + "\n"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR! Nie można zapisać elementów.", "INFORMATION MESSAGE", JOptionPane.ERROR_MESSAGE);
        } finally {
            out.close();
        }
    }
}
