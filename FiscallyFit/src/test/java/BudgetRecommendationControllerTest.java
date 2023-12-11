import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BudgetRecommendationControllerTest {

    @Test
    void testCalculateConservativeBudget() {
        // Create an instance of BudgetRecommendationController
        BudgetRecommendationController controller = new BudgetRecommendationController();

        // Set a sample salary
        String sampleSalary = "50000";  // Replace with your desired value

        // Call the calculateConservativeBudget method
        controller.calculateConservativeBudget(sampleSalary);

        // Retrieve the calculated values
        int housingInt = controller.getHousingInt();
        int groceriesInt = controller.getGroceriesInt();
        int personalCareInt = controller.getPersonalCareInt();
        int transportationInt = controller.getTransportationInt();
        int diningInt = controller.getDiningInt();
        int entertainmentInt = controller.getEntertainmentInt();

        // Add assertions based on the expected values
        assertEquals(2700, housingInt);
        assertEquals(5000, groceriesInt);
        assertEquals(2500, personalCareInt);
        assertEquals(4000, transportationInt);
        assertEquals(5000, diningInt);
        assertEquals(3000, entertainmentInt);
    }

    @Test
    void testCalculateModerateBudget() {
        // Create an instance of BudgetRecommendationController
        BudgetRecommendationController controller = new BudgetRecommendationController();

        // Set a sample salary
        String sampleSalary = "50000";  // Replace with your desired value

        // Call the calculateModerateBudget method
        controller.calculateModerateBudget(sampleSalary);

        // Retrieve the calculated values
        int housingInt = controller.getHousingInt();
        int groceriesInt = controller.getGroceriesInt();
        int personalCareInt = controller.getPersonalCareInt();
        int transportationInt = controller.getTransportationInt();
        int diningInt = controller.getDiningInt();
        int entertainmentInt = controller.getEntertainmentInt();

        // Add assertions based on the expected values
        assertEquals(3200, housingInt);
        assertEquals(7500, groceriesInt);
        assertEquals(3000, personalCareInt);
        assertEquals(5000, transportationInt);
        assertEquals(7500, diningInt);
        assertEquals(5000, entertainmentInt);
    }

    @Test
    void testCalculateAggressiveBudget() {
        // Create an instance of BudgetRecommendationController
        BudgetRecommendationController controller = new BudgetRecommendationController();

        // Set a sample salary
        String sampleSalary = "50000";  // Replace with your desired value

        // Call the calculateAggressiveBudget method
        controller.calculateAggressiveBudget(sampleSalary);

        // Retrieve the calculated values
        int housingInt = controller.getHousingInt();
        int groceriesInt = controller.getGroceriesInt();
        int personalCareInt = controller.getPersonalCareInt();
        int transportationInt = controller.getTransportationInt();
        int diningInt = controller.getDiningInt();
        int entertainmentInt = controller.getEntertainmentInt();

        // Add assertions based on the expected values
        assertEquals(2200, housingInt);
        assertEquals(3500, groceriesInt);
        assertEquals(2000, personalCareInt);
        assertEquals(2500, transportationInt);
        assertEquals(2500, diningInt);
        assertEquals(1000, entertainmentInt);
    }

    @Test
    void testRentChangeAggressiveBudget() {
        // Create an instance of BudgetRecommendationController
        BudgetRecommendationController controller = new BudgetRecommendationController();

        // Set a sample salary
        String sampleSalary = "50000";  // Replace with your desired value

        // Change Rent
        controller.setcurrentRent(300.0);

        // Call the calculateAggressiveBudget method
        controller.calculateAggressiveBudget(sampleSalary);

        // Retrieve the calculated values
        int housingInt = controller.getHousingInt();
        int groceriesInt = controller.getGroceriesInt();
        int personalCareInt = controller.getPersonalCareInt();
        int transportationInt = controller.getTransportationInt();
        int diningInt = controller.getDiningInt();
        int entertainmentInt = controller.getEntertainmentInt();

        // Add assertions based on the expected values
        assertEquals(1800, housingInt);
        assertEquals(3500, groceriesInt);
        assertEquals(2000, personalCareInt);
        assertEquals(2500, transportationInt);
        assertEquals(2500, diningInt);
        assertEquals(1000, entertainmentInt);
    }

    @Test
    void testRentChangeModerateBudget() {
        // Create an instance of BudgetRecommendationController
        BudgetRecommendationController controller = new BudgetRecommendationController();

        // Set a sample salary
        String sampleSalary = "50000";  // Replace with your desired value

        // Change Rent
        controller.setcurrentRent(300.0);

        // Call the calculateAggressiveBudget method
        controller.calculateAggressiveBudget(sampleSalary);

        // Retrieve the calculated values
        int housingInt = controller.getHousingInt();
        int groceriesInt = controller.getGroceriesInt();
        int personalCareInt = controller.getPersonalCareInt();
        int transportationInt = controller.getTransportationInt();
        int diningInt = controller.getDiningInt();
        int entertainmentInt = controller.getEntertainmentInt();

        // Add assertions based on the expected values
        assertEquals(2800, housingInt);
        assertEquals(7500, groceriesInt);
        assertEquals(3000, personalCareInt);
        assertEquals(5000, transportationInt);
        assertEquals(7500, diningInt);
        assertEquals(5000, entertainmentInt);
    }

    @Test
    void testRentChangeConservativeBudget() {
        // Create an instance of BudgetRecommendationController
        BudgetRecommendationController controller = new BudgetRecommendationController();

        // Set a sample salary
        String sampleSalary = "50000";  // Replace with your desired value

        // Change Rent
        controller.setcurrentRent(300.0);

        // Call the calculateConservativeBudget method
        controller.calculateConservativeBudget(sampleSalary);

        // Retrieve the calculated values
        int housingInt = controller.getHousingInt();
        int groceriesInt = controller.getGroceriesInt();
        int personalCareInt = controller.getPersonalCareInt();
        int transportationInt = controller.getTransportationInt();
        int diningInt = controller.getDiningInt();
        int entertainmentInt = controller.getEntertainmentInt();

        // Add assertions based on the expected values
        assertEquals(2300, housingInt);
        assertEquals(5000, groceriesInt);
        assertEquals(2500, personalCareInt);
        assertEquals(4000, transportationInt);
        assertEquals(5000, diningInt);
        assertEquals(3000, entertainmentInt);
    }
}
