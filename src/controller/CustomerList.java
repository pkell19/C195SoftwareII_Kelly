package controller;

import dao.CustomerDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerList implements Initializable{
    public TableColumn <Customer, Integer> customerIdCol;
    public TableColumn <Customer, String> customerNameCol;
    public TableColumn <Customer, String> customerAddressCol;
    public TableColumn <Customer, String> customerPostalCodeCol;
    public TableColumn <Customer, String> customerPhoneCol;
    public TableColumn <Customer, Integer> customerCountryCol;
    public TableColumn <Customer, Integer> customerDivisionCol;
    public TableView<Customer> customerListTable;

    ObservableList<Customer> customerList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customerAddressCol.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        customerPostalCodeCol.setCellValueFactory(new PropertyValueFactory<>("customerPostalCode"));
        customerPhoneCol.setCellValueFactory(new PropertyValueFactory<>("customerPhone"));
        customerCountryCol.setCellValueFactory(new PropertyValueFactory<>("customerCountry"));
        customerDivisionCol.setCellValueFactory(new PropertyValueFactory<>("divisionId"));
        //TODO: Figure out how to populate the table with the SQL data
        customerListTable.setItems(customerList);
    }
    public void onActionToAppt(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToApptList(actionEvent);
    }

    public void onActionToReport(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToReportPage(actionEvent);
    }

    public void onActionToMainMenu(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToMainMenu(actionEvent);
    }

    public void toUpdateCustomer(ActionEvent actionEvent) throws IOException {
        //TODO: Add selection and pass to update customer table
        SceneMovements.goToUpdateCustomer(actionEvent);
    }

    public void toNewCustomer(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToNewCustomer(actionEvent);
    }

    public void deleteCustomer(ActionEvent actionEvent) {
        //TODO: Complete delete customer method
    }


}
