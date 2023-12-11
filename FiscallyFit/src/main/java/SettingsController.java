import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {
    @FXML
    private BorderPane root3; // access to BorderPane in FXML file

    // SettingsScene buttons
    @FXML
    private Button returnHome;
    @FXML
    private Button addAccount;
    @FXML
    private Button removeAccount;
    @FXML
    private Button logout;
    @FXML
    private Button quit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    // Settings Scene Events __________________________________________________________________
    public void logoutButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Welcome.fxml"));
        Scene s1 = new Scene(root, 335, 600);
        Stage primaryStage = (Stage) root3.getScene().getWindow();;
        primaryStage.setScene(s1);
        primaryStage.show();

    }
    public void returnHomeButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/HomeScreen.fxml"));
        Scene s1 = new Scene(root, 335, 600);
        Stage primaryStage = (Stage) root3.getScene().getWindow();;
        primaryStage.setScene(s1);
        primaryStage.show();

    }

    public void quitButton(ActionEvent event) throws IOException {
        System.exit(1);
    }

}
