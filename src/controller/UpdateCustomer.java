package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Customer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateCustomer implements Initializable {
    public TextField updateCustomerName;
    public TextField updateAddress;
    public TextField updatePostalCode;
    public TextField updatePhoneNumber;
    public TextField updateCountry;
    public TextField updateDivision;
    public TextField customerID;

    private static Customer modCustomer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateCustomerName.setText(String.valueOf(modCustomer.getCustomerName()));
        updateAddress.setText(String.valueOf(modCustomer.getCustomerAddress()));
        updatePostalCode.setText(String.valueOf(modCustomer.getCustomerPostalCode()));
        updatePhoneNumber.setText(String.valueOf(modCustomer.getCustomerPhone()));
        updateCountry.setText(String.valueOf(modCustomer.getCountryId()));
        updateDivision.setText(String.valueOf(modCustomer.getDivisionId()));
        customerID.setText(String.valueOf(modCustomer.getCustomerId()));
    }

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

    public static void updateCustomer(Customer customer) {modCustomer = customer;}


}
