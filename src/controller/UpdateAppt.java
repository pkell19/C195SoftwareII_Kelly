package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UpdateAppt {
    public TextField updateTitle;
    public TextField updateDescription;
    public TextField updateLocation;
    public TextArea updateApptType;
    public TextField updateApptCustomer;
    public TextField updateDate;
    public TextField updateStartTime;
    public TextField updateEndTime;
    public TextField updateUser;
    public TextField updateApptContact;
    public TextField updateApptId;

    public void onActionToMainMenu(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToMainMenu(actionEvent);
    }

    public void onActionToCustomer(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToCustomerList(actionEvent);
    }

    public void onActionToReport(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToReportPage(actionEvent);
    }

    public void openCustDropDown(ActionEvent actionEvent) {
    }

    public void openCalendar(ActionEvent actionEvent) {
    }

    public void openTimeDropDown(ActionEvent actionEvent) {
    }

    public void saveUpdateAppt(ActionEvent actionEvent) {
    }

    public void cancelUpdateAppt(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToMainMenu(actionEvent);
    }

    public void onActionToAppt(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToApptList(actionEvent);
    }
}
