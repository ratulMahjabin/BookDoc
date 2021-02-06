package authentication;

import backEnd.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;


import java.io.IOException;
import java.sql.SQLException;


public class LoginController {
    ObservableList<String> roleChoiceList = FXCollections.observableArrayList( "Doctor", "Receptionist");
    @FXML
    private ChoiceBox roleChoiceBox;
    @FXML
    private Label errorText;

    @FXML
    private void initialize() {
        roleChoiceBox.setValue("Doctor");
        roleChoiceBox.setItems(roleChoiceList);
    }

    @FXML
    public TextField userEmail;

    @FXML
    private Button btnLogin;

    @FXML
    public PasswordField userPassword;

    public void backButtonPress(ActionEvent event) throws IOException {
        Parent loginViewParent = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
        Scene loginViewScene = new Scene(loginViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginViewScene);
        window.setResizable(false);
        window.show();
    }

    public void login(ActionEvent event) throws SQLException, IOException {
        Window owner = btnLogin.getScene().getWindow();
        if(userEmail.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!","Please enter email");
            return;
        }
        if(userPassword.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!","Please enter password");
            return;
        }
        String emailId = userEmail.getText();
        String password=userPassword.getText();
        String role = (String) roleChoiceBox.getValue();

        Database database = new Database();
        if (role== "Admin"){
            boolean flag = database.validateAdminLogin(emailId,password);

            if(!flag){
                infoBox("Invalid Login Try Again",null,"Failed");
            }
            else {
                infoBox("Login Successful",null,"Success");
            }
        }
        if (role=="Doctor"){
            boolean flag = database.validateDoctorLogin(emailId,password);

            if(!flag){
                infoBox("Invalid Login Try Again",null,"Failed");
            }
            else {
                infoBox("Login Successful",null,"Success");
                Parent loginViewParent = FXMLLoader.load(getClass().getResource("..//doctorInterface//DoctorDashboard.fxml"));
                Scene loginViewScene = new Scene(loginViewParent);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(loginViewScene);
                window.setResizable(false);
                window.show();
            }
        }
        if(role=="Receptionist"){
            boolean flag = database.validateReceptionistLogin(emailId,password);

            if(!flag){
                infoBox("Invalid Login Try Again",null,"Failed");
            }
            else {
                infoBox("Login Successful",null,"Success");
                Parent loginViewParent = FXMLLoader.load(getClass().getResource("..//receptionistInterface//ReceptionistDashboard.fxml"));
                Scene loginViewScene = new Scene(loginViewParent);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(loginViewScene);
                window.setResizable(false);
                window.show();
            }
        }
//        boolean flag = database.validateAdminLogin(emailId,password);
//
//        if(!flag){
//            infoBox("Invalid Login Try Again",null,"Failed");
//        }
//        else {
//            infoBox("Login Successful",null,"Success");
//        }


    }
    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
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
