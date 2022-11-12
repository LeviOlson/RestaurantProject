package Restaurant;

public class RestaurantStatus {
	private int inLine;
	private int assembled;
	private int assembling;
	private int highestWait;
	private int totalServed;
	
	//comments for getters are auto generated and may need to be updated for clarity
	/**
	 * @return the amount of people in line
	 */
	public int getInline() {
		return inLine;
	}
	/**
	 * @return the assembled
	 */
	public int getAssembled() {
		return assembled;
	}
	/**
	 * @return the assembling
	 */
	public int getAssembling() {
		return assembling;
	}
	/**
	 * @return the highestWait
	 */
	public int getHighestWait() {
		return highestWait;
	}
	/**
	 * @return the totalServed
	 */
	public int getTotalServed() {
		return totalServed;
	}
	
	public RestaurantStatus(int inLine, int assembling, int assembled, int highestWait, int totalServed) {
		this.inLine = inLine;
		this.assembling = assembling;
		this.assembled = assembled;
		this.highestWait = highestWait;
		this.totalServed = totalServed;
	}
	
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
