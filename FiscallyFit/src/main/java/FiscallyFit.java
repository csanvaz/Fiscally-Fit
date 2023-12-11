
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;



public class FiscallyFit extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Fiscally Fit");

		try {
			// Read file fxml and draw interface.
			Parent root = FXMLLoader.load(getClass()
					.getResource("/FXML/Welcome.fxml"));
			root.setStyle("-fx-font-family: 'serif'");

			Scene s1 = new Scene(root, 335, 600);
			primaryStage.setScene(s1);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}
}
