import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;


class RandomUserGenerator {
	static // random name array
	String[] names = {"Alice", "Bob", "Charlie", "David", "Evan", "Frank","Lucifer", "Grace",
			"Hannah", "Brett", "Mireya","Ethan","Cam", "Cynthia","Julia","Grace","Evan",
			"Jasmine","Charles","Destiny","Phil", "Janki"};
	
	// random store name
	static String[] storeNames = {
		    "Walmart         ", "Dark Web        ", "Target          ", "Jewel           ",
		    "Wendys          ", "Circuit City    ", "Best Buy        ", "Mcdonalds       ",
		    "Burger King     ", "Pizza Hut       ", "Amazon          ", "Apple Store     ",
		    "Home Depot      ", "RadioShack      ", "Binnys          ", "Sex Shop        ",
		    "Starbucks       ", "KFC             ", "Walgreens       ", "Costco          ",
		    "Dunkin          ", "Subway          ", "GameStop        ", "Petco           ",
		    "Trader Joe's    ", "Chipotle        ", "Lowe's          ", "CVS             ",
		    "Office Depot    ", "Taco Bell       "
		};
	
    private static String name;
    private static String transactions;
    
    static String Budget = String.valueOf(getBudget());
    
    private static int budget = Integer.parseInt(Budget);
    private static int setRand = 0;
    private static int setName = 0;
    private static int setBudget = 0;

    public RandomUserGenerator(String name, int transactions, int budget) {
        this.name = name;
        this.transactions = generateTransaction();
        this.budget = budget;
    }

    public static String getName() {
        return name;
    }

    public static String getTransactions() {
        return transactions;
    }

    public static int getBudget() {
        return budget;
    }
    
    
    public static String generateName() {
    	
    	if(setName != 1) {
    		
    		Random random = new Random();
    		
    		String randomName = names[random.nextInt(names.length)];
    		
    		// Generate a random number of transactions (between 0 and 100)
    		int randomTransactions = random.nextInt(101);
    		
    		// Generate a random budget (between 1000 and 10000)
    		int randomBudget = (int) (Math.random() * 1999) + 1;
    		
    		// Create a random user
    		if(setRand != 1) {
    			
    			RandomUserGenerator randomUser = new RandomUserGenerator(randomName, randomTransactions, randomBudget);
    			name = randomUser.getName();
    			setRand = 1;
    		}
    		
    		setName = 1;
    		
    		return "Hello, Welcome back " + name + "!";
    	}
    	else {
    		return "Hello, Welcome back " + name + "!";
    	}
    }
    
    
    private static long getRandomMillisBetweenDates(Date startDate, Date endDate) {
        long startMillis = startDate.getTime();
        long endMillis = endDate.getTime();
        long randomMillis = startMillis + (long) (Math.random() * (endMillis - startMillis + 1));
        return randomMillis;
    }
    
    
    public static String generateTransaction() {

        Random random = new Random();
        int index = random.nextInt(storeNames.length);
        String storeName = storeNames[index];
        
        // Create a String array to store the formatted dates
        String[] randomDatesArray = new String[25];

        // Define the date formatter for the desired format "xx/xx/xxxx"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        
         // Get the current date
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        // Set the upper and lower bounds for the random date (last 3 months)
        calendar.add(Calendar.MONTH, -1);
        Date lowerBound = calendar.getTime();
        
        // Generate a random date within the specified range
        long randomMillis = getRandomMillisBetweenDates(lowerBound, currentDate);

        // Convert the random millis to a date object
        Date randomDate = new Date(randomMillis);

        // Format the date to "xx/xx/xxxx" using SimpleDateFormat
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        
        double min = 1.0;
        double max = 150.0;
        double valueSpent = min + (max - min) * random.nextDouble();
        
        return String.format("     %-30s %-30s $%-10.2f ",  storeName, dateFormat.format(randomDate),  valueSpent);
        
    }
    
    
    public static String generateBudget() {
    	
    	DecimalFormat df = new DecimalFormat("#,###");
    	
    	if(setBudget != 1) {
    		
    		
    		Random random = new Random();
    		
    		String randomName = names[random.nextInt(names.length)];
    		
    		// Generate a random number of transactions (between 0 and 100)
    		int randomTransactions = random.nextInt(101);
    		
    		int randomBudget = (int) (Math.random() * 2999) + 1;
    		setBudget = 1;
    		
    		// Create a random user
			if (setRand != 1) {

				RandomUserGenerator randomUser = new RandomUserGenerator(randomName, randomTransactions, randomBudget);
				
				Budget = df.format(randomUser.getBudget());
				
				setRand = 1;
			}
    		
    		return "$" + budget;
    	}
    	else {
    		return "$" +  budget;
    	}
    }
    
    public static String updateBudget1(int newSalary) {
    	
    	if(newSalary < 5000) {
    		int newBudg = 5000 - newSalary;
    		return "$" + newBudg;
    	}
    	else {
    		int newBudg = newSalary - 5000;
    		return "$" + newBudg;
    		
    	}
    	
    }
    
}