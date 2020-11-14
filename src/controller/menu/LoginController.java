package controller.menu;

import controller.Path;
import controller.SwitchScene;
import controller.saveandreadfile.ReadPasswordInFile;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class LoginController extends SwitchScene implements Path {

    public Pane paneLogin;
    public Button loginButton;
    public Label signupLabel;

    public void logInAction() {
        userName = id_user.getText();
        password = id_password.getText();
        readPasswordInFile = new ReadPasswordInFile(userName, password, errorLabel);
        readPasswordInFile.loadFromFile(Path.PATH_LOGS, true);

        //-------  if login is successful, a different window will appear  -----------------------------------
        if (readPasswordInFile.successfulLogin) {
            mainController.loadLibraryMenuWindow(Path.PATH_MENU_LIBRARY);
            mainController.loadShowLibraryWindow(Path.PATH_SHOW_LIBRARY);
        } else {
            System.out.println("login lub haslo niepoprawne: " + readPasswordInFile.successfulLogin);
        }
    }

    public void signUpAction(MouseEvent mouseEvent) {
        menuController.loadSignUpWindow();
    }

    public void showPasswordAction(ActionEvent actionEvent) {
        showPassword(id_textFieldPassword, id_showPassword, id_password);
    }

}
