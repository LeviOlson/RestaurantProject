package Restaurant;

import java.util.ArrayList;
import java.util.Comparator;

public class Order {
	
	 class OrderItem {
		FoodType item;
		int quantity;
		
		public OrderItem(FoodType type, int quantity) {
			item = type;
			this.quantity = quantity;
		}
	}
	
	private ArrayList<OrderItem> items;
	int timeStamp;

	public Order(ArrayList<OrderItem> items, int timeStamp) {
		this.items = items;
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the items
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

	public boolean equals(Order o) {
		if (timeStamp == o.getTimeStamp() && compareItems(o)) {
			return true;
		}
		else {
			return false;
		}
	}
	
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

class CompareByTimeStamp implements Comparator<Order> {
		
		public int compare (Order a, Order b) {
			if (a.getTimeStamp() < b.getTimeStamp()) {
				return 1;
			}
			else if (a.getTimeStamp() == b.getTimeStamp()) {
				return 0;
			}
			else {
				return -1;
			}
		}
	}
	
}
