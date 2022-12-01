package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;
import utilities.JDBC;
import utilities.TimeConversion;

import java.sql.*;
import java.time.LocalDateTime;

public class CustomerDAO {

    public int updateCustomer(Customer customer) {
        try {
            String sql = "UPDATE CUSTOMERS SET Customer_Name = ?, Address = ?, Postal_Code = ?, Phone = ?, Create_Date = ?, Created_By = ?, Last_Update = ?, Last_Updated_By = ?, Division_ID = ? WHERE Customer_ID = ?";

            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getCustomerAddress());
            preparedStatement.setString(3, customer.getCustomerPostalCode());
            preparedStatement.setString(4, customer.getCustomerPhone());
            preparedStatement.setInt(9, customer.getDivisionId());
            preparedStatement.setInt(10, customer.getCustomerId());
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

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

    public static void deleteCustomer(int customerId) {
        try {
            String sql = "DELETE FROM CUSTOMERS WHERE Customer_ID = ?";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            preparedStatement.setInt(1, customerId);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //return 0;
    }

    public Customer getCustomer(int customerId) {
        return null;
    }

    public static ObservableList<Customer> getAllCustomer() {

        ObservableList<Customer> customerList = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM customers INNER JOIN first_level_divisions ON customers.Division_ID = first_level_divisions.Division_ID INNER JOIN countries ON first_level_divisions.COUNTRY_ID = countries.Country_ID ORDER BY Customer_ID ASC";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customers.Customer_ID");
                String name = resultSet.getString("customers.Customer_Name");
                String address = resultSet.getString("customers.Address");
                String postalCode = resultSet.getString("customers.Postal_Code");
                String phone = resultSet.getString("customers.Phone");
                int countryId = resultSet.getInt("countries.Country_ID");
                int divisionId = resultSet.getInt("customers.Division_ID");

                Customer c = new Customer(customerId, name, address, postalCode, phone, countryId, divisionId);
                customerList.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
}
