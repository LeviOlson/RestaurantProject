package Restaurant;


public abstract class RestaurantUtil {
	
	public static int getRandInt(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}
}
