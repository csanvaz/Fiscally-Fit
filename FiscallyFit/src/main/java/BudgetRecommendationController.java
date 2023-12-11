import com.sun.tools.javac.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuItem;

import java.awt.*;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.Objects;

public class BudgetRecommendationController {

    @FXML
    private BorderPane root5; // access to BorderPane in FXML file
    //Buttons -----------------------------------
    @FXML
    private Button conservativeButton;

    @FXML
    private Button moderateButton;

    @FXML
    private Button aggressiveButton;

    // Card Menu Buttons -----------------
    @FXML
    private SplitMenuButton cardMenu;
    @FXML
    private MenuItem card1;
    @FXML
    private MenuItem card2;

    // Labels -------------------------
    @FXML
    private Label BudgetingName;
    @FXML
    public Label currentSalary;
    // Define budget categories
    @FXML
    private TextField housingRec;
    @FXML
    private TextField groceriesRec;
    @FXML
    private TextField personalCareRec;
    @FXML
    private TextField transportationRec;
    @FXML
    private TextField diningRec;
    @FXML
    private TextField entertainmentRec;
    // TextField -------------------------
    @FXML
    private TextField modifySalary;
    @FXML
    private TextField modifyHousingPay;
    // Variables for backend ----------------
    private double currentRent = 700.0;
    //saved salary val for budget modification
    static String newSalary = " ";

    static Boolean changedSalary = false;


    public void initialize() throws IOException {

        // Add a FocusListener to the text field when the controller is initialized.
        getModifySalary().focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Check if the text field lost focus
                newSalary = getModifySalary().getText();
                if (!newSalary.isEmpty()) {
                    currentSalary.setText(newSalary);
                    changedSalary = true;
                }
            }
        });

        modifyHousingPay.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Check if the text field lost focus
                String newRent = modifyHousingPay.getText();
                if (!newRent.isEmpty()) {
                    currentRent = Double.valueOf(newRent);
                }
            }
        });

    }

    // Transitioning to home screen
    public void goHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/HomeScreen.fxml"));
        root.setStyle("-fx-font-family: 'serif'");
        Scene s1 = new Scene(root, 335, 600);
        Stage primaryStage = (Stage) getRoot5().getScene().getWindow(); // Assuming root1 is the root of your current scene
        primaryStage.setScene(s1);
        primaryStage.show();
    }

    // Go back to Transaction Screen
    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/TransactionScreen.fxml"));
        Scene s1 = new Scene(root, 335, 600);
        Stage primaryStage = (Stage) getRoot5().getScene().getWindow(); // Assuming root1 is the root of your current scene
        primaryStage.setScene(s1);
        primaryStage.show();
    }

    // Grab current salary
    public static Integer getNewSal() {
        //return Integer.parseInt(newSalary);
        return Integer.valueOf(newSalary);
    }

    public static Boolean salChanged(){
        return changedSalary;
    }

    // Methods that create budgeting recommendations
    // Calculating Moderate Budget Based On Salary
    private int housingInt;

    private int groceriesInt;

    private int personalCareInt;

    private int transportationInt;

    private int diningInt;

    private int entertainmentInt;

    // Getters for Global Variables
    // Getter for housingInt
    public int getHousingInt() {
        return housingInt;
    }

    // Getter for groceriesInt
    public int getGroceriesInt() {
        return groceriesInt;
    }

    // Getter for personalCareInt
    public int getPersonalCareInt() {
        return personalCareInt;
    }

    // Getter for transportationInt
    public int getTransportationInt() {
        return transportationInt;
    }

    // Getter for diningInt
    public int getDiningInt() {
        return diningInt;
    }

    // Getter for entertainmentInt
    public int getEntertainmentInt() {
        return entertainmentInt;
    }

    public double getCurrentRent(){
        return currentRent;
    }

    // Setter for Rent
    public void setcurrentRent(double var){
       this.currentRent = var;
    }

    @FXML void conservativeRecommendation(ActionEvent event) {
        String salary = currentSalary.getText();
        // Implement the conservative budget plan
        calculateConservativeBudget(salary);
        // Update Categories
        setBudgetcategories();
        // Update the recommendation label
        updateRecommendationLabel("Conservative Budget Recommendation");
    }

    @FXML
    private void moderateRecommendation(ActionEvent event) {
        String salary = currentSalary.getText();
        // Implement the moderate budget plan
        calculateModerateBudget(salary);
        // Update Categories
        setBudgetcategories();
        // Update the recommendation label
        updateRecommendationLabel("Moderate Budget Recommendation");

    }

    @FXML
    private void aggressiveRecommendation(ActionEvent event) {
        String salary = currentSalary.getText();
        // Implement the aggressive budget plan
        calculateAggressiveBudget(salary);
        // Update Categories
        setBudgetcategories();
        // Update the recommendation label
        updateRecommendationLabel("Aggressive Budget Recommendation");
    }

    // Helper method to calculate conservative budget
    public void calculateConservativeBudget(String currSalary) {
        // Calculating Moderate Budget Based On Salary
        double housing = (Double.parseDouble(currSalary) * .04) + currentRent;
        housingInt = (int) housing; // Convert to integer

        double groceries = Double.parseDouble(currSalary) * .10;
        groceriesInt = (int) groceries; // Convert to integer

        double personalCare = Double.parseDouble(currSalary) * .05;
        personalCareInt = (int) personalCare; // Convert to integer

        double transportation = Double.parseDouble(currSalary) * .08;
        transportationInt = (int) transportation; // Convert to integer

        double dining = Double.parseDouble(currSalary) * .10;
        diningInt = (int) dining; // Convert to integer

        double entertainment = Double.parseDouble(currSalary) * .06;
        entertainmentInt = (int) entertainment; // Convert to integer

    }

    // Helper method to calculate moderate budget
    public void calculateModerateBudget(String currSalary) {
        // Calculating Moderate Budget Based On Salary
        double housing = (Double.parseDouble(currSalary) * .05) + currentRent;
        housingInt = (int) housing; // Convert to integer

        double groceries = Double.parseDouble(currSalary) * .15;
        groceriesInt = (int) groceries; // Convert to integer

        double personalCare = Double.parseDouble(currSalary) * .06;
        personalCareInt = (int) personalCare; // Convert to integer

        double transportation = Double.parseDouble(currSalary) * .10;
        transportationInt = (int) transportation; // Convert to integer

        double dining = Double.parseDouble(currSalary) * .15;
        diningInt = (int) dining; // Convert to integer

        double entertainment = Double.parseDouble(currSalary) * .10;
        entertainmentInt = (int) entertainment; // Convert to integer

    }

    // Helper method to calculate aggressive budget
    public void calculateAggressiveBudget(String currSalary) {
        // Calculating Moderate Budget Based On Salary

        double housing = (Double.parseDouble(currSalary) * .03) + currentRent;
        housingInt = (int) housing; // Convert to integer

        double groceries = Double.parseDouble(currSalary) * .07;
        groceriesInt = (int) groceries; // Convert to integer

        double personalCare = Double.parseDouble(currSalary) * .04;
        personalCareInt = (int) personalCare; // Convert to integer

        double transportation = Double.parseDouble(currSalary) * .05;
        transportationInt = (int) transportation; // Convert to integer

        double dining = Double.parseDouble(currSalary) * .05;
        diningInt = (int) dining; // Convert to integer

        double entertainment = Double.parseDouble(currSalary) * .02;
        entertainmentInt = (int) entertainment; // Convert to integer

    }

    // Setting selected categories with new budget recommendations
    private void setBudgetcategories(){

        getHousingRec().setText(String.valueOf(housingInt));
        getGroceriesRec().setText(String.valueOf(groceriesInt));
        getPersonalCareRec().setText(String.valueOf(personalCareInt));
        getTransportationRec().setText(String.valueOf(transportationInt));
        getDiningRec().setText(String.valueOf(diningInt));
        getEntertainmentRec().setText(String.valueOf(entertainmentInt));
    }


    // Helper method to update the recommendation label
    private void updateRecommendationLabel(String recommendation) {
        getBudgetingName().setText(recommendation);
    }



    // Methods to help user filter through transactions_______________________

    // Grab selected card
    public void cardTwoSelected(ActionEvent actionEvent) {
        String card1Text = card2.getText();
        cardMenu.setText(card1Text);

        //Change Budget View as well
        // Will have to implement code in another iteration
    }

    // Grab selected card
    public void cardOneSelected(ActionEvent actionEvent) {
        String card1Text = card1.getText();
        cardMenu.setText(card1Text);

        // Change Budget View as well
        // Will have to implement code in another iteration
    }

    // Getters and setters
    public TextField getHousingRec() {
        return housingRec;
    }


    public void setHousingRec(TextField housingRec) {
        this.housingRec = housingRec;
    }


    public TextField getModifySalary() {
        return modifySalary;
    }


    public void setModifySalary(TextField modifySalary) {
        this.modifySalary = modifySalary;
    }


    public Label getBudgetingName() {
        return BudgetingName;
    }


    public void setBudgetingName(Label budgetingName) {
        BudgetingName = budgetingName;
    }


    public TextField getGroceriesRec() {
        return groceriesRec;
    }


    public void setGroceriesRec(TextField groceriesRec) {
        this.groceriesRec = groceriesRec;
    }


    public TextField getPersonalCareRec() {
        return personalCareRec;
    }


    public void setPersonalCareRec(TextField personalCareRec) {
        this.personalCareRec = personalCareRec;
    }


    public TextField getTransportationRec() {
        return transportationRec;
    }


    public void setTransportationRec(TextField transportationRec) {
        this.transportationRec = transportationRec;
    }


    public TextField getDiningRec() {
        return diningRec;
    }


    public void setDiningRec(TextField diningRec) {
        this.diningRec = diningRec;
    }


    public TextField getEntertainmentRec() {
        return entertainmentRec;
    }


    public void setEntertainmentRec(TextField entertainmentRec) {
        this.entertainmentRec = entertainmentRec;
    }


    public BorderPane getRoot5() {
        return root5;
    }


    public void setRoot5(BorderPane root5) {
        this.root5 = root5;
    }

}