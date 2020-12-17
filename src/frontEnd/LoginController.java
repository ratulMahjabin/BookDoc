package frontEnd;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

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
    public void backButtonPress(ActionEvent event) throws IOException {
        Parent loginViewParent = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
        Scene loginViewScene = new Scene(loginViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginViewScene);
        window.show();
    }
}
