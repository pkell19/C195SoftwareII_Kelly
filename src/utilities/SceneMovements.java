package utilities;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneMovements {
    public static void goToReportPage(ActionEvent actionEvent){
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(SceneMovements.class.getResource("/view/ReportsList.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 500, 400);
        stage.setTitle("Report List");
        stage.setScene(scene);
        stage.show();
    }

    public static void goToCustomerList(ActionEvent actionEvent){
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(SceneMovements.class.getResource("/view/CustomerList.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1200, 600);
        stage.setTitle("Customer List");
        stage.setScene(scene);
        stage.show();
    }

    public static void goToApptList(ActionEvent actionEvent){
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(SceneMovements.class.getResource("/view/AppointmentList.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1200, 600);
        stage.setTitle("Appointment List");
        stage.setScene(scene);
        stage.show();
    }

    public static void goToMainMenu(ActionEvent actionEvent){
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(SceneMovements.class.getResource("/view/MainMenu.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }

    public static void goToUpdateCustomer(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(SceneMovements.class.getResource("/view/UpdateCustomer.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
        assert root != null;
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Update Customer");
        stage.setScene(scene);
        stage.show();
    }

    public static void goToNewCustomer(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(SceneMovements.class.getResource("/view/NewCustomer.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("New Customer");
        stage.setScene(scene);
        stage.show();
    }

    public static void goToUpdateAppt(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(SceneMovements.class.getResource("/view/UpdateAppt.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 550);
        stage.setTitle("Update Appointment");
        stage.setScene(scene);
        stage.show();
    }

    public static void goToNewAppt(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(SceneMovements.class.getResource("/view/NewAppt.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 550);
        stage.setTitle("New Appointment");
        stage.setScene(scene);
        stage.show();
    }
}
