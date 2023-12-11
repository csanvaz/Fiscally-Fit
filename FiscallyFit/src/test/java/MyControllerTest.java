import javafx.scene.text.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MyControllerTest {

    private MyController myController;
    private BudgetRecommendationController budgetController;

    @BeforeEach
    public void setUp() {
        myController = new MyController();
        budgetController = new BudgetRecommendationController();
    }

    // Testing that our container hold proper data which is used to populate our TextFields
    // Testing that the only variables are Text
    @Test
    public void testHoldTransactionsNotEmpty() {

        // Fill the array with random data
        Text data = new Text(RandomUserGenerator.generateTransaction());
        myController.holdTransactions.add(data);

        // Check if holdTransactions is not null
        assertNotNull(myController.holdTransactions, "Hold transactions should not be null");

        // Check if holdTransactions is not empty
        assertFalse(myController.holdTransactions.isEmpty(), "Hold transactions should not be empty");

        // Check if each item in holdTransactions is a Text instance
        for (Text transactionText : myController.holdTransactions) {
            assertNotNull(transactionText, "Transaction text should not be null");
        }

        System.out.println("Values in holdTransactions:");
        for (int i = 0; i < myController.holdTransactions.size(); i++){
            System.out.println(myController.holdTransactions.get(i));
        }
    }

    // Add more test methods for other functionality as needed
}
