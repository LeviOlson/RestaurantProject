/**************************************************************
* Name        : Restaurant Project / Final Project
* Author      : Levi Olson
* Created     : 12/5/2022
* Course      : CIS 152 Data Structures
* Version     : 1.0
* OS          : Windows 10
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program simulates a fast food restaurant keeping track of how many customers are in line, what food is ready, etc
*               Input:  Custom values for speed of restaurant, and clicking button to simulate
*               Output: The status of the restaurant
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/


package Restaurant;

import java.util.Scanner;

/**
 * Driver class used to access and test the simulation. Intended for testing purposes only, the end user should use the GUI
 * @author Levi Olson
 * @version 1.0
 */
public class Driver {
	
	public static Restaurant r;

	/**
	 * The user can continuously simulate a restaurant with the default values, entering however many ticks they would like to simulate, or entering a negative value to exit
	 */
	public static void main(String[] args) {
		r = RestaurantUtil.defaultRestuarant();
		Scanner in = new Scanner(System.in);
		String tickMessage = "Please enter how many ticks you would like to simulate. Enter a negative number to exit";
		
		while (true) {
			int ticks = getIntInput(in, tickMessage);
			
			if (ticks < 0) {
				System.exit(0);
			}
			
			for (int i = 0; i < ticks; i++) {
				r.tick();
			}
			
			System.out.println(r.getStatus());
		}
	}
	
	/**
	 * Gets valid integer input from the user, continuously prompting them until they enter valid input
	 * @param in a Scanner object to use
	 * @param message the message to prompt the user with (ex: "please enter a number")
	 * @return the value entered
	 */
	public static int getIntInput(Scanner in, String message) {
		System.out.println(message + "\n");
		
		int input;
		try {
			input = Integer.parseInt(in.nextLine());
		}
		catch (Exception e) {
			return getIntInput(in, "Please a enter valid integer");
		}
		return input;
	}
	
}
