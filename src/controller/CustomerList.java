package controller;

import dao.CustomerDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
    ObservableList<Customer> customerList = CustomerDAO.getAllCustomer();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        customerListTable.setItems(customerList);
        customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customerAddressCol.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        customerPostalCodeCol.setCellValueFactory(new PropertyValueFactory<>("customerPostalCode"));
        customerPhoneCol.setCellValueFactory(new PropertyValueFactory<>("customerPhone"));
        customerCountryCol.setCellValueFactory(new PropertyValueFactory<>("countryId"));
        customerDivisionCol.setCellValueFactory(new PropertyValueFactory<>("divisionId"));
        //DONE: Figure out how to populate the table with the SQL data

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

    public void toUpdateCustomer(ActionEvent actionEvent) {
        Customer c = customerListTable.getSelectionModel().getSelectedItem();
        UpdateCustomer.updateCustomer(c);

        if (c == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "First select the customer you want to delete.");
            alert.setTitle("Select Customer");
            alert.showAndWait();
        }
         //DONE: Add selection and pass to update customer table
        try {
            SceneMovements.goToUpdateCustomer(actionEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toNewCustomer(ActionEvent actionEvent) throws IOException {
        SceneMovements.goToNewCustomer(actionEvent);
    }

    public void deleteCustomer(ActionEvent actionEvent) {
        Customer c = customerListTable.getSelectionModel().getSelectedItem();
        if (c == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "First select the customer you want to modify.");
            alert.setTitle("Select Customer");
            alert.showAndWait();
        }
        //DONE: Complete delete customer method
        //TODO: add reference to lambda
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete " + c.getCustomerName() + "?");
        alert2.setTitle("Verify Deletion");
        alert2.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                CustomerDAO.deleteCustomer(c.getCustomerId());
            }
        });
    }
}
