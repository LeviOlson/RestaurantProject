package Restaurant;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Restaurant restuarant = defaultRestuarant();
		Scanner in = new Scanner(System.in);
		String tickMessage = "Please enter how many ticks you would like to simulate. Enter a negative number to exit";
		
		while (true) {
			int ticks = getIntInput(in, tickMessage);
			
			if (ticks < 0) {
				System.exit(0);
			}
			
			for (int i = 0; i < ticks; i++) {
				restuarant.tick();
				System.out.println();
			}
			
			System.out.println(restuarant.getStatus());
		}
	}
	
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
	
	public static Restaurant defaultRestuarant() {
		return new Restaurant(80, 120, 15, 60, 20, 8, 8, 2, 30, 1, 5);
	}
}
