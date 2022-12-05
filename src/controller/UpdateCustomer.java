package controller;

import dao.CountryDAO;
import dao.CustomerDAO;
import dao.DivisionDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Country;
import model.Customer;
import model.Division;
import utilities.SceneMovements;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateCustomer implements Initializable {
    public TextField updateCustomerName;
    public TextField updateAddress;
    public TextField updatePostalCode;
    public TextField updatePhoneNumber;
    public ComboBox<Country> updateCountryCombo;
    public ComboBox<Division> updateDivisionCombo;

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
        Country passedCountry = CountryDAO.getCountry(passedCustomer.getCustomerId());
        Division passedDivision = DivisionDAO.getDivision(passedCustomer.getDivisionId());
        updateCountryCombo.setValue(passedCountry); //TODO: Fox
        updateDivisionCombo.setValue(passedDivision);
    }

    public void updateCountrySelection(ActionEvent actionEvent) {
        updateDivisionCombo.getSelectionModel().clearSelection();
        updateCountryCombo.setItems(countries);
        Country selectedCountry = updateCountryCombo.getSelectionModel().getSelectedItem();
        updateDivisionCombo.setItems(DivisionDAO.filterDivisionCombo(selectedCountry.getCountryId()));
        updateDivisionCombo.setVisibleRowCount(5);
        //TODO: Fix
    }

    public void onActSaveCustList(ActionEvent actionEvent) {
        //TODO: Add save to customer list
        String name = String.valueOf(updateCustomerName.getText());
        String address = String.valueOf(updateAddress.getText());
        String postalCode = String.valueOf(updatePostalCode.getText());
        String phone = String.valueOf(updatePhoneNumber.getText());
        int countryId = updateCountryCombo.getValue().getCountryId();
        int divisionId = updateDivisionCombo.getValue().getDivisionId();
        SceneMovements.goToCustomerList(actionEvent);

        if (name.isEmpty() | address.isEmpty() | postalCode.isEmpty() | phone.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please complete every field!", ButtonType.OK);
            alert.setTitle("");
            alert.showAndWait();
        }
        //TODO: enter validation statements here
        Customer updatedCustomer = new Customer(name, address, postalCode, phone, countryId, divisionId);
        CustomerDAO.createCustomer(updatedCustomer);

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Customer information saved!", ButtonType.OK);
        alert.showAndWait();
        SceneMovements.goToCustomerList(actionEvent);
    }

        public void onActNoSaveCustList (ActionEvent actionEvent) throws IOException {
            //TODO: Add alert stating customer data not saved
            SceneMovements.goToCustomerList(actionEvent);
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
