package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;
import utilities.CustomerInterface;
import utilities.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CustomerQuery {

    public int update(int customerId, String name, String address, String postalCode, String phone, int divisionId) throws SQLException {
        String sql = "UPDATE CUSTOMERS SET Customer_Name = ?, Address = ?, Postal_Code = ?, Phone = ?, Division_ID = ? WHERE Customer_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, address);
        preparedStatement.setString(3, postalCode);
        preparedStatement.setString(4, phone);
        preparedStatement.setInt(5, divisionId);
        return preparedStatement.executeUpdate();
    }

    public int create(String name, String address, String postalCode, String phone, int divisionId) throws SQLException {
        String sql = "INSERT INTO CUSTOMERS (Customer_Name, Address, Postal_Code, Phone, Division_ID) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, address);
        preparedStatement.setString(3, postalCode);
        preparedStatement.setString(4, phone);
        preparedStatement.setInt(5, divisionId);
        return preparedStatement.executeUpdate();
    }

    public int delete(int customerId) throws SQLException {
        String sql = "DELETE FROM CUSTOMERS WHERE Customer_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
        preparedStatement.setInt(1, customerId);
        return preparedStatement.executeUpdate();
    }

    public void readCustomers() throws SQLException {
        ObservableList<Customer> customerList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM CUSTOMERS";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int customerId = resultSet.getInt("Customer_ID");
            String name = resultSet.getString("Customer_Name");
            String address = resultSet.getString("Address");
            String postalCode = resultSet.getString("Postal_Code");
            String phone = resultSet.getString("Phone");
            Timestamp createdDate = resultSet.getTimestamp("Created_Date");
            String createdBy = resultSet.getString("Created_By");
            Timestamp lastUpdate = resultSet.getTimestamp("Last_Update");
            String lastUpdatedBy = resultSet.getString("Last_Updated_By");
            int divisionId = resultSet.getInt("Division_ID");

            //Customer customer = new Customer(customerId, name, address, postalCode, phone, createdDate, createdBy, lastUpdate, lastUpdatedBy, divisionId);
        }

    }
}
