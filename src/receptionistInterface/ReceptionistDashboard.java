package receptionistInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ReceptionistDashboard {
    @FXML
    private Button btnLogout;

    @FXML
    private Button btnAppointment;

    @FXML
    private Button btnBill;

    public void logoutButtonPress(ActionEvent event) throws IOException {
        Parent loginViewParent = FXMLLoader.load(getClass().getResource("..//authentication//login.fxml"));
        Scene loginViewScene = new Scene(loginViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginViewScene);
        window.setResizable(false);
        window.show();
    }
    public void appointmentButtonPress(ActionEvent event) throws IOException {
        Parent loginViewParent = FXMLLoader.load(getClass().getResource("..//receptionistInterface//Appointment.fxml"));
        Scene loginViewScene = new Scene(loginViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginViewScene);
        window.setResizable(false);
        window.show();
    }
    public void billButtonPress(ActionEvent event) throws IOException {
        Parent loginViewParent = FXMLLoader.load(getClass().getResource("..//receptionistInterface//BillDashboard.fxml"));
        Scene loginViewScene = new Scene(loginViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginViewScene);
        window.setResizable(false);
        window.show();
    }

}
