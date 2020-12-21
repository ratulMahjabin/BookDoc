package receptionistInterface;

import backEnd.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class Appointment {
    @FXML
    private Button logoutBtn;

    @FXML
    private TextField patNameField;

    @FXML
    private TextField patAgeField;

    @FXML
    private TextField patGenderField;

    @FXML
    private TextField patAddressField;

    @FXML
    private TextField patPhoneField;

    @FXML
    private TextField docCodeField;

    @FXML
    private Button appointmentBtn;

    public void makeAppointment(ActionEvent event) {
        Window owner = appointmentBtn.getScene().getWindow();

        if (patNameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please name");
            return;
        }
        if (patAgeField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter name");
            return;
        }

        if (patGenderField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter gender");
            return;
        }
        if (patAddressField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please address");
            return;
        }
        if (patPhoneField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please phone number");
            return;
        }
        if (docCodeField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Doctor code");
            return;
        }
        String name = patNameField.getText();
        String age = patAgeField.getText();
        String docCode = docCodeField.getText();
        String address = patAddressField.getText();
        String gender = patGenderField.getText();
        String phone = patPhoneField.getText();

        Database database = new Database();
        database.makeAppointment(name,age,gender,address,phone,docCode);

        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Appointment made successfully!");
        
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public void logoutButtonPress(ActionEvent event) throws IOException {
        Parent loginViewParent = FXMLLoader.load(getClass().getResource("..//authentication//login.fxml"));
        Scene loginViewScene = new Scene(loginViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginViewScene);
        window.setResizable(false);
        window.show();
    }
    public void backButtonPress(ActionEvent event) throws IOException {
        Parent loginViewParent = FXMLLoader.load(getClass().getResource("..//receptionistInterface//ReceptionistDashboard.fxml"));
        Scene loginViewScene = new Scene(loginViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginViewScene);
        window.setResizable(false);
        window.show();
    }
}
