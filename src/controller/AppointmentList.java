package controller;

import dao.AppointmentDAO;
import dao.CustomerDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Appointment;
import model.Customer;
import utilities.SceneMovements;
import utilities.TimeConversion;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class AppointmentList implements Initializable {
    public TableColumn <Appointment, Integer> apptIdCol;
    public TableColumn <Appointment, String> apptTitleCol;
    public TableColumn <Appointment, String> apptDescriptionCol;
    public TableColumn <Appointment, String> apptLocationCol;
    public TableColumn <Appointment, String> apptTypeCol;
    public TableColumn <Appointment, LocalDateTime> apptStartTimeCol;
    public TableColumn <Appointment, LocalDateTime> apptEndTimeCol;
    public TableColumn <Appointment, Integer> apptCustomerIdCol;
    public TableColumn <Appointment, Integer> apptUserIdCol;
    public TableColumn <Appointment, Integer> apptContactIdCol;
    public TableView <Appointment> apptListTableView;

    ObservableList<Appointment> appointmentList = AppointmentDAO.getAllAppointments();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        apptListTableView.setItems(appointmentList);
        apptIdCol.setCellValueFactory(new PropertyValueFactory<>("apptId"));
        apptTitleCol.setCellValueFactory(new PropertyValueFactory<>("apptTitle"));
        apptDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("apptDescription"));
        apptLocationCol.setCellValueFactory(new PropertyValueFactory<>("apptLocation"));
        apptTypeCol.setCellValueFactory(new PropertyValueFactory<>("apptType"));
        apptStartTimeCol.setCellValueFactory(new PropertyValueFactory<>("apptStartDateTime"));
        apptEndTimeCol.setCellValueFactory(new PropertyValueFactory<>("apptEndDateTime"));
        apptCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("apptCustomerId"));
        apptUserIdCol.setCellValueFactory(new PropertyValueFactory<>("apptUserId"));
        apptContactIdCol.setCellValueFactory(new PropertyValueFactory<>("apptContactId"));
    }
    public void toUpdateAppt(ActionEvent actionEvent) throws IOException {
        Appointment a = apptListTableView.getSelectionModel().getSelectedItem();
        UpdateAppt.passingTheAppointment(a);

        if (a == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "First select the appointment you want to modify");
            alert.setTitle("Select Customer");
            alert.showAndWait();
        }
        //DONE: Add selection and pass to update customer table
        SceneMovements.goToUpdateAppt(actionEvent);
    }

    public void toNewAppt(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToNewAppt(actionEvent);
    }

    public void deleteAppt(ActionEvent actionEvent) throws IOException {
        Appointment a = apptListTableView.getSelectionModel().getSelectedItem();
        if (a == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "First select the appointment you want to delete.");
            alert.setTitle("Select Appointment");
            alert.showAndWait();
        } else {
            Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete " + a.getApptTitle() + "?", ButtonType.YES, ButtonType.NO);
            alert2.setTitle("Verify Deletion");
            alert2.showAndWait().ifPresent(response -> {
                if (response == ButtonType.YES) {
                    AppointmentDAO.deleteAppointment(a.getApptId());
                    apptListTableView.setItems(AppointmentDAO.getAllAppointments());
                }
            });
        }
            //TODO: add reference to lambda
    }
        //DONE: Refresh table after deletion
        //DONE: Create delete appt method.

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
}
