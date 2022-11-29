package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;
import utilities.CustomerInterface;
import utilities.JDBC;
import utilities.TimeConversion;

import java.sql.*;
import java.time.LocalDateTime;

public class CustomerDAO implements CustomerInterface {

    @Override
    public int updateCustomer(Customer customer) {
        try {
            String sql = "UPDATE CUSTOMERS SET Customer_Name = ?, Address = ?, Postal_Code = ?, Phone = ?, Create_Date = ?, Created_By = ?, Last_Update = ?, Last_Updated_By = ?, Division_ID = ? WHERE Customer_ID = ?";
            Timestamp createDate = TimeConversion.convertLDTtoUTCTimestamp(customer.getCreatedDate());
            Timestamp lastUpdate = TimeConversion.convertLDTtoUTCTimestamp(LocalDateTime.now());

            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getCustomerAddress());
            preparedStatement.setString(3, customer.getCustomerPostalCode());
            preparedStatement.setString(4, customer.getCustomerPhone());
            preparedStatement.setTimestamp(5, createDate);
            preparedStatement.setString(6, customer.getCreatedBy());
            preparedStatement.setTimestamp(7, lastUpdate);
            preparedStatement.setString(8, customer.getLastUpdatedBy());
            preparedStatement.setInt(9, customer.getDivisionId());
            preparedStatement.setInt(10, customer.getCustomerId());
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public int createCustomer(Customer customer) {
        try {
            String sql = "INSERT INTO CUSTOMERS (Customer_Name, Address, Postal_Code, Phone, Create_Date, Division_ID) VALUES (?,?,?,?,?,?)";
            Timestamp createDate = TimeConversion.convertLDTtoUTCTimestamp(LocalDateTime.now());

            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getCustomerAddress());
            preparedStatement.setString(3, customer.getCustomerPhone());
            preparedStatement.setString(4, customer.getCustomerPhone());
            preparedStatement.setTimestamp(5, createDate);
            preparedStatement.setInt(6, customer.getCustomerId());
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteCustomer(int customerId) {
        try {
            String sql = "DELETE FROM CUSTOMERS WHERE Customer_ID = ?";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            preparedStatement.setInt(1, customerId);
            return preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public Customer getCustomer(int customerId) {
        return null;
    }

    @Override
    public void getAllCustomer() {
        ObservableList<Customer> customerList = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM CUSTOMERS";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("Customer_ID");
                String name = resultSet.getString("Customer_Name");
                String address = resultSet.getString("Address");
                String postalCode = resultSet.getString("Postal_Code");
                String phone = resultSet.getString("Phone");
                Timestamp cd = resultSet.getTimestamp("Created_Date");
                String createdBy = resultSet.getString("Created_By");
                Timestamp lu = resultSet.getTimestamp("Last_Update");
                String lastUpdatedBy = resultSet.getString("Last_Updated_By");
                int divisionId = resultSet.getInt("Division_ID");

                LocalDateTime createdDate = TimeConversion.convertUTCTimestamptoLDT(cd);
                LocalDateTime lastUpdate = TimeConversion.convertUTCTimestamptoLDT(lu);

                Customer c = new Customer(customerId, name, address, postalCode, phone, createdDate, createdBy, lastUpdate, lastUpdatedBy, divisionId);
                customerList.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
