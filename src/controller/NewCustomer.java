package controller;

import dao.CountryDAO;
import dao.CustomerDAO;
import dao.DivisionDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Country;
import model.Customer;
import model.Division;
import utilities.SceneMovements;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class NewCustomer implements Initializable {
    public TextField newCustomerName;
    public TextField newAddress;
    public TextField newPostalCode;
    public TextField newPhoneNumber;
    public ComboBox<Country> newCountryCombo;
    public ComboBox<Division> newDivisionCombo;
    ObservableList<Country> countries = CountryDAO.getAllCountries();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newDivisionCombo.setVisible(false);
        newCountryCombo.setItems(countries);
        newCountryCombo.setVisibleRowCount(5);
        newCountryCombo.setPromptText("Select country.");
    }

    public void newCountrySelection(ActionEvent actionEvent) {
        if (newCountryCombo != null ) {
            newDivisionCombo.setVisible(true);
        }
        assert newCountryCombo != null;
        Country selectedCountry = newCountryCombo.getSelectionModel().getSelectedItem();
        newDivisionCombo.setItems(DivisionDAO.filterDivisionCombo(selectedCountry.getCountryId()));
        newDivisionCombo.setVisibleRowCount(5);
        newDivisionCombo.setPromptText("Select division.");
    }


    public void onActSaveCustList(ActionEvent actionEvent) throws IOException {

        try {
            String name = String.valueOf(newCustomerName.getText());
            String address = String.valueOf(newAddress.getText());
            String postalCode = String.valueOf(newPostalCode.getText());
            String phone = String.valueOf(newPhoneNumber.getText());
            int countryId = newCountryCombo.getValue().getCountryId();
            int divisionId = newDivisionCombo.getValue().getDivisionId();

            if (name.isEmpty() | address.isEmpty() | postalCode.isEmpty() | phone.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please complete every field!", ButtonType.OK);
                alert.setTitle("");
                alert.showAndWait();
            } else {
                //TODO: enter validation statements here
            }
            Customer c = new Customer(name, address, postalCode, phone, countryId, divisionId);
            CustomerDAO.createCustomer(c);
            if (c == null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Customer information saved!", ButtonType.OK);
                alert.showAndWait();
            }
            //DONE: Add coding to save to customer list
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        SceneMovements.goToCustomerList(actionEvent);
    }

    public void onActNoSaveCustList(ActionEvent actionEvent) throws IOException {
        //DONE: Add alert stating customer was not saved.
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit? Data will be lost.", ButtonType.YES,ButtonType.NO);
        alert.setTitle("");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES) {
            SceneMovements.goToCustomerList(actionEvent);
        }
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

    public void onActionToReport(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToReportPage(actionEvent);
    }


}
