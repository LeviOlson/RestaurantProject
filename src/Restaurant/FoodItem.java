package Restaurant;

import java.util.Comparator;

enum FoodType {
	  BURGER,
	  FRIES,
	  DRINK
	}

/**
 * An item of food
 * @author Levi Olson
 * @version 1.0
 */

public class FoodItem {

	private FoodType type;
	//true if the food is ready to be served, false if it is still cooking
	private boolean ready;
	//how long the food has been cooking for
	private int cookTime;
	
	/**
	 * Creates a new item with the specified type of food, with the cook time set to 0
	 * @param type what type of foode
	 */
	public FoodItem(FoodType type) {
		this.type = type;
		ready = false;
		cookTime = 0;
	}

	/**
	 * @return the type of food
	 */
	public FoodType getType() {
		return type;
	}

	/**
	 * @param type the type of food to set
	 */
	public void setType(FoodType type) {
		this.type = type;
	}

	/**
	 * @return true if the food is ready
	 */
	public boolean isReady() {
		return ready;
	}

	/**
	 * @param ready the value to set ready to
	 */
	public void setReady(boolean ready) {
		this.ready = ready;
	}

	/**
	 * @return the amount of time this item has been cooking for
	 */
	public int getCookTime() {
		return cookTime;
	}
	
	/**
	 * increase the amount of time this item has been cooking for.
	 * @param increment the amount of time to increase by
	 */
	public void increaseCookTime(int increment) {
		cookTime += increment;
	}
	
	/**
	 * compares two FoodItem objects, returning true only if the type of food is the same, and the cooktime is the same
	 * @param fi the FoodItem object to compare to
	 * @return true if the objects are equal, otherwise false
	 */
	public boolean equals(FoodItem fi) {
		if (cookTime == fi.getCookTime() && type == fi.getType()) {
			return true;
		}
		else {
			return false;
		}
	}
}


