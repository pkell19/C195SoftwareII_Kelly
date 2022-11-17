package dao;

import model.Country;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class CustomerQuery {
    public static int createCustomer (String name, String address, String postalCode, String phone, int divisionId) throws SQLException {
        String sql = "INSERT INTO CUSTOMERS (Customer_Name, Address, Postal_Code, Phone, Division_ID) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, address);
        preparedStatement.setString(3, postalCode);
        preparedStatement.setString(4, phone);
        preparedStatement.setInt(5, divisionId);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected;
    }

    public static int updateCustomer (int customerId, String name, String address, String postalCode, String phone, int divisionId) throws SQLException {
        String sql = "UPDATE CUSTOMERS SET Customer_Name = ?, Address = ?, Postal_Code = ?, Phone = ?, Division_ID = ? WHERE Customer_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, address);
        preparedStatement.setString(3, postalCode);
        preparedStatement.setString(4, phone);
        preparedStatement.setInt(5, divisionId);
        preparedStatement.setInt(6, customerId);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected;
    }

    public static int deleteCustomer (int customerId) throws SQLException {
        String sql = "DELETE FROM CUSTOMERS WHERE Customer_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
        preparedStatement.setInt(1, customerId);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected;
    }

    public static void readCustomer () throws SQLException {
        String sql = "SELECT * FROM CUSTOMERS";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int customerId = resultSet.getInt("Customer_ID");
            String name = resultSet.getString("Customer_Name");
            String address = resultSet.getString("Address");
            String postalCode = resultSet.getString("Postal_Code");
            String phone = resultSet.getString("Phone");
            int divisionId = resultSet.getInt("Division_ID");
            System.out.print(customerId + " | ");
            System.out.print(name + " | ");
            System.out.print(address + " | ");
            System.out.print(postalCode + " | ");
            System.out.print(phone + " | ");
            System.out.print(divisionId + "\n");
        }
    }
    public static void readCustomer (String postalCode ) throws SQLException {
        String sql = "SELECT * FROM CUSTOMERS WHERE Postal_Code = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
        preparedStatement.setString(1, postalCode);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int customerId = resultSet.getInt("Customer_ID");
            String name = resultSet.getString("Customer_Name");
            String address = resultSet.getString("Address");
            String zipCode = resultSet.getString("Postal_Code");
            String phone = resultSet.getString("Phone");
            int divisionId = resultSet.getInt("Division_ID");
            System.out.print(customerId + " | ");
            System.out.print(name + " | ");
            System.out.print(address + " | ");
            System.out.print(zipCode + " | ");
            System.out.print(phone + " | ");
            System.out.print(divisionId + "\n");
        }
    }
}
