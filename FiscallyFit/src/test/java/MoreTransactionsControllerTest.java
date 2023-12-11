import javafx.application.Platform;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JPanel;

class MoreTransactionsControllerTest {

    @BeforeAll
    static void initJFX() {
        // Initialize JavaFX for headless testing
        Platform.startup(() -> new JPanel());
    }
 
    @Test
    void testLoadData() {
        TransactionsController controller = new TransactionsController();
        controller.loadData();

        // Check that the pie chart has data
        assertFalse(controller.listP.isEmpty());

        // Add more assertions based on your specific requirements
    }

    @Test
    void testClearPieChart() {
        TransactionsController controller = new TransactionsController();
        controller.clearPieChart();

        // Check that the pie chart data is cleared
        assertTrue(controller.transactions.getData().isEmpty());

        // Add more assertions based on your specific requirements
    }

    @Test
    void testWeekPieChart() {
        TransactionsController controller = new TransactionsController();

        // Call the method to set up the week data
        assertDoesNotThrow(() -> controller.weekPieChart(null));

        // Add assertions based on the expected state after calling the method
    }


}