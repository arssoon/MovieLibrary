package controller.menu;

import controller.Path;
import controller.SwitchScene;
import controller.saveandreadfile.ReadFromFile;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class LoginController extends SwitchScene implements Path {

    public Pane paneLogin;
    public Button loginButton;
    public Label signupLabel;

    public void logInAction() {
        userName = id_user.getText();
        password = id_password.getText();
        readFromFile = new ReadFromFile(userName, password, errorLabel);
        readFromFile.loadFromFile(Path.PATH_LOGS, true);

        //-------  if login is successful, a different window will appear  -----------------------------------
        if (readFromFile.successfulLogin) {
            mainController.loadLibraryMenuWindow(Path.PATH_MENU_LIBRARY);
            mainController.loadShowLibraryWindow(Path.PATH_SHOW_LIBRARY);
        }
    }

    public void signUpAction() {
        menuController.loadSignUpWindow();
    }

    public void showPasswordAction() {
        showPassword(id_textFieldPassword, id_showPassword, id_password);
    }

}
