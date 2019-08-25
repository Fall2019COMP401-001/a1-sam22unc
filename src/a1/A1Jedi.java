package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Read in store item data
		int storeItems = scan.nextInt();
				
		// Create arrays of item names and costs
		String[] itemName = new String[storeItems];
		double[] itemCost = new double[storeItems];
		
		for(int i = 0; i < storeItems; i++) {
			itemName[i] = scan.next();
			itemCost[i] = scan.nextDouble();
		}
		
		// Create arrays to track specific item purchases
		int[] itemCustomerCount = new int[storeItems];
		int[] itemCount = new int[storeItems];

		// Create arrays of customer names and their spending totals
		int numCustomers = scan.nextInt();
		String[] firstName = new String[numCustomers];
		String[] lastName = new String[numCustomers];
		
		// Get data for each customer
		for(int i = 0; i < numCustomers; i++) {
			firstName[i] = scan.next();
			lastName[i] = scan.next();
			
			int customerItems = scan.nextInt();
			
			// Track when the itemCustomerCount is changed --> true = customer purchased item
			boolean[] change = new boolean[storeItems];
			
			// For each item, add quantity and a new customer that bought it
			for(int j = 0; j < customerItems; j++) {
				int quantity = scan.nextInt();
				String name = scan.next();
				
				for(int k = 0; k < itemName.length; k++) {
					if(name.equals(itemName[k])) {
						itemCount[k] += quantity;
						
						// Keep track if this item is purchased, but only once per customer
						if(change[k] == false) {
							change[k] = true;
						}
					}
				}
			}
				
			// Change the number of customers that bought each item based on this customer
			for(int k = 0; k < itemName.length; k++) {
				if(change[k] == true) {
					itemCustomerCount[k]++;
				}
			}			
		}
		// Print results of how many customers bought how many of each item
		for(int i = 0; i < storeItems; i++) {
			if(itemCount[i] == 0) {
				System.out.printf("No customers bought %s", itemName[i]);
			}
			else {
				System.out.printf("\n%d customers bought %d %s", itemCustomerCount[i], itemCount[i], itemName[i]);
			}
		}
	}
}
