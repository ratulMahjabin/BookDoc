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

public class ViewPrescription {
    @FXML
    private Button btnBack;


    @FXML
    private TextField dateField;

    @FXML
    private TextField adviceField;

    @FXML
    private TextField medicineField;

    @FXML
    private Button btnViewPrescription;

    @FXML
    private TextField patNameField;

    @FXML
    private TextField patAgeField;

    @FXML
    private TextField patGenderField;

    @FXML
    private TextField pIdField;

    public void viewPrescription(ActionEvent event){
        Window owner = btnViewPrescription.getScene().getWindow();
        if (pIdField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Advice for the patient");
            return;
        }
        String PID = pIdField.getText();
        Database database = new Database();
        database.getPrescription(PID,patNameField,dateField,patAgeField,patGenderField,adviceField,medicineField);

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
        Parent loginViewParent = FXMLLoader.load(getClass().getResource("..//doctorInterface//DoctorDashboard.fxml"));
        Scene loginViewScene = new Scene(loginViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginViewScene);
        window.setResizable(false);
        window.show();
    }


}
