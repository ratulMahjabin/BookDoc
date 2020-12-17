package frontEnd;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import org.junit.Assert;
import org.junit.Test;

public class Signup {
    @FXML
    ObservableList<String> roleChoiceList = FXCollections.observableArrayList("Admin","Doctor","Receptionist");
    @FXML
    private ChoiceBox roleChoiceBox;
    @FXML
    private void initialize() {
        roleChoiceBox.setValue("Admin");
        roleChoiceBox.setItems(roleChoiceList);
    }
}
