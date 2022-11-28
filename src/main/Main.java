package main;
/**
 * @author Patty Kelly
 */
import utilities.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilities.TimeConversion;

import java.sql.SQLException;
import java.time.LocalDate;
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
        //launch(args);
        /*int rowsAffected = CustomerQuery.deleteCustomer(4);
        if (rowsAffected > 0) {
            System.out.println("Delete successful!");
        } else {
            System.out.println("Delete failed!");
        }*/

        //CustomerQuery.read();

        //CustomerQuery.read("28198");


        System.out.println(TimeConversion.convertLDTtoUTCTimestamp(LocalDate.now(), LocalTime.now()));

        JDBC.closeConnection();
    }
}
