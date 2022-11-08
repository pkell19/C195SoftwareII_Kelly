package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class NewCustomer {
    public TextField newCustomerName;
    public TextField newAddress;
    public TextField newPostalCode;
    public TextField newPhoneNumber;
    public TextField newCountry;
    public TextField newDivision;
    public TextField newCustomerID;

    public void onActionToCustomer(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToCustomerList(actionEvent);
    }

    public void onActionToReport(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToReportPage(actionEvent);
    }

    public void onActSaveCustList(ActionEvent actionEvent) throws IOException {
        //TODO: Add coding to save to customer list
        SceneMovements.goToCustomerList(actionEvent);
    }

    public void onActNoSaveCustList(ActionEvent actionEvent) throws IOException {
        //TODO: Add alert stating customer was not saved.
        SceneMovements.goToCustomerList(actionEvent);
    }

    public void onActionToMainMenu(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToMainMenu(actionEvent);
    }

    public void onActionToAppt(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToApptList(actionEvent);
    }
}
