package controller;

import dao.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.*;
import utilities.SceneMovements;
import utilities.TimeConversion;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
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

    ObservableList<String> types = AppointmentDAO.getApptTypes();
    ObservableList<Appointment> newAppointment = FXCollections.observableArrayList();
    ObservableList<Customer> customerList = CustomerDAO.getAllCustomer();
    ObservableList<Contact> contactList = ContactDAO.getallContacts();
    ObservableList<User> userList = UserDAO.getAllUsers();
    ObservableList<LocalTime> times = TimeConversion.timeList();
    Customer customer = null;
    User user = null;
    Contact contact = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Setting type combo box
        newApptTypeCombo.setItems(types);
        newApptTypeCombo.setVisibleRowCount(5);
        newApptTypeCombo.setPromptText("Select type.");

        //Setting start time combo box
        newApptStartCombo.setItems(times);
        newApptStartCombo.setVisibleRowCount(5);
        newApptStartCombo.setPromptText("Enter start time.");

        //Setting end time combo box
        newApptEndCombo.setItems(times);
        newApptEndCombo.setVisibleRowCount(5);
        newApptEndCombo.setPromptText("Enter end time.");

        //Setting customer combo box
        newApptCustomerCombo.setItems(customerList);
        newApptCustomerCombo.setVisibleRowCount(5);
        newApptCustomerCombo.setPromptText("Select customer.");

        //Setting user combo box
        newApptUserCombo.setItems(userList);
        newApptUserCombo.setVisibleRowCount(5);
        newApptUserCombo.setPromptText("Select user.");

        //Setting contact combo box
        newApptContactCombo.setItems(contactList);
        newApptContactCombo.setVisibleRowCount(5);
        newApptContactCombo.setPromptText("Select contact.");
    }

    public void saveNewAppt(ActionEvent actionEvent) throws IOException {

        try {
            String title = String.valueOf(newApptTitle.getText());
            String description = String.valueOf(newApptDescription.getText());
            String location = String.valueOf(newApptLocation.getText());
            String type = String.valueOf(newApptTypeCombo.getValue());
            LocalDate date = newApptDatePicker.getValue();
            LocalTime start = (LocalTime) newApptStartCombo.getValue();
            LocalTime end = (LocalTime) newApptEndCombo.getValue();
            customer = (Customer) newApptCustomerCombo.getValue();
            int customerId = customer.getCustomerId();
            user = (User) newApptUserCombo.getValue();
            int userId = user.getUserId();
            contact = (Contact) newApptContactCombo.getValue();
            int contactId = contact.getContactId();

            if (title.isEmpty() | description.isEmpty() | location.isEmpty() | type.isEmpty() | date == null |
                    start == null | end == null | customer == null | user == null | contact == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please complete every field!", ButtonType.OK);
                alert.setTitle("");
                alert.showAndWait();
            } else {
                if (start.isAfter(end)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "The start time must come before the end time.", ButtonType.OK);
                    alert.setTitle("");
                    alert.showAndWait();
                } else {
                    if (start.isAfter(Appointment.BUSINESS_OPENING) && end.isBefore(Appointment.BUSINESS_CLOSING)) {
                        LocalDateTime startDate = LocalDateTime.of(date, start);
                        LocalDateTime endDate = LocalDateTime.of(date, end);
                        Appointment a = new Appointment(title, description, location, type, startDate, endDate, customerId, userId, contactId);
                        AppointmentDAO.createAppointment(a);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Appointment saved!", ButtonType.OK);
                        Optional<ButtonType> choice = alert.showAndWait();
                        if (choice.isPresent() && choice.get() == ButtonType.OK) {
                            SceneMovements.goToApptList(actionEvent);
                        }
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "The appointment hours must be between 8:00 AM and 10:00 PM.", ButtonType.OK);
                        alert.setTitle("");
                        alert.showAndWait();
                    }
                    //TODO: enter validation statements here
                }
            }
            //DONE: Add coding to save to customer list
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void cancelNewAppt(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit? Data will be lost.", ButtonType.YES,ButtonType.NO);
        alert.setTitle("");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES) {
            SceneMovements.goToApptList(actionEvent);
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
