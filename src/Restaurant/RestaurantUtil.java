package Restaurant;


public abstract class RestaurantUtil {
	
	public static int getRandInt(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}
	
	public static Restaurant defaultRestuarant() {
		return new Restaurant(8, 12, 2, 6, 2, 2, 8, 2, 3, 1, 5);
	}
}
