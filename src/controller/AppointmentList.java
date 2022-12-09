package controller;

import dao.AppointmentDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Appointment;
import utilities.SceneMovements;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class AppointmentList implements Initializable {
    public TableColumn <Appointment, Integer> apptIdCol;
    public TableColumn <Appointment, String> apptTitleCol;
    public TableColumn <Appointment, String> apptDescriptionCol;
    public TableColumn <Appointment, String> apptLocationCol;
    public TableColumn <Appointment, String> apptTypeCol;
    public TableColumn <Appointment, LocalDate> apptDateCol;
    public TableColumn <Appointment, LocalTime> apptStartTimeCol;
    public TableColumn <Appointment, LocalTime> apptEndTimeCol;
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
        apptDateCol.setCellValueFactory(new PropertyValueFactory<>("apptDate"));
        apptStartTimeCol.setCellValueFactory(new PropertyValueFactory<>("apptStartTime"));
        apptEndTimeCol.setCellValueFactory(new PropertyValueFactory<>("apptEndTime"));
        apptCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("apptCustomerId"));
        apptUserIdCol.setCellValueFactory(new PropertyValueFactory<>("apptUserId"));
        apptContactIdCol.setCellValueFactory(new PropertyValueFactory<>("apptContactId"));
    }

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

    public void toUpdateAppt(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToUpdateAppt(actionEvent);
    }

    public void toNewAppt(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToNewAppt(actionEvent);
    }

    public void deleteAppt(ActionEvent actionEvent) throws IOException {
        //TODO: Create delete appt method.
        SceneMovements.goToApptList(actionEvent);
    }


}
