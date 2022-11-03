package Restaurant;

import java.util.Comparator;

enum FoodType {
	  BURGER,
	  FRIES,
	  DRINK
	}

public class FoodItem {

	private FoodType type;
	//true if the food is ready to be served, false if it is still cooking
	private boolean ready;
	//how long the food has been cooking for
	private int cookTime;
	
	public FoodItem(FoodType type) {
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public FoodType getType() {
		return type;
	}

	/**
	 * @param type the type to set
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
	 * @param ready the value to set
	 */
	public void setReady(boolean ready) {
		this.ready = ready;
	}

	/**
	 * @return the cookTime
	 */
	public int getCookTime() {
		return cookTime;
	}
	
	public void increaseCookTime(int increment) {
		cookTime += increment;
	}
	
	public boolean equals(FoodItem fi) {
		if (cookTime == fi.getCookTime() && type == fi.getType()) {
			return true;
		}
		else {
			return false;
		}
	}
}


