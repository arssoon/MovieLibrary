package controller.menu;

import controller.SwitchScene;
import controller.saveandreadfile.SavePasswordInFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignupController extends SwitchScene {
    @FXML
    private TextField id_textFieldRepeatPassword;
    @FXML
    private PasswordField id_repeatPassword;
    @FXML
    private CheckBox id_showRepeatPassword;

    String repeatPassword;
    SavePasswordInFile savePasswordInFile;

    @FXML
    void initialize () {
        savePasswordInFile = new SavePasswordInFile();
    }

    public void showPasswordAction(ActionEvent actionEvent) {
        showPassword(id_textFieldPassword, id_showPassword, id_password);
    }

    public void showRepeatPasswordAction(ActionEvent actionEvent) {
        showPassword(id_textFieldRepeatPassword, id_showRepeatPassword, id_repeatPassword);
    }

    public void signUpAction(ActionEvent actionEvent) {
        userName = id_user.getText();
        password = id_password.getText();
        repeatPassword = id_repeatPassword.getText();
        //TODO zrob ponowne logowanie

        conditionLogin();
    }

    private void conditionLogin() {
        if (password.length() > 3) {
            if (password.equals(repeatPassword)) {
                if (!userName.trim().isEmpty() && !repeatPassword.trim().isEmpty()) {
                    errorLabelSignUp.setText("Prawidłowo zarejestrowany.");
                    savePasswordInFile.saveToFile(userName, password, "logs.txt",
                            true, 0, 0);
                } else {
                    errorLabelSignUp.setText("Puste pole!");
                }
            } else {
                errorLabelSignUp.setText("Hasła nie są zgodne.");
            }
        } else {
            errorLabelSignUp.setText("Hasło za krótkie min. 4 znaki!");
        }
    }

}
