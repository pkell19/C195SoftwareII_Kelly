package main;
/**
 * @author Patty Kelly
 */
import dao.CustomerDAO;
import javafx.collections.ObservableList;
import model.Customer;
import utilities.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilities.TimeConversion;

import java.io.FileOutputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginActivity.fxml"));
        stage.setTitle("Log In");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        JDBC.openConnection();
        launch(args);
        /*int rowsAffected = CustomerDAO.deleteCustomer(4);
        if (rowsAffected > 0) {
            System.out.println("Delete successful!");
        } else {
            System.out.println("Delete failed!");
        }*/

        //CustomerDAO.read();

        //CustomerDAO.read("28198");

        /*ObservableList <Customer> testCustomerList = CustomerDAO.getAllCustomer();
        for (Customer c: testCustomerList) {
            System.out.println(c.getCustomerId() + " | " + c.getCustomerName() + " | " + c.getCustomerAddress()
                    + " | " + c.getCustomerPhone() + " | " + c.getCustomerPostalCode() + " | " + c.getCountryId()
                    + " | " + c.getDivisionId());
        }*/

        JDBC.closeConnection();
    }
}
