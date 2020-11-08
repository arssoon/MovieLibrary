package controller.menu;

import controller.Path;
import controller.SwitchScene;
import controller.saveandreadfile.ReadPasswordInFile;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;


public class LoginController extends SwitchScene implements Path {

    public void logInAction() {
        userName = id_user.getText();
        password = id_password.getText();
        readPasswordInFile = new ReadPasswordInFile(userName, password, errorLabel);
        readPasswordInFile.loadFromFile("logs.txt", true);

        // if login is successful, a different window will appear
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
