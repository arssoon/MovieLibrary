package controller;

import controller.library.*;
import controller.menu.MenuController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainController extends SwitchScene implements Path {
    @FXML
    public StackPane mainPane;
    @FXML
    public AnchorPane anchorPaneRight;
    @FXML
    public AnchorPane anchorPaneLeft;
    @FXML
    protected SplitPane splitPaneLibrary;
    public AnchorPane getAnchorPaneRight() {
        return anchorPaneRight;
    }

    @FXML
    public void initialize() {
        loadMenuWindow(PATH_MENU);
    }

    //-------  loading the MAIN MENU window   -----------------------------------
    public void loadMenuWindow(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        Pane pane = new Pane();
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuController menuController = loader.getController();
        menuController.setMainController(this);
        setLeftWindow(pane, anchorPaneLeft);
    }

    public void loadLibraryMenuWindow(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        Pane pane = new Pane();
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuLibraryController menuLibraryController = loader.getController();
        menuLibraryController.setMainController(this);
        setLeftWindow(pane, anchorPaneLeft);
    }

    public void loadShowLibraryWindow(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        Pane pane = new Pane();
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ShowLibraryController showLibraryController = loader.getController();
        showLibraryController.setMainController(this);
        setRightWindow(pane, anchorPaneRight);
    }

    public void loadAddLibraryWindow(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        Pane pane = new Pane();
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AddLibraryController addLibraryController = loader.getController();
        addLibraryController.setMainController(this);
        setRightWindow(pane, anchorPaneRight);
    }

    public void loadDeleteLibraryWindow(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        Pane pane = new Pane();
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DeleteLibraryController deleteLibraryController = loader.getController();
        deleteLibraryController.setMainController(this);
        setRightWindow(pane, anchorPaneRight);
    }

    public void loadRankingLibraryWindow(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        Pane pane = new Pane();
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        RankingLibraryController rankingLibraryController = loader.getController();
        rankingLibraryController.setMainController(this);
        setRightWindow(pane, anchorPaneRight);
    }

}
