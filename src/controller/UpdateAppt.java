package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

public class UpdateAppt {

    public ComboBox updateCustomer;
    public DatePicker updateDate;
    public ComboBox updateStartTime;
    public ComboBox updateEndTime;
    public ComboBox updateUser;
    public ComboBox updateApptContact;
    public TextField updateTitle;
    public TextField updateDescription;
    public ListView updateApptType;
    public TextField updateApptId;

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

    public void saveUpdateAppt(ActionEvent actionEvent) throws IOException {
        //TODO: Create save appt method
        SceneMovements.goToApptList(actionEvent);
    }

    public void cancelUpdateAppt(ActionEvent actionEvent) throws IOException {
        //TODO: Add alert confirming canceling appt update
        SceneMovements.goToApptList(actionEvent);
    }

}
