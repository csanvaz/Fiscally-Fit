import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {

    @FXML
    private BorderPane root1; // access to BorderPane in FXML file

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

     //Welcome Scene Events
    public void EnterButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/HomeScreen.fxml"));
        root.setStyle("-fx-font-family: 'serif'");
        Scene s1 = new Scene(root, 335, 600);
        Stage primaryStage = (Stage) root1.getScene().getWindow(); // Assuming root1 is the root of your current scene
        primaryStage.setScene(s1);
        primaryStage.show();

    }
}
