package controller.menu;

import controller.Path;
import controller.SwitchScene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.io.IOException;

public class MenuController extends SwitchScene implements Path {

    @FXML
    public void loadLoginWindow(MouseEvent event)  {
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
