

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;



// My controller class is used to make the buttons and text fields interactive
public class MyController implements Initializable {

    //Panes
    @FXML
    private BorderPane root2; // access to BorderPane in FXML file


    ///HomeScreen Buttons---------------------
    @FXML
    Button settingsButton;
    @FXML
    private Button dayButton;
    @FXML
    private Button weekButton;
    @FXML
    private Button monthButton;
    @FXML
    private Button yearButton;
    @FXML
    private Button cardButton;
    @FXML
    Button breakDownButton;

    

    //static so each instance of controller can access to update
    private static String textEntered = "";
    @FXML
    private Text textTransactionOne;

    // Card Items ------------------------------
    @FXML
    private ImageView creditcard1;
    @FXML
    private ImageView creditcard2;

    // Transaction Vbox -----------
    @FXML VBox transactionList;
    ArrayList<Text> holdTransactions = new ArrayList<>(); // Container to hold Text Items

    Boolean changedSalary = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        fillName();
        try {
            fillBudget();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Create 40 Text items that will hold sample data of transactions
        for (int i = 1; i <= 40; i++) {
            Text transactionText = new Text(RandomUserGenerator.generateTransaction());
           holdTransactions.add(transactionText);
            transactionList.getChildren().add(transactionText);
        }
    }
    // Navigate to settings
    public void gotoSettings(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/SettingsScene.fxml"));
        Scene s1 = new Scene(root, 335, 600);
        Stage primaryStage = (Stage) root2.getScene().getWindow(); // Assuming root1 is the root of your current scene
        primaryStage.setScene(s1);
        primaryStage.show();
    }

    // Navigate to transactions seen
    public void seeTransactionBreakdown(ActionEvent actionEvent) throws IOException{
        breakDownButton.setDisable(false);
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/TransactionScreen.fxml"));
        Scene s1 = new Scene(root, 335, 600);
        Stage primaryStage = (Stage) root2.getScene().getWindow(); // Assuming root1 is the root of your current scene
        primaryStage.setScene(s1);
        primaryStage.show();
    }

    /// Dynamic Transactions for Home Scene ______________________________________________________
    @FXML
    private Text textName;
    @FXML
    private Text textBudgetLeft;

    private Text storedUserBudgetLeft;

    int filled = 0;



    // Buttons to filter transactions via day, week, month, and year
    Boolean dayButtonPressed = false;
    Boolean weekButtonPressed = false;
    Boolean monthBUttonPressed = false;
    Boolean yearButtonPressed = false;


    @FXML
    public void fillName() {
        textName.setText(RandomUserGenerator.generateName());
    }
//    @FXML
//    public void fillTransactions() {
//
//    	if(filled != 1) {
//    		textTransactionOne.setText(RandomUserGenerator.generateTransaction());
//            holdTransactions.add(textTransactionOne.getText());
//    		textTransactionTwo.setText(RandomUserGenerator.generateTransaction());
//            holdTransactions.add(textTransactionTwo.getText());
//    		textTransactionThree.setText(RandomUserGenerator.generateTransaction());
//            holdTransactions.add(textTransactionThree.getText());
//    		textTransactionFour.setText(RandomUserGenerator.generateTransaction());
//            holdTransactions.add(textTransactionFour.getText());
//    		textTransactionFive.setText(RandomUserGenerator.generateTransaction());
//            holdTransactions.add(textTransactionFive.getText());
//    		textTransactionSix.setText(RandomUserGenerator.generateTransaction());
//            holdTransactions.add(textTransactionSix.getText());
//    		textTransactionSeven.setText(RandomUserGenerator.generateTransaction());
//            holdTransactions.add(textTransactionSeven.getText());
//    		textTransactionEight.setText(RandomUserGenerator.generateTransaction());
//            holdTransactions.add(textTransactionEight.getText());
//    		textTransactionNine.setText(RandomUserGenerator.generateTransaction());
//            holdTransactions.add(textTransactionNine.getText());
//
//    		filled = 1;
//    	}
//    	else {
//    		return;
//    	}
//    }

    // Auto-populate text item with what is left of budget
    @FXML
    public void fillBudget() throws IOException {

        textBudgetLeft.setText(RandomUserGenerator.generateBudget());

    }

    // Update budget based on salary changes in budget screen
    @FXML
    public void updateBudget() throws IOException {
        Integer newSal = BudgetRecommendationController.getNewSal();
        Integer oldBudget = Integer.parseInt(storedUserBudgetLeft.getText());
        Integer newBudget = newSal - oldBudget;
        textBudgetLeft.setStyle(String.valueOf(newBudget));
    }

    // Clear transaction to enable filtering of transactions
    void clearTransactions(){
        transactionList.getChildren().clear();
    }

    // Methods to filter transactions
    public void dayBudgeting(ActionEvent actionEvent) throws IOException {
        // SetDisable for Buttons
        yearButton.setDisable(false);
        monthButton.setDisable(false);
        dayButton.setDisable(true);
        weekButton.setDisable(false);

        // Setting Button Styles
        dayButton.setStyle("-fx-background-color: lightblue");
        monthButton.setStyle("");
        weekButton.setStyle("");
        yearButton.setStyle("");

        // Setting Transactions
        clearTransactions();
        for(int i = 0; i < 10; i++){
            transactionList.getChildren().add(holdTransactions.get(i));
        }


    }

    public void weekBudgeting(ActionEvent actionEvent) throws IOException {
        // SetDisable for Buttons
        yearButton.setDisable(false);
        monthButton.setDisable(false);
        dayButton.setDisable(false);
        weekButton.setDisable(true);

        // Setting Button Styles
        weekButton.setStyle("-fx-background-color: lightblue");
        monthButton.setStyle("");
        dayButton.setStyle("");
        yearButton.setStyle("");

        // Setting Transactions
        clearTransactions();
        for(int i = 0; i < 18; i++){
            transactionList.getChildren().add(holdTransactions.get(i));
        }
    }

    public void monthBudgeting(ActionEvent actionEvent) throws IOException {
        // SetDisable for Buttons
        yearButton.setDisable(false);
        monthButton.setDisable(true);
        dayButton.setDisable(false);
        weekButton.setDisable(false);

        // Setting Button Styles
        monthButton.setStyle("-fx-background-color: lightblue");
        dayButton.setStyle("");
        weekButton.setStyle("");
        yearButton.setStyle("");

        // Setting Transactions
        clearTransactions();
        for(int i = 0; i < 25 ; i++){
            transactionList.getChildren().add(holdTransactions.get(i));
        }

    }

    public void yearBudgeting(ActionEvent actionEvent) throws IOException {
        // SetDisable for Buttons
        monthButton.setDisable(false);
        dayButton.setDisable(false);
        weekButton.setDisable(false);
        // Disable the yearButton
        yearButton.setDisable(true);

        // Button Styles
        yearButton.setStyle("-fx-background-color: lightblue");
        monthButton.setStyle("");
        dayButton.setStyle("");
        weekButton.setStyle("");

        // Set transactions
        clearTransactions();
        for(int i = 0; i < 40; i++){
            transactionList.getChildren().add(holdTransactions.get(i));
        }

    }

    // Methods to modify transaction view by credit cards
    public void creditCard1Clicked(MouseEvent mouseEvent) {
        creditcard1.setDisable(true);
        creditcard2.setDisable(false);
        clearTransactions();
        for (int i = 1; i <= 40; i++) {
            Text transactionText = new Text(RandomUserGenerator.generateTransaction());
            transactionList.getChildren().add(transactionText);
        }
    }

    public void creditCard2Clicked(MouseEvent mouseEvent) {
        creditcard1.setDisable(false);
        creditcard2.setDisable(true);
        clearTransactions();
        for (int i = 1; i <= 40; i++) {
            Text transactionText = new Text(RandomUserGenerator.generateTransaction());
            transactionList.getChildren().add(transactionText);
        }
    }

}
