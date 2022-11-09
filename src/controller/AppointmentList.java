package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import model.Appointment;

import java.io.IOException;
import java.time.LocalDateTime;

public class AppointmentList {
    public TableColumn <Appointment, Integer> apptId;
    public TableColumn <Appointment, String> apptTitle;
    public TableColumn <Appointment, String> apptDescription;
    public TableColumn <Appointment, String> apptLocation;
    public TableColumn <Appointment, String> apptContact;
    public TableColumn <Appointment, String> apptType;
    public TableColumn <Appointment, LocalDateTime> apptDate;
    public TableColumn <Appointment, LocalDateTime> apptStartTime;
    public TableColumn <Appointment, LocalDateTime> apptEndTime;
    public TableColumn <Appointment, Integer> apptCustomerId;
    public TableColumn <Appointment, Integer> apptUserId;

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
