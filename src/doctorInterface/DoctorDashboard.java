package doctorInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DoctorDashboard {
    @FXML
    private Button btnLogout;

    @FXML
    private Button btnMakePrescription;

    @FXML
    private Button btnShowPrescription;

    public void prescriptionButtonPress(ActionEvent event) throws IOException {
        Parent loginViewParent = FXMLLoader.load(getClass().getResource("..//doctorInterface//MakePrescription.fxml"));
        Scene loginViewScene = new Scene(loginViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginViewScene);
        window.setResizable(false);
        window.show();
    }

    public void logoutButtonPress(ActionEvent event) throws IOException {
        Parent loginViewParent = FXMLLoader.load(getClass().getResource("..//authentication//login.fxml"));
        Scene loginViewScene = new Scene(loginViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginViewScene);
        window.setResizable(false);
        window.show();
    }



}
