package Restaurant;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * An order in a restaurant
 * @author Levi Olson
 * @version 1.0
 */
public class Order implements Comparable<Order> {
	
	 class OrderItem {
		FoodType item;
		int quantity;
		
		public OrderItem(FoodType type, int quantity) {
			item = type;
			this.quantity = quantity;
		}
	}
	
	private ArrayList<OrderItem> items;
	private int timeStamp;
	
	/**
	 * Creates an order
	 * @param items the items that are on the order
	 * @param timeStamp which tick in the simulation the order was placed
	 */
	public Order(ArrayList<OrderItem> items, int timeStamp) {
		this.items = items;
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the items on the order
	 */
	public ArrayList<OrderItem> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(ArrayList<OrderItem> items) {
		this.items = items;
	}
	
	/**
	 * Get how many of a given item type the order has. For example if the order if for 2 burgers and 1 drink, entering burger for the parameter will return 2, drink 1, and fries 0
	 * @param the type of food
	 * @return how many of that type of food is on the order
	 */
	public int getQuantity(FoodType type) {
		int n = 0;
		
		for (OrderItem OI: items) {
			if (OI.item == type) {
				n = OI.quantity;
				break;
			}
		}
		
		return n;
	}
	
/**
	 * @return the timeStamp
	 */
	public int getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * Compares to order objects to each other. Returns true only if the orders have the exact same items and were placed at the same time
	 * @param o the order to compare to
	 * @return true if the objects are equal, otherwise false
	 */
	public boolean equals(Order o) {
		if (timeStamp == o.getTimeStamp() && compareItems(o)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Compare the items on this order those on another. Returns true only if the orders are for the exact same food items
	 * @param o the order to compare to
	 * @return true if the items on both orders are exactly the same, otherwise false
	 */
	public boolean compareItems(Order o) {
		ArrayList<OrderItem> oItems = o.getItems();
		if (oItems.size() == items.size()) {
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i) != oItems.get(i)) {
					return false;
				}
			}
		}
		else {
			return false;
		}
		
		return true;
	}

	@Override
	/**
	 * compares two orders based on when they were placed, so that older orders can be given priority
	 * @param o the order to compare to
	 * @return a positive value if this is older than o, a negative value if this is less old than o, and 0 if this is equally old as o
	 */
	public int compareTo(Order o) {
		return Integer.compare(timeStamp, o.getTimeStamp());
	}
}


