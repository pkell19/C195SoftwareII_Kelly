package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ApptQuery {

    public static int createAppt (String title, String desc, String location, String type, LocalDateTime start, LocalDateTime end, int customerId, int userId, int contactId) throws SQLException {
        String sql = "INSERT INTO APPOINTMENTS (Title, Description, Location, Type, Start, End, Customer_ID, User_ID, Contact_) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, desc);
        preparedStatement.setString(3, location);
        preparedStatement.setString(4, type);
        preparedStatement.setDate(5, start);
        preparedStatement.setDate(6, end);
        preparedStatement.setInt(7, customerId);
        preparedStatement.setInt(8, userId);
        preparedStatement.setInt(9, contactId);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected;
    }

    public static int updateAppt (String title, String desc, String location, String type, LocalDateTime start, LocalDateTime end, int customerId, int userId, int contactId, int apptId) throws SQLException {
        String sql = "UPDATE APPOINTMENTS SET Title = ?, Description = ?, Location = ?, Type = ?, Start = ?, End = ?, Customer_ID = ?, User_ID = ?, Contact_ID = ? WHERE Appointment_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, desc);
        preparedStatement.setString(3, location);
        preparedStatement.setString(4, type);
        preparedStatement.setDate(5, start);
        preparedStatement.setDate(6, end);
        preparedStatement.setInt(7, customerId);
        preparedStatement.setInt(8, userId);
        preparedStatement.setInt(9, contactId);
        preparedStatement.setInt(10, apptId);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected;
    }

    public static int deleteAppt (int apptId) throws SQLException {
        String sql = "DELETE FROM APPOINTMENTS WHERE Appointment_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
        preparedStatement.setInt(1, apptId);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected;
    }

    public static void readAppt () throws SQLException {
        String sql = "SELECT * FROM APPOINTMENTS";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int customerId = resultSet.getInt("Customer_ID");
            String name = resultSet.getString("Customer_Name");
            String address = resultSet.getString("Address");
            String postalCode = resultSet.getString("Postal_Code");
            String phone = resultSet.getString("Phone");
            int divisionId = resultSet.getInt("Division_ID");
        }
    }
    /*public static void readCustomer (String postalCode ) throws SQLException {
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
    }*/
}
