package Restaurant;

/**
 * Class to represent the status of a restaurant object so that it can be passed to another object, environment, or computer, without sending a restaurant objectg
 * @author Levi Olson
 * @version 1.0
 */
public class RestaurantStatus {
	private int inLine;
	private int assembled;
	private int assembling;
	private int highestWait;
	private int totalServed;
	
	/**
	 * @return the amount of people in line
	 */
	public int getInline() {
		return inLine;
	}
	/**
	 * @return the number of orders that are assembled
	 */
	public int getAssembled() {
		return assembled;
	}
	/**
	 * @return the number or orders that are in assembly
	 */
	public int getAssembling() {
		return assembling;
	}
	/**
	 * @return the highest wait time currently
	 */
	public int getHighestWait() {
		return highestWait;
	}
	/**
	 * @return the total amount of customers served all time for this restaurant
	 */
	public int getTotalServed() {
		return totalServed;
	}
	
	/**
	 * Creates a RestaurantStatus object with all relevant data
	 * @param inLine the number of customers in line
	 * @param assembling the amount of orders in assembly
	 * @param assembled the amount of orders assembled
	 * @param highestWait the highest wait time currently
	 * @param totalServed the total amount of customers served all time for this restaurant
	 */
	public RestaurantStatus(int inLine, int assembling, int assembled, int highestWait, int totalServed) {
		this.inLine = inLine;
		this.assembling = assembling;
		this.assembled = assembled;
		this.highestWait = highestWait;
		this.totalServed = totalServed;
	}
	
	/**
	 * Returns a string representation of the RestaurantStatus object
	 * @return a paragraph describing the status of the restaurant
	 */
	public String toString() {
		String str = "";
		
		str += "Customers waiting to order: " + inLine;
		str += "\nOrders being assembled: " + assembling;
		str += "\nOrders waiting to be delivered: " + assembled;
		str += "\nCurrent hightest wait time: " + highestWait;
		str += "\nTotal orders served: " + totalServed;
		
		return str;
	}
}
