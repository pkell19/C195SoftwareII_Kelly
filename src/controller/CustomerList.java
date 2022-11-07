package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import model.Customer;

import java.io.IOException;

public class CustomerList {
    public TableColumn <Customer, Integer> customerId;
    public TableColumn <Customer, String> customerName;
    public TableColumn <Customer, String> customerAddress;
    public TableColumn <Customer, String> customerPostalCode;
    public TableColumn <Customer, String> customerPhone;
    public TableColumn <Customer, Integer> customerCountry;
    public TableColumn <Customer, Integer> customerDivision;

    public void onActionToAppt(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToApptList(actionEvent);
    }

    public void onActionToReport(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToReportPage(actionEvent);
    }

    public void onActionToMainMenu(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToMainMenu(actionEvent);
    }

    public void toUpdateCustomer(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToUpdateCustomer(actionEvent);
    }

    public void toNewCustomer(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToNewCustomer(actionEvent);
    }

    public void deleteCustomer(ActionEvent actionEvent) {
        //TODO: Complete delete customer method
    }
}
