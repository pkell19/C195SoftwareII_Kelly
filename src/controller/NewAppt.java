package controller;

import dao.CustomerDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Appointment;
import model.Customer;
import utilities.SceneMovements;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewAppt implements Initializable {

    public TextField newApptId;
    public TextField newApptTitle;
    public ListView newApptDescription;
    public TextField newApptLocation;
    public ComboBox newApptCustomerCombo;
    public DatePicker newApptDatePicker;
    public ComboBox newApptStartCombo;
    public ComboBox newApptEndCombo;
    public ComboBox newApptUserCombo;
    public ComboBox newApptContactCombo;
    public ComboBox newApptTypeCombo;

    ObservableList<Appointment> newAppointment = FXCollections.observableArrayList();
    ObservableList<Customer> customerList = CustomerDAO.getAllCustomer();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newCountryCombo.setItems(countries);
        newCountryCombo.setVisibleRowCount(5);
        newCountryCombo.setPromptText("Select country.");

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

    public void saveNewAppt(ActionEvent actionEvent) {
    }

    public void cancelNewAppt(ActionEvent actionEvent) {
    }


}
