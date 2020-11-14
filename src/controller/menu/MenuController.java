package controller.menu;

import controller.Path;
import controller.SwitchScene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MenuController extends SwitchScene implements Path {

    public VBox paneMenu;
    public Button id_login;
    public Button id_signup;

    @FXML
    public void loadLoginWindow()  {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(Path.PATH_MENU_LOGIN));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LoginController loginController = loader.getController();
        loginController.setMenuController(this);
        loginController.setMainController(mainController);
        setRightWindow(pane);
    }

    @FXML
    public void loadSignUpWindow() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(Path.PATH_MENU_SIGNUP));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setRightWindow(pane);
    }



}
