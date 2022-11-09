package controller;

import javafx.event.ActionEvent;

import java.io.IOException;

public class ReportsList {
    public void openApptByMonth(ActionEvent actionEvent) {
    }

    public void openApptByContact(ActionEvent actionEvent) {
    }

    public void openCustomerByCountry(ActionEvent actionEvent) {
    }


    public void onActionToMainMenu(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToMainMenu(actionEvent);
    }

    public void onActionToAppt(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToApptList(actionEvent);
    }

    public void onActionToCustomer(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToCustomerList(actionEvent);
    }
}
