package controller.menu;

import controller.Path;
import controller.SwitchScene;
import controller.saveandreadfile.SaveInFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class SignupController extends SwitchScene {
    public Button signupButton;
    public Pane paneSignup;
    @FXML
    private TextField id_textFieldRepeatPassword;
    @FXML
    private PasswordField id_repeatPassword;
    @FXML
    private CheckBox id_showRepeatPassword;

    String repeatPassword;
    SaveInFile saveInFile;

    @FXML
    void initialize() {
        saveInFile = new SaveInFile();
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

        conditionLogin();
    }

    private void conditionLogin() {
        //-------  PASSWORD MUST HAVE MORE THAN 3 CHARACTERS  -----------------------------------
        if (password.length() > 3) {
            //-------  COMPARISON OF THE PASSWORD AND THE REPEAT PASSWORD  -----------------------------------
            if (password.equals(repeatPassword)) {
                //-------  REMOVE SPACE LIKE SIGNS  -----------------------------------
                if (!userName.trim().isEmpty() && !repeatPassword.trim().isEmpty()) {
                    errorLabelSignUp.setText("Prawidłowo zarejestrowany.");
                    saveInFile.saveToFile(userName, password, Path.PATH_LOGS,
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
