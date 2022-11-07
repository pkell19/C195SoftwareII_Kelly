package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class NewAppt {
    public TextField newApptCustomer;
    public TextField newDate;
    public TextField newStartTime;
    public TextField newEndTime;
    public TextField newTitle;
    public TextField newDescription;
    public TextField newLocation;
    public TextArea newApptType;
    public TextField newUser;
    public TextField newApptContact;
    public TextField newApptId;

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

    public void openCalendar(ActionEvent actionEvent) {
    }

    public void openTimeDropDown(ActionEvent actionEvent) {
    }

    public void openCustDropDown(ActionEvent actionEvent) {
    }
}
