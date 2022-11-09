package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class NewAppt {


    public TextField newTitle;
    public TextField newDescription;
    public TextArea newApptType;
    public ComboBox newCustomer;
    public DatePicker newDate;
    public ComboBox newStartTime;
    public ComboBox newEndTime;
    public TextField newApptId;
    public ComboBox newUser;
    public ComboBox newApptContact;

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
