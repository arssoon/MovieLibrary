package controller.saveandreadfile;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SavePasswordInFile {

    public void saveToFile(String name, String password, String fileName,
                           boolean isSavePassword, int yearCreateMovie, double ratingMovie
    ) {
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream(fileName, true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if(isSavePassword) {
                //-------  SAVING LOGIN AND PASSWORD IN A FILE   -----------------------------------
                if (out != null) {
                    out.append(name + ", " + password + "\n" );
                }
            } else {
                //-------  SAVING NAME, YEAR, CATEGORY AND RATING MOVIES IN A FILE   -----------------------------------
                out.append(name + ", "
                        + yearCreateMovie + ", "
                        + password + ", "
                        + ratingMovie + "\n"
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
