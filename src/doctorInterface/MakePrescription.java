package doctorInterface;

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

public class MakePrescription {
    @FXML
    private Button logoutBtn;

    @FXML
    private Button btnBack;

    @FXML
    private TextField patIdField;

    @FXML
    private TextField dateField;

    @FXML
    private TextField adviceField;

    @FXML
    private TextField medicineField;

    @FXML
    private Button btnPrescription;

    @FXML
    private TextField patNameField;

    @FXML
    private TextField patAgeField;

    @FXML
    private TextField patGenderField;

    @FXML
    private Button goButton;

    public void pressGoBtn(ActionEvent event){
        Window owner = goButton.getScene().getWindow();
        if (patIdField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Patient ID");
            return;
        }
        String AID = patIdField.getText();
        Database database = new Database();
        database.getPatientData(AID,patNameField,patAgeField,patGenderField);

    }
    public void makePrescription(ActionEvent event){
        Window owner = btnPrescription.getScene().getWindow();
        if (dateField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Date");
            return;
        }
        if (adviceField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Advice for the patient");
            return;
        }
        if (medicineField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Medicine name");
            return;
        }
        String date = dateField.getText();
        String advice = adviceField.getText();
        String medicine = medicineField.getText();
        String AID = patIdField.getText();
        Database database = new Database();
        database.makePrescription(AID,date,advice,medicine);

        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Prescription made successfully!");

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
