package dao;

import utilities.AppointmentDAO;
import java.sql.*;
import java.time.LocalDateTime;

public class AppointmentQuery implements AppointmentDAO {
    @Override
    public int update(String title, String desc, String location, String type, LocalDateTime start, LocalDateTime end, int customerId, int userId, int contactId, int apptId) throws SQLException {
        Timestamp sts = Timestamp.valueOf(start);
        Timestamp ets = Timestamp.valueOf(end);

        String sql = "UPDATE APPOINTMENTS SET Title = ?, Description = ?, Location = ?, Type = ?, Start = ?, End = ?, Customer_ID = ?, User_ID = ?, Contact_ID = ? WHERE Appointment_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, desc);
        preparedStatement.setString(3, location);
        preparedStatement.setString(4, type);
        preparedStatement.setTimestamp(5, sts);
        preparedStatement.setTimestamp(6, ets);
        preparedStatement.setInt(7, customerId);
        preparedStatement.setInt(8, userId);
        preparedStatement.setInt(9, contactId);
        preparedStatement.setInt(10, apptId);
        return preparedStatement.executeUpdate();
    }

    @Override
    public int create(String title, String desc, String location, String type, LocalDateTime start, LocalDateTime end, int customerId, int userId, int contactId) throws SQLException {
        Timestamp sts = Timestamp.valueOf(start);
        Timestamp ets = Timestamp.valueOf(end);

        String sql = "INSERT INTO APPOINTMENTS (Title, Description, Location, Type, Start, End, Customer_ID, User_ID, Contact_) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, desc);
        preparedStatement.setString(3, location);
        preparedStatement.setString(4, type);
        preparedStatement.setTimestamp(5, sts);
        preparedStatement.setTimestamp(6, ets);
        preparedStatement.setInt(7, customerId);
        preparedStatement.setInt(8, userId);
        preparedStatement.setInt(9, contactId);
        return preparedStatement.executeUpdate();
    }

    @Override
    public int delete(int apptId) throws SQLException {
        String sql = "DELETE FROM APPOINTMENTS WHERE Appointment_ID = ?";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
        preparedStatement.setInt(1, apptId);
        return preparedStatement.executeUpdate();
    }

    @Override
    public void read() throws SQLException {
        String sql = "SELECT * FROM APPOINTMENTS";
        PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int apptId = resultSet.getInt("Appointment_ID");
            String name = resultSet.getString("Customer_Name");
            String address = resultSet.getString("Address");
            String postalCode = resultSet.getString("Postal_Code");
            String phone = resultSet.getString("Phone");
            int divisionId = resultSet.getInt("Division_ID");
        }
    }
}
