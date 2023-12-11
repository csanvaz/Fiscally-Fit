import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TransactionsController implements Initializable {
    //Panes
    @FXML
    private BorderPane root4; // access to BorderPane in FXML file

    @FXML
    private Pane pieChart;

    @FXML
    private Button weekButtonP;

    @FXML
    private Button monthButtonP;

    @FXML
    private Button yearButtonP;

    @FXML
    Label otherLabel;

    @FXML
    Label utilitiesLabel;

    @FXML
    Label foodLabel;

    @FXML
    Label entertainmentLabel;
    
    @FXML
    private Label sumT;

    public ObservableList<PieChart.Data> listP =  FXCollections.observableArrayList();

    @FXML
    private PieChart transactions = new PieChart();

    public void initialize(URL location, ResourceBundle resources) {
        loadData();

    }

    // load week Data
    private void loadData() {
        weekButtonP.setDisable(true);
        monthButtonP.setDisable(false);
        yearButtonP.setDisable(false);
        listP.add(new PieChart.Data("Other", 10));
        listP.add(new PieChart.Data("Utilities", 60));
        listP.add(new PieChart.Data("Food", 40));
        listP.add(new PieChart.Data("Entertainment", 35));
        transactions.setData(listP);
        transactions.setLegendVisible(false);
        transactions.setPrefSize(340, 340);
        transactions.setLayoutY(-20);
        transactions.setLayoutX(-10);
        pieChart.getChildren().add(transactions);
        otherLabel.setText("Other: $12 ");
        utilitiesLabel.setText("Utilities: $40 ");
        foodLabel.setText("Food: $65 ");
        entertainmentLabel.setText("Entertainment: $30");

    }

    public void HomeButton(ActionEvent actionEvent) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("/FXML/HomeScreen.fxml"));
        root2.setStyle("-fx-font-family: 'serif'");
        Scene s1 = new Scene(root2, 335, 600);
        Stage primaryStage = (Stage) root4.getScene().getWindow();;
        primaryStage.setScene(s1);
        primaryStage.show();
    }

    @FXML
    public void BudgetButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/BudgettingRecommendationsScreen.fxml"));
        root.setStyle("-fx-font-family: 'serif'");
        Scene s1 = new Scene(root, 335, 600);
        Stage primaryStage = (Stage) root4.getScene().getWindow();;
        primaryStage.setScene(s1);
        primaryStage.show();
    }

    void clearPieChart(){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        transactions.setData(pieChartData);

    }

    @FXML
    public void weekPieChart(ActionEvent actionEvent) throws IOException {
        weekButtonP.setDisable(true);
        monthButtonP.setDisable(false);
        yearButtonP.setDisable(false);
        transactions.setData(listP);
        otherLabel.setText("Other: $12 ");
        utilitiesLabel.setText("Utilities: $40 ");
        foodLabel.setText("Food: $65 ");
        entertainmentLabel.setText("Entertainment: $30");
        sumT.setText("Week Summary");

    }

    @FXML
    public void monthPieChart(ActionEvent actionEvent) throws IOException {
        weekButtonP.setDisable(false);
        monthButtonP.setDisable(true);
        yearButtonP.setDisable(false);
        clearPieChart();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        pieChartData.add(new PieChart.Data("Other", 15));
        pieChartData.add(new PieChart.Data("Utilities", 40));
        pieChartData.add(new PieChart.Data("Food", 65));
        pieChartData.add(new PieChart.Data("Entertainment", 30));
        transactions.setData(pieChartData);
        otherLabel.setText("Other: $100 ");
        utilitiesLabel.setText("Utilities: $400");
        foodLabel.setText("Food: $650 ");
        entertainmentLabel.setText("Entertainment: $300");
        sumT.setText("Month Summary");
    }

    @FXML
    public void YearPieChart(ActionEvent actionEvent) throws IOException {
        weekButtonP.setDisable(false);
        monthButtonP.setDisable(false);
        yearButtonP.setDisable(true);
        clearPieChart();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        pieChartData.add(new PieChart.Data("Other", 12));
        pieChartData.add(new PieChart.Data("Utilities", 50));
        pieChartData.add(new PieChart.Data("Food", 65));
        pieChartData.add(new PieChart.Data("Entertainment", 35));
        transactions.setData(pieChartData);
        otherLabel.setText("Other: $1200 ");
        utilitiesLabel.setText("Utilities: $5000 ");
        foodLabel.setText("Food: $6500 ");
        entertainmentLabel.setText("Entertainment: $3500 ");
        sumT.setText("Year Summary");

    }
    
}
