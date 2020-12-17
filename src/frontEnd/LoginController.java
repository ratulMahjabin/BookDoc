package frontEnd;

import backEnd.DatabaseConnection;
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

import javax.swing.*;
import java.io.IOException;

public class LoginController {
        ObservableList<String>roleChoiceList = FXCollections.observableArrayList("Admin","Doctor","Receptionist");
    @FXML
    private ChoiceBox roleChoiceBox;
    @FXML
    private void initialize(){
        roleChoiceBox.setValue("Admin");
        roleChoiceBox.setItems(roleChoiceList);
    }
    @FXML
    private TextField userEmail;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField userPassword;

    public void backButtonPress(ActionEvent event) throws IOException {
        Parent loginViewParent = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
        Scene loginViewScene = new Scene(loginViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginViewScene);
        window.show();
    }
    public void loginButtonPress(ActionEvent event){
        String inputEmail = userEmail.getText();
        String inputPassword = userPassword.getText();

        if (inputEmail.equals("") && inputPassword.equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Fields are Blank!");
            alert.showAndWait();
        }
        else {

        }
    }

}
