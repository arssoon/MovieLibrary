package controller;

import controller.menu.MenuController;
import controller.saveandreadfile.ReadPasswordInFile;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public abstract class SwitchScene {
    @FXML
    public int idMovie;
    @FXML
    protected MainController mainController;
    @FXML
    protected MenuController menuController;
    @FXML
    protected AnchorPane anchorPaneRight;
    @FXML
    protected TextField id_user;
    @FXML
    protected TextField id_textFieldPassword;
    @FXML
    protected PasswordField id_password;
    @FXML
    protected CheckBox id_showPassword;
    @FXML
    protected Label errorLabel;
    @FXML
    protected Label errorLabelSignUp;

    protected String userName, password;

    //statyczna zmienna dla podtrzymania nazw filmów
    public static ObservableList<String> contentColumnNameMovie;
    protected ReadPasswordInFile readPasswordInFile;

    public ObservableList<String> getContentColumnNameMovie() {
        return contentColumnNameMovie;
    }

    public void setContentColumnNameMovie(ObservableList<String> contentColumnNameMovie) {
        this.contentColumnNameMovie = contentColumnNameMovie;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    protected final void setAnchorPaneRight() {
        this.anchorPaneRight = mainController.getAnchorPaneRight();
    }

    public final void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    //-------  passing to object MainController   -----------------------------------
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    //-------  LoginPane and SignUpPane setting on the left side of the pane   -----------------------------------
    public final void setLeftWindow(Pane pane, AnchorPane anchorPaneLeft) {
        anchorPaneLeft.getChildren().clear();
        anchorPaneLeft.getChildren().add(pane);
    }

    //-------  Load from MainController Library pane  -----------------------------------
    public final void setRightWindow(Pane pane, AnchorPane anchorPaneRight) {
        anchorPaneRight.getChildren().clear();
        anchorPaneRight.getChildren().add(pane);
    }

    //-------  LoginPane and SignUpPane setting on the right side of the pane   -----------------------------------
    public void setRightWindow(Pane pane) {
        setAnchorPaneRight();
        anchorPaneRight.getChildren().clear();
        anchorPaneRight.getChildren().add(pane);
    }

    //-------  method to show the password in the field  -----------------------------------
    public void showPassword(TextField textField, CheckBox checkBox, PasswordField passwordField) {
        textField.managedProperty().bind(checkBox.selectedProperty());
        textField.visibleProperty().bind(checkBox.selectedProperty());

        passwordField.managedProperty().bind(checkBox.selectedProperty().not());
        passwordField.visibleProperty().bind(checkBox.selectedProperty().not());

        // Bind the textField and passwordField text values bidirectionally.
        textField.textProperty().bindBidirectional(passwordField.textProperty());
    }
}
