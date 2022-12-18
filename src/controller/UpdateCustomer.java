package controller;

import dao.CountryDAO;
import dao.CustomerDAO;
import dao.DivisionDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Country;
import model.Customer;
import model.Division;
import utilities.SceneMovements;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class UpdateCustomer implements Initializable {
    public TextField updateCustomerName;
    public TextField updateAddress;
    public TextField updatePostalCode;
    public TextField updatePhoneNumber;
    public ComboBox<Country> updateCountryCombo;
    public ComboBox<Division> updateDivisionCombo;
    public TextField customerId;

    ObservableList<Country> countries = CountryDAO.getAllCountries();
    private static Customer passedCustomer;
    public static void passingTheCustomer(Customer customer){
        passedCustomer = customer;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateCustomerName.setText(String.valueOf(passedCustomer.getCustomerName()));
        updateAddress.setText(String.valueOf(passedCustomer.getCustomerAddress()));
        updatePostalCode.setText(String.valueOf(passedCustomer.getCustomerPostalCode()));
        updatePhoneNumber.setText(String.valueOf(passedCustomer.getCustomerPhone()));
        Country passedCountry = CountryDAO.getCountry(passedCustomer.getCountryId());
        Division passedDivision = DivisionDAO.getDivision(passedCustomer.getDivisionId());
        updateCountryCombo.setValue(passedCountry); //DONE: Fix
        updateDivisionCombo.setValue(passedDivision);
        customerId.setText(String.valueOf(passedCustomer.getCustomerId()));
    }

    public void updateCountrySelection(MouseEvent actionEvent) {
        updateDivisionCombo.getSelectionModel().clearSelection();
        updateDivisionCombo.setValue(null);
        updateCountryCombo.setItems(countries);
        //DONE: Fix
    }

    public void onSelectCustomer(ActionEvent actionEvent) {

        Country selectedCountry = updateCountryCombo.getSelectionModel().getSelectedItem();
        updateDivisionCombo.setItems(DivisionDAO.filterDivisionCombo(selectedCountry.getCountryId()));
        updateDivisionCombo.setVisibleRowCount(5);
    }

    public void onActSaveCustList(ActionEvent actionEvent) throws IOException {
        //TODO: Add save to customer list
        try {
            String name = String.valueOf(updateCustomerName.getText());
            String address = String.valueOf(updateAddress.getText());
            String postalCode = String.valueOf(updatePostalCode.getText());
            String phone = String.valueOf(updatePhoneNumber.getText());
            int countryId = updateCountryCombo.getValue().getCountryId();
            int divisionId = updateDivisionCombo.getValue().getDivisionId();
            int custId = Integer.parseInt(customerId.getText());

        if (name.isEmpty() | address.isEmpty() | postalCode.isEmpty() | phone.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please complete every field!", ButtonType.OK);
            alert.setTitle("");
            alert.showAndWait();
        } else {
            //TODO: enter validation statements here
            Customer c = new Customer(custId, name, address, postalCode, phone, countryId, divisionId);
            CustomerDAO.updateCustomer(c);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Customer information saved!", ButtonType.OK);
            alert.showAndWait();
            SceneMovements.goToCustomerList(actionEvent);
        }
        //DONE: Add coding to save to customer list
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

        public void onActNoSaveCustList (ActionEvent actionEvent) throws IOException {
            //DONE: Add alert stating customer data not saved
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit? Data will be lost.", ButtonType.YES,ButtonType.NO);
            alert.setTitle("");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES) {
                SceneMovements.goToCustomerList(actionEvent);
            }
        }

        public void onActionToCustomer (ActionEvent actionEvent) throws IOException {
            SceneMovements.goToCustomerList(actionEvent);
        }

        public void onActionToReport (ActionEvent actionEvent) throws IOException {
            SceneMovements.goToReportPage(actionEvent);
        }

        public void onActionToMainMenu (ActionEvent actionEvent) throws IOException {
            SceneMovements.goToMainMenu(actionEvent);
        }

        public void onActionToAppt (ActionEvent actionEvent) throws IOException {
            SceneMovements.goToApptList(actionEvent);
        }
}
