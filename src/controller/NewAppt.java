package controller;

import dao.ContactDAO;
import dao.CustomerDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Appointment;
import model.Contact;
import model.Customer;
import utilities.SceneMovements;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class NewAppt implements Initializable {

    public TextField newApptId;
    public TextField newApptTitle;
    public TextField newApptDescription;
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
    ObservableList<Contact> contactList = ContactDAO.getallContacts();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newApptContactCombo.setItems(contactList);
        newApptContactCombo.setVisibleRowCount(5);
        newApptContactCombo.setPromptText("Select country.");

        newApptCustomerCombo.setItems(customerList);
        newApptCustomerCombo.setVisibleRowCount(5);
        newApptCustomerCombo.setPromptText("Select customer.");

        LocalTime start = LocalTime.of(0, 1);
        LocalTime end = LocalTime.of(23, 59);

        /*while(start.isBefore(end.plusSeconds(1))){
            newApptStartCombo.getItems().add(start);
            start = start.plusMinutes(30);
        }
        newApptStartCombo.getSelectionModel().select(LocalTime.now());

        while (end.isAfter(start.plusSeconds(1))) {
            newApptEndCombo.getItems().add(end);
            end = end.plusMinutes(30);
        }
        newApptEndCombo.getSelectionModel().select(LocalTime.now());*/

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
