package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UpdateCustomer {
    public TextField updateCustomerName;
    public TextField updateAddress;
    public TextField updatePostalCode;
    public TextField updatePhoneNumber;
    public TextField updateCountry;
    public TextField updateDivision;
    public TextField customerID;

    public void onActSaveCustList(ActionEvent actionEvent) throws IOException {
        //TODO: Add save to customer list
        SceneMovements.goToCustomerList(actionEvent);
    }

    public void onActNoSaveCustList(ActionEvent actionEvent) throws IOException {
        //TODO: Add alert stating customer data not saved
        SceneMovements.goToCustomerList(actionEvent);
    }

    public void onActionToCustomer(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToCustomerList(actionEvent);
    }

    public void onActionToReport(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToReportPage(actionEvent);
    }

    public void onActionToMainMenu(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToMainMenu(actionEvent);
    }

    public void onActionToAppt(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToApptList(actionEvent);
    }
}
