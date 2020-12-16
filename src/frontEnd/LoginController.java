package frontEnd;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class LoginController {
    ObservableList<String>roleChoiceList = FXCollections.observableArrayList("Admin","Doctor","Receptionist");
    @FXML
    private ChoiceBox roleChoiceBox;
    @FXML
    private void initialize(){
        roleChoiceBox.setValue("Admin");
        roleChoiceBox.setItems(roleChoiceList);
    }
}
