package Restaurant;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import Restaurant.Order.OrderItem;

public class Restuarant {
	private Queue<Order> inLine;
	private PriorityQueue<Order> assembling;
	private PriorityQueue<Order> assembled;
	private Queue<FoodItem> burgers;
	private Queue<FoodItem> fries;
	private Queue<FoodItem> drinks;
	private int burgerCookTime;
	private int friesCookTime;
	private int drinkCookTime;
	private int orderTakingTime;
	private int orderDeliveryTime;
	private int burgerBatchSize;
	private int friesBatchSize;
	private int drinkBatchSize;
	private int orderFrequency;
	private int minOrdersSpawn;
	private int maxOrdersSpawn;
	private int tick;
	private int ordersServed;
	
	
	public Restuarant(int burgerCookTime, int friesCookTime, int drinkCookTime, int orderTakingTime,
			int orderDeliveryTime, int burgerBatchSize, int friesBatchSize, int drinkBatchSize, int orderFrequency, int minOrdersSpawn, int maxOrdersSpawn) {
		this.burgerCookTime = burgerCookTime;
		this.friesCookTime = friesCookTime;
		this.drinkCookTime = drinkCookTime;
		this.orderTakingTime = orderTakingTime;
		this.orderDeliveryTime = orderDeliveryTime;
		this.burgerBatchSize = burgerBatchSize;
		this.friesBatchSize = friesBatchSize;
		this.drinkBatchSize = drinkBatchSize;
		this.orderFrequency = orderFrequency;
		this.minOrdersSpawn = minOrdersSpawn;
		this.maxOrdersSpawn = maxOrdersSpawn;
		
		tick = 0;
		ordersServed = 0;
		burgers = new LinkedList<FoodItem>();
		fries = new LinkedList<FoodItem>();
		drinks = new LinkedList<FoodItem>();
		inLine = new LinkedList<Order>();
		assembling = new PriorityQueue<Order>();
		assembled = new PriorityQueue<Order>();
	}

	//advances the time by 1 tick
	public void tick() {
		tick++;
		
		if (tick % orderFrequency == 0) {
			int amount = RestuarantUtil.getRandInt(minOrdersSpawn, maxOrdersSpawn);
			
			for (int i = 0; i < amount; i++) {
				inLine.add(generateOrder());
			}
		}
		
		
		//start new batch of each
		for (FoodItem fi: burgers) {
			if (!fi.isReady()) {
				fi.increaseCookTime(1);
				if (fi.getCookTime() >= burgerCookTime) {
					fi.setReady(true);
				}
			}
		}
		for (FoodItem fi: fries) {
			if (!fi.isReady()) {
				fi.increaseCookTime(1);
				if (fi.getCookTime() >= friesCookTime) {
					fi.setReady(true);
				}
			}
		}
		for (FoodItem fi: drinks) {
			if (!fi.isReady()) {
				fi.increaseCookTime(1);
				if (fi.getCookTime() >= drinkCookTime) {
					fi.setReady(true);
				}
			}
		}
		
		//move order to assembling if ticked
		//move order to assembled if ready
		//clear order
	}
	
	public Order generateOrder() {
		Order dummy = new Order(null, 0);
		final int min = 0;
		final int max = 5;
		Order order = null;
		ArrayList<OrderItem> items = new ArrayList<OrderItem>();
		for (FoodType t: FoodType.values()) {
			int amount = RestuarantUtil.getRandInt(min, max);
			
			for (int i = 0; i < amount; i++) {
				OrderItem oi = dummy.new OrderItem(t, amount);
				items.add(oi);
			}
			
			order = new Order(items, tick);
		}
		return order;
	}
	
	public String getStatus() {
		String str = "";
		
		str += "Customers waiting to order: " + inLine.size();
		str += "\nOrders being assembled: " + assembling.size();
		str += "\nOrders waiting to be delivered: " + assembled.size();
		str += "\nTotal orders served: " + ordersServed;
		
		return str;
	}
	
	private void addToLine(Order o) {
		inLine.add(o);
	}
	
	private void moveToAssembly() {
		if(!inLine.isEmpty()) {
		assembling.offer(inLine.poll());
		}
	}
	
	private void moveToAssembled() {
		if(!assembling.isEmpty()) {
			assembled.offer(assembling.poll());
			}
	}
	
	private void deliver(Order o) {
		assembled.remove(o);
		ordersServed++;
	}
	
	/**
	 * @return the burgerCookTime
	 */
	public int getBurgerCookTime() {
		return burgerCookTime;
	}
	/**
	 * @param burgerCookTime the burgerCookTime to set
	 */
	public void setBurgerCookTime(int burgerCookTime) {
		this.burgerCookTime = burgerCookTime;
	}
	/**
	 * @return the friesCookTime
	 */
	public int getFriesCookTime() {
		return friesCookTime;
	}
	/**
	 * @param friesCookTime the friesCookTime to set
	 */
	public void setFriesCookTime(int friesCookTime) {
		this.friesCookTime = friesCookTime;
	}
	/**
	 * @return the drinkCookTime
	 */
	public int getDrinkCookTime() {
		return drinkCookTime;
	}
	/**
	 * @param drinkCookTime the drinkCookTime to set
	 */
	public void setDrinkCookTime(int drinkCookTime) {
		this.drinkCookTime = drinkCookTime;
	}
	/**
	 * @return the burgerBatchSize
	 */
	public int getBurgerBatchSize() {
		return burgerBatchSize;
	}
	/**
	 * @param burgerBatchSize the burgerBatchSize to set
	 */
	public void setBurgerBatchSize(int burgerBatchSize) {
		this.burgerBatchSize = burgerBatchSize;
	}
	/**
	 * @return the friesBatchSize
	 */
	public int getFriesBatchSize() {
		return friesBatchSize;
	}
	/**
	 * @param friesBatchSize the friesBatchSize to set
	 */
	public void setFriesBatchSize(int friesBatchSize) {
		this.friesBatchSize = friesBatchSize;
	}
	/**
	 * @return the drinkBatchSize
	 */
	public int getDrinkBatchSize() {
		return drinkBatchSize;
	}
	/**
	 * @param drinkBatchSize the drinkBatchSize to set
	 */
	public void setDrinkBatchSize(int drinkBatchSize) {
		this.drinkBatchSize = drinkBatchSize;
	}
	/**
	 * @return the inLine
	 */
	
	
	public Queue<Order> getInLine() {
		return inLine;
	}
	/**
	 * @return the orderDeliveryTime
	 */
	public int getOrderDeliveryTime() {
		return orderDeliveryTime;
	}

	/**
	 * @param orderDeliveryTime the orderDeliveryTime to set
	 */
	public void setOrderDeliveryTime(int orderDeliveryTime) {
		this.orderDeliveryTime = orderDeliveryTime;
	}

	/**
	 * @return the orderTakingTime
	 */
	public int getOrderTakingTime() {
		return orderTakingTime;
	}

	/**
	 * @param orderTakingTime the orderTakingTime to set
	 */
	public void setOrderTakingTime(int orderTakingTime) {
		this.orderTakingTime = orderTakingTime;
	}
	
	

	/**
	 * @return the orderFrequency
	 */
	public int getOrderFrequency() {
		return orderFrequency;
	}

	/**
	 * @param orderFrequency the orderFrequency to set
	 */
	public void setOrderFrequency(int orderFrequency) {
		this.orderFrequency = orderFrequency;
	}

	/**
	 * @return the minOrdersSpawn
	 */
	public int getMinOrdersSpawn() {
		return minOrdersSpawn;
	}

	/**
	 * @param minOrdersSpawn the minOrdersSpawn to set
	 */
	public void setMinOrdersSpawn(int minOrdersSpawn) {
		this.minOrdersSpawn = minOrdersSpawn;
	}

	/**
	 * @return the maxOrdersSpawn
	 */
	public int getMaxOrdersSpawn() {
		return maxOrdersSpawn;
	}

	/**
	 * @param maxOrdersSpawn the maxOrdersSpawn to set
	 */
	public void setMaxOrdersSpawn(int maxOrdersSpawn) {
		this.maxOrdersSpawn = maxOrdersSpawn;
	}

	/**
	 * @return the assembling
	 */
	public PriorityQueue<Order> getAssembling() {
		return assembling;
	}
	/**
	 * @return the assembled
	 */
	public PriorityQueue<Order> getAssembled() {
		return assembled;
	}
}
