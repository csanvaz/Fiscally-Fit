import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.text.DecimalFormat;

public class RandomUserGeneratorTest {

    @Test
    public void testGenerateName() {
        String greeting = RandomUserGenerator.generateName();
        assertNotNull(greeting);
        assertTrue(greeting.startsWith("Hello, Welcome back"));
    }

    @Test
    public void testGenerateTransaction() {
        String transaction = RandomUserGenerator.generateTransaction();
        assertNotNull(transaction);
        assertTrue(transaction.contains("$"));
    }

    @Test
    public void testGenerateBudget() {
        String budgetString = RandomUserGenerator.generateBudget();
        assertNotNull(budgetString);
        assertTrue(budgetString.startsWith("$"));

        // Test if the budget is in a valid range (between 1 and 2999)
        String budgetValueString = budgetString.substring(1); // Remove the "$" sign
        int budgetValue = Integer.parseInt(budgetValueString.replace(",", ""));
        assertTrue(budgetValue >= 1 && budgetValue <= 2999);
    }

    @Test
    public void testUpdateBudget1() {
        // Test when the new salary is less than 5000
        String updatedBudget1 = RandomUserGenerator.updateBudget1(4000);
        assertEquals("$1000", updatedBudget1);

        // Test when the new salary is greater than 5000
        updatedBudget1 = RandomUserGenerator.updateBudget1(6000);
        assertEquals("$1000", updatedBudget1);

        // Test when the new salary is equal to 5000
        updatedBudget1 = RandomUserGenerator.updateBudget1(5000);
        assertEquals("$0", updatedBudget1);
    }


    // Helper method to assert that a string represents a valid budget
    private void assertValidBudgetString(String budgetString) {
        assertTrue(budgetString.startsWith("$"));

        // Test if the budget is in a valid range (between 1 and 2999)
        String budgetValueString = budgetString.substring(1); // Remove the "$" sign
        int budgetValue = Integer.parseInt(budgetValueString.replace(",", ""));
        assertTrue(budgetValue >= 1 && budgetValue <= 2999);
    }
}