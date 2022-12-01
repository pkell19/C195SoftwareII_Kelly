package controller;

import dao.CountryDAO;
import dao.DivisionDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Country;
import model.Division;
import org.w3c.dom.Text;

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
        ObservableList<Division> divisions = DivisionDAO.getAllDivisions();
        newCountryCombo.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            TextField editor = newCountryCombo.getEditor();
            Country selected = newCountryCombo.getSelectionModel().getSelectedItem();
            if (selected == null || !selected.equals()) {
                newDivisionCombo.setVisible(true);
            }
        });

    }

        newDivisionCombo.setVisibleRowCount(5);
        newDivisionCombo.setPromptText("Select division.");

        while (newCountryCombo.getSelectionModel().))


    }
    public void onActSaveCustList(ActionEvent actionEvent) throws IOException {

        try {
            String name = String.valueOf(newCustomerName.getText());
            String address = String.valueOf(newAddress.getText());
            String postalCode = String.valueOf(newPostalCode.getText());
            String phone = String.valueOf(newPhoneNumber.getText());
            //int countryId = Integer.parseInt(newCountry.get());
            //int divisionId = Integer.parseInt(newDivision.getText());

            if (name.isEmpty() | address.isEmpty() | postalCode.isEmpty() | phone.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please complete every field!", ButtonType.OK);
                alert.setTitle("");
                alert.showAndWait();
            } else {
                //TODO: enter validation statements here
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        //TODO: Add coding to save to customer list
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
