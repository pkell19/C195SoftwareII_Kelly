package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointment;
import model.Customer;
import utilities.JDBC;
import utilities.TimeConversion;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AppointmentDAO {

    public static ObservableList<Appointment> getAllAppointments (){
        ObservableList<Appointment> alist = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM APPOINTMENTS";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int apptId = resultSet.getInt("Appointment_ID");
                String title = resultSet.getString("Title");
                String description = resultSet.getString("Description");
                String location = resultSet.getString("Location");
                String type = resultSet.getString("Type");
                Timestamp s = resultSet.getTimestamp("Start");
                LocalTime start = s.toLocalDateTime().toLocalTime();
                LocalDate date = s.toLocalDateTime().toLocalDate();
                Timestamp e = resultSet.getTimestamp("End");
                LocalTime end = e.toLocalDateTime().toLocalTime();
                int customerId = resultSet.getInt("Customer_ID");
                int userId = resultSet.getInt("User_ID");
                int contactId = resultSet.getInt("Contact_ID");

                Appointment a = new Appointment(apptId, title, description, location, type, date, start, end, customerId, userId, contactId);
                alist.add(a);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return alist;
    }

    public int updateAppointment(Appointment appointment) {
        Timestamp startDate = TimeConversion.convertLDTtoUTCTimestamp(appointment.getApptDate(), appointment.getApptStartTime());
        Timestamp endDate = TimeConversion.convertLDTtoUTCTimestamp(appointment.getApptDate(), appointment.getApptEndTime());
        Timestamp createDate = TimeConversion.convertLDTtoUTCTimestamp(appointment.getCreatedDate());
        Timestamp lastUpdate = TimeConversion.convertLDTtoUTCTimestamp(LocalDateTime.now());

        try {
            String sql = "UPDATE APPOINTMENTS SET Title = ?, Description = ?, Location = ?, Type = ?," +
                    " Start = ?, End = ?, Created_Date = ?, Created_By = ?, Last_Update = ?," +
                    " Last_Updated_By = ?, Customer_ID = ?, User_ID = ?, Contact_ID = ? WHERE Appointment_ID = ?";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            preparedStatement.setString(1, appointment.getApptTitle());
            preparedStatement.setString(2, appointment.getApptDescription());
            preparedStatement.setString(3, appointment.getApptLocation());
            preparedStatement.setString(4, appointment.getApptType());
            preparedStatement.setTimestamp(5, startDate);
            preparedStatement.setTimestamp(6, endDate);
            preparedStatement.setTimestamp(7, createDate);
            preparedStatement.setString(8, appointment.getCreatedBy());
            preparedStatement.setTimestamp(9, lastUpdate);
            preparedStatement.setString(10, appointment.getLastUpdatedBy());
            preparedStatement.setInt(11, appointment.getApptCustomerId());
            preparedStatement.setInt(12, appointment.getApptUserId());
            preparedStatement.setInt(13, appointment.getApptContactId());
            preparedStatement.setInt(14, appointment.getApptId());
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int deleteAppointment(Appointment appointment) {
        try {
            String sql = "DELETE FROM APPOINTMENTS WHERE Appointment_ID = ?";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            preparedStatement.setInt(1, appointment.getApptId());
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int createAppointment(Appointment appointment) {
        Timestamp startDate = TimeConversion.convertLDTtoUTCTimestamp(appointment.getApptDate(),
                                                                    appointment.getApptStartTime());
        Timestamp endDate = TimeConversion.convertLDTtoUTCTimestamp(appointment.getApptDate(),
                                                                    appointment.getApptEndTime());
        Timestamp createDate = TimeConversion.convertLDTtoUTCTimestamp(LocalDateTime.now());

        try {
            String sql = "INSERT INTO APPOINTMENTS (Title, Description, Location, Type, Start, End, Created_Date," +
                    " Create_By, Customer_ID, User_ID, Contact_) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            preparedStatement.setString(1, appointment.getApptTitle());
            preparedStatement.setString(2, appointment.getApptDescription());
            preparedStatement.setString(3, appointment.getApptLocation());
            preparedStatement.setString(4, appointment.getApptType());
            preparedStatement.setTimestamp(5, startDate);
            preparedStatement.setTimestamp(6, endDate);
            preparedStatement.setTimestamp(7, createDate);
            preparedStatement.setInt(8, appointment.getApptUserId());
            preparedStatement.setInt(9, appointment.getApptCustomerId());
            preparedStatement.setInt(10, appointment.getApptUserId());
            preparedStatement.setInt(11, appointment.getApptContactId());
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public Appointment getAppt(int apptId) {
        Appointment retrievedAppt = null;
        try {
            String sql = "SELECT * appointments WHERE Appointment_ID = '" + apptId + "'";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            int id = resultSet.getInt("Appointment_ID");
            String title = resultSet.getString("Title");
            String description = resultSet.getString("Description");
            String location = resultSet.getString("Location");
            String type = resultSet.getString("Type");
            Timestamp s = resultSet.getTimestamp("Start");
            LocalTime start = s.toLocalDateTime().toLocalTime();
            LocalDate date = s.toLocalDateTime().toLocalDate();
            Timestamp e = resultSet.getTimestamp("End");
            LocalTime end = e.toLocalDateTime().toLocalTime();
            int customerId = resultSet.getInt("Customer_ID");
            int userId = resultSet.getInt("User_ID");
            int contactId = resultSet.getInt("Contact_ID");

            retrievedAppt = new Appointment(id, title, description, location, type, date, start, end, customerId, userId, contactId);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return retrievedAppt;
    }

    public static boolean checkForCustomerAppointmentLinks (int customerId){
        int id = -1;
        try {
            String sql = "SELECT * FROM appointments WHERE Customer_ID = '" + customerId + "'";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("Appointment_ID");
            }
            if (id == -1) {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
}
