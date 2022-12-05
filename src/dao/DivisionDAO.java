package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Country;
import model.Division;
import utilities.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DivisionDAO {

    public static ObservableList<Division> getAllDivisions() {

        ObservableList<Division> divisionList = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM first_level_divisions";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int divisionId = resultSet.getInt("Division_ID");
                String division = resultSet.getString("Division");
                int countryId = resultSet.getInt("Country_ID");

                Division d = new Division(divisionId, division, countryId);
                divisionList.add(d);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return divisionList;
    }
    public static ObservableList<Division> filterDivisionCombo (int countryId) {
        ObservableList<Division> filteredDivision = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM first_level_divisions, countries" +
                    " WHERE first_level_divisions.Country_ID = countries.Country_ID" +
                    " AND countries.Country_ID = \"" + countryId + "\"";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int divisionId = resultSet.getInt("first_level_divisions.Division_ID");
                String division = resultSet.getString("first_level_divisions.Division");
                Division d = new Division(divisionId, division);
                filteredDivision.add(d);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return filteredDivision;
    }

    public static Division getDivision(int id) {
        try {
            String sql = "SELECT * FROM first_level_divisions WHERE Division_ID = '" + id + "'";
            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int divisionId = resultSet.getInt("Division_ID");
                String divisionName = resultSet.getString("Division");
                int countryId = resultSet.getInt("Country_Id");
                return new Division(divisionId, divisionName, countryId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
