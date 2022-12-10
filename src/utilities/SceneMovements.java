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
    public static void goToReportPage(ActionEvent actionEvent) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(SceneMovements.class.getResource("/view/ReportsList.fxml")));
            Stage stage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 500, 400);
            stage.setTitle("Report List");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void goToCustomerList(ActionEvent actionEvent) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(SceneMovements.class.getResource("/view/CustomerList.fxml")));
            Stage stage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 1000, 600);
            stage.setTitle("Customer List");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void goToApptList(ActionEvent actionEvent) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(SceneMovements.class.getResource("/view/AppointmentList.fxml")));
            Stage stage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 1200, 600);
            stage.setTitle("Appointment List");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void goToMainMenu(ActionEvent actionEvent) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(SceneMovements.class.getResource("/view/MainMenu.fxml")));
            Stage stage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void goToUpdateCustomer(ActionEvent actionEvent) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(SceneMovements.class.getResource("/view/UpdateCustomer.fxml")));
            Stage stage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
            assert root != null;
            Scene scene = new Scene(root, 800, 600);
            stage.setTitle("Update Customer");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void goToNewCustomer(ActionEvent actionEvent) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(SceneMovements.class.getResource("/view/NewCustomer.fxml")));
            Stage stage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 800, 600);
            stage.setTitle("New Customer");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void goToUpdateAppt(ActionEvent actionEvent) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(SceneMovements.class.getResource("/view/UpdateAppt.fxml")));
            Stage stage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 550);
            stage.setTitle("Update Appointment");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void goToNewAppt(ActionEvent actionEvent) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(SceneMovements.class.getResource("/view/NewAppt.fxml")));
            Stage stage = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 550);
            stage.setTitle("New Appointment");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
