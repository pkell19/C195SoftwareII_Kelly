package controller;

import dao.AppointmentDAO;
import dao.ContactDAO;
import dao.CustomerDAO;
import dao.UserDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Appointment;
import model.Contact;
import model.Customer;
import model.User;
import utilities.SceneMovements;
import utilities.TimeConversion;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;

public class UpdateAppt implements Initializable {

    public TextField updateApptTitle;
    public TextArea updateApptDescription;
    public TextField updateApptLocation;
    public ComboBox <String> updateApptTypeCombo;
    public DatePicker updateApptDatePicker;
    public ComboBox <LocalTime> updateApptStartTimeCombo;
    public ComboBox <LocalTime> updateApptEndTimeCombo;
    public ComboBox <Customer> updateApptCustomerCombo;
    public ComboBox <User> updateApptUserCombo;
    public ComboBox <Contact> updateApptContactCombo;
    public TextField updateApptId;

    ObservableList<Appointment> apptList = FXCollections.observableArrayList();
    private static Appointment passedAppt;
    public static void passingTheAppointment(Appointment appointment){
        passedAppt = appointment;
    }
    ObservableList<String> types = AppointmentDAO.getApptTypes();
    ObservableList<Customer> customerList = CustomerDAO.getAllCustomer();
    ObservableList<Contact> contactList = ContactDAO.getallContacts();
    ObservableList<User> userList = UserDAO.getAllUsers();
    ObservableList<LocalTime> times = TimeConversion.timeList();
    Customer passedCustomer = null;
    User passedUser = null;
    Contact passedContact = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Setting title, description, and location fields
        updateApptTitle.setText(String.valueOf(passedAppt.getApptTitle()));
        updateApptDescription.setText(String.valueOf(passedAppt.getApptDescription()));
        updateApptLocation.setText(String.valueOf(passedAppt.getApptLocation()));

        //Setting type combo box
        updateApptTypeCombo.setItems(types);
        updateApptTypeCombo.setValue(passedAppt.getApptType());
        updateApptTypeCombo.setVisibleRowCount(5);

        //Setting date picker
        updateApptDatePicker.setValue(passedAppt.getApptStartDateTime().toLocalDate());

        //Setting start time combo box
        updateApptStartTimeCombo.setItems(times);
        updateApptStartTimeCombo.setValue(passedAppt.getApptStartDateTime().toLocalTime());
        updateApptStartTimeCombo.setVisibleRowCount(5);

        //Setting end time combo box
        updateApptEndTimeCombo.setItems(times);
        updateApptEndTimeCombo.setValue(passedAppt.getApptEndDateTime().toLocalTime());
        updateApptEndTimeCombo.setVisibleRowCount(5);

        //Setting customer combo box
        updateApptCustomerCombo.setItems(customerList);
        passedCustomer = CustomerDAO.getCustomer(passedAppt.getApptCustomerId());
        updateApptCustomerCombo.setValue(passedCustomer);
        updateApptCustomerCombo.setVisibleRowCount(5);

        //Setting user combo box
        updateApptUserCombo.setItems(userList);
        passedUser = UserDAO.getUser(passedAppt.getApptUserId());
        updateApptUserCombo.setValue(passedUser);
        updateApptUserCombo.setVisibleRowCount(5);

        //Setting contact combo box
        updateApptContactCombo.setItems(contactList);
        passedContact = ContactDAO.getContact(passedAppt.getApptContactId());
        updateApptContactCombo.setValue(passedContact);
        updateApptContactCombo.setVisibleRowCount(5);

        //Setting appt id field
        updateApptId.setText(String.valueOf(passedAppt.getApptId()));
    }
    public void saveUpdateAppt(ActionEvent actionEvent) throws IOException {
        //DONE: Create save appt method
        try {
            int apptId = Integer.parseInt(updateApptId.getText());
            String title = String.valueOf(updateApptTitle.getText());
            String description = String.valueOf(updateApptDescription.getText());
            String location = String.valueOf(updateApptLocation.getText());
            String type = String.valueOf(updateApptTypeCombo.getValue());
            LocalDate date = updateApptDatePicker.getValue();
            LocalTime start = updateApptStartTimeCombo.getValue();
            LocalTime end = updateApptEndTimeCombo.getValue();
            Customer customer = updateApptCustomerCombo.getValue();
            int customerId = customer.getCustomerId();
            User user = updateApptUserCombo.getValue();
            int userId = user.getUserId();
            Contact contact = updateApptContactCombo.getValue();
            int contactId = contact.getContactId();

            if (title.isEmpty() | description.isEmpty() | location.isEmpty() | type.isEmpty() | date == null |
                    start == null | end == null) {
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
                        //TODO: Fix the time conversion issue after modifying appointments
                        LocalDateTime startDate = LocalDateTime.of(date, start);
                        LocalDateTime endDate = LocalDateTime.of(date, end);
                        Appointment a = new Appointment(apptId, title, description, location, type, startDate, endDate, customerId, userId, contactId);
                        AppointmentDAO.updateAppointment(a);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Appointment updated!", ButtonType.OK);
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
                    //DONE: enter validation statements here
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void cancelUpdateAppt(ActionEvent actionEvent) throws IOException {
        //DONE: Add alert confirming canceling appt update
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
