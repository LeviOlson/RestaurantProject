package Restaurant;

/**
 * Utility class for the restaurant project
 * @author Levi Olson
 * @version 1.0
 */
public abstract class RestaurantUtil {
	
	/**
	 * Gets a pseudo-random integer in the specified range
	 * This is not secure but will suffice for this program
	 * @param min the lowest possible value
	 * @param max the highest possible value
	 * @return a pseudo-random integer in the specified range
	 */
	public static int getRandInt(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}
	
	/**
	 * Returns a restaurant with default values for ease of use and testing
	 * @return a restaurant object with default values
	 */
	public static Restaurant defaultRestuarant() {
		return new Restaurant(8, 12, 2, 6, 2, 2, 8, 2, 3, 1, 5);
	}
}
