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

public class BillMaker {
    @FXML
    private Button logoutBtn;

    @FXML
    private Button btnBack;

    @FXML
    private TextField AppIDField;

    @FXML
    private TextField doctorNameField;

    @FXML
    private TextField billField;

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

    @FXML
    private TextField dateField;


    public void pressBillGoBtn(ActionEvent event){
        Window owner = goButton.getScene().getWindow();
        if (AppIDField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please Enter Patient ID");
            return;
        }
        String PID = AppIDField.getText();
        Database database = new Database();
        database.getPrescriptionData(PID,patNameField,patAgeField,patGenderField,doctorNameField,dateField);

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

    public void prepareBill(ActionEvent event){
        Window owner = btnPrescription.getScene().getWindow();
        String PID = AppIDField.getText();
        String bill = billField.getText();
        Database database = new Database();
        database.makeBill(PID,bill);
        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Bill made successfully!");

    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

}
