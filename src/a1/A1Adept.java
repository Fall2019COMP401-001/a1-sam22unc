package a1;

import java.util.Scanner;

public class A1Adept {

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
		
		// Create arrays of customer names and their spending totals
		int numCustomers = scan.nextInt();
		String[] firstName = new String[numCustomers];
		String[] lastName = new String[numCustomers];
		double[] custTotals = new double[numCustomers];
		
		// Get data for each customer
		for(int i = 0; i < numCustomers; i++) {
			firstName[i] = scan.next();
			lastName[i] = scan.next();
			
			int itemsCount = scan.nextInt();
			double total = 0;
			
			// For each item bought, calculate total price
			for(int j = 0; j < itemsCount; j++) {
				int quantity = scan.nextInt();
				String name = scan.next();
				
				// Find the price of the item
				int index = 0;
				for(int k = 0; k < itemName.length; k++) {
					if(name.equals(itemName[k])) {
						index = k;
					}
				}
				
				// Add item to total
				total += quantity * itemCost[index];
			}
			
			// Add customer total to array
			custTotals[i] = total;
			
		}
		
		// Print results
		System.out.printf("Biggest: %s %s (%.2f)", firstName[max(custTotals)], lastName[max(custTotals)], custTotals[max(custTotals)]);
		System.out.printf("\nSmallest: %s %s (%.2f)", firstName[min(custTotals)], lastName[min(custTotals)], custTotals[min(custTotals)]);
		System.out.printf("\nAverage: %.2f", averageTotals(custTotals));
	}
	
	/* min
	 * Finds and returns the index of the minimum value in an array of doubles
	 * 
	 * Input: array of double vals
	 * 
	 * Output: index of minimum value found within the array
	 * 
	 * Preconditions:
	 * Input array must not be null and must contain at least one value.
	 */
	static int min(double[] a) {
		int minIndex = 0;
		for(int i = 1; i < a.length; i++) {
			if(a[i] < a[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	/* max
	 * Finds and returns the index of the maximum value in an array of doubles
	 * 
	 * Input: array of double vals
	 * 
	 * Output: index of maximum value found within the array
	 * 
	 * Preconditions:
	 * Input array must not be null and must contain at least one value.
	 */
	static int max(double[] a) {
		int maxIndex = 0;
		for(int i = 1; i < a.length; i++) {
			if(a[i] > a[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	/* averageTotals
	 * Calculates the average of an array of doubles
	 * 
	 * Input: array of double vals
	 * 
	 * Output: average of the values found within the array
	 * 
	 * Preconditions:
	 * Input array must not be null and must contain at least one value.
	 */
	static double averageTotals(double[] a) {
		double total = 0;
		for(int i = 0; i < a.length; i++) {
			total += a[i];
		}
		return total / a.length;
	}
}
