package Restaurant;

import java.util.ArrayList;
import java.util.Comparator;

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

	@Override
	public int compareTo(Order o) {
		return Integer.compare(timeStamp, o.getTimeStamp());
	}
}


