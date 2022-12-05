package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import utilities.SceneMovements;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenu implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public void openReportPage(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToReportPage(actionEvent);
    }

    public void openCustomerList(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToCustomerList(actionEvent);
    }

    public void openAppointmentList(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToApptList(actionEvent);
    }


}
