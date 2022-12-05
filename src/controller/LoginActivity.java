package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import utilities.SceneMovements;

import java.io.IOException;

public class LoginActivity {
    public TextField userName;
    public TextField password;

    public void onActCheckLogin(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToMainMenu(actionEvent);
    }
}
