package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		//Sets number of customers
		int totalCustomers = scan.nextInt();
		
		// Loop through data for every customer - name and unique items purchased
		for(int i = 0; i < totalCustomers; i++) {
			String firstName = scan.next();
			String lastName = scan.next();
			int itemsBought = scan.nextInt();
			
			// Calculate total from the quantity and price of items purchased
			double total = 0.00;
			for(int j = 0; j < itemsBought; j++) {
				int itemQuantity = scan.nextInt();
				String item = scan.next();
				double price = scan.nextDouble();
				
				total += price * itemQuantity;
			}
			
			// Print results
			System.out.printf("\n%s. %s: %.2f",firstName.substring(0,1), lastName, total);
		}
	}
}
