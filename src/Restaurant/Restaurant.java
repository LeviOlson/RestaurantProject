package Restaurant;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import Restaurant.Order.OrderItem;
/**
 * Restaurant simulation
 * @author Levi Olson
 * @version 1.0
 */
public class Restaurant {
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
	private int currentDeliveryTick;
	private int ordersServed;
	
	
	/**
	 * Creates a restaurant object with all relevant data
	 */
	public Restaurant(int burgerCookTime, int friesCookTime, int drinkCookTime, int orderTakingTime,
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
		currentDeliveryTick = 0;
		ordersServed = 0;
		burgers = new LinkedList<FoodItem>();
		fries = new LinkedList<FoodItem>();
		drinks = new LinkedList<FoodItem>();
		inLine = new LinkedList<Order>();
		assembling = new PriorityQueue<Order>();
		assembled = new PriorityQueue<Order>();
	}

	/**
	 * Advances the simulation by 1 tick.
	 */
	public void tick() {
		tick++;

		//add a new order to the system when its been enough ticks
		if (tick % orderFrequency == 0) {
			int amount = RestaurantUtil.getRandInt(minOrdersSpawn, maxOrdersSpawn);
			for (int i = 0; i < amount; i++) {
				inLine.add(generateOrder());
			}
		}
		
		
		//start new batch of each food item type
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
		
		//if the order being taken right now is done being taken, move it to assembly and start taking the next order
		if (!inLine.isEmpty() && tick - inLine.peek().getTimeStamp() >= orderTakingTime) {
			moveToAssembly();
		}
		
		//move orders to assembled if enough food is ready
		for (Order o: assembling) {
			if (amountReady(burgers) >= o.getQuantity(FoodType.BURGER) || amountReady(fries) >= o.getQuantity(FoodType.FRIES) || amountReady(drinks) >= o.getQuantity(FoodType.DRINK)) {
				moveToAssembled(o);
			}
		}
		
		//deliver the next ready order if the amount of ticks it takes to deliver an order has passed
		if (currentDeliveryTick >= orderDeliveryTime) {
			deliver();
			currentDeliveryTick = 0;
		}
		else if (!assembled.isEmpty()){
			currentDeliveryTick++;
		}
	}
	
	/**
	 * Return the amount of food that is ready from the given queue of food
	 * @param q the queue of food
	 * @return the amount of food  in the queue that is ready
	 */
	public int amountReady(Queue<FoodItem> q) {
		int n = 0;
		for (FoodItem fi: q) {
			if (fi.isReady()) {
				n++;
			}
		}
		
		return n;
	}
	
	/**
	 * Generate a new order with random items
	 * @return the order generated
	 */
	public Order generateOrder() {
		Order dummy = new Order(null, 0);
		final int min = 0;
		final int max = 5;
		Order order = null;
		ArrayList<OrderItem> items = new ArrayList<OrderItem>();
		for (FoodType t: FoodType.values()) {
			int amount = RestaurantUtil.getRandInt(min, max);
			
			for (int i = 0; i < amount; i++) {
				OrderItem oi = dummy.new OrderItem(t, amount);
				items.add(oi);
			}
			
			order = new Order(items, tick);
		}
		return order;
	}
	
	/**
	 * Generates a RestaurantStatus object with the relevant data from this restaurant
	 * @return the object generated
	 */
	public RestaurantStatus getStatus() {
		return new RestaurantStatus(inLine.size(), assembling.size(), assembled.size(), highestWait(), ordersServed);
	}
	
	/**
	 * finds the highest current wait time
	 * @return the highest current wait time
	 */
	public int highestWait() {
		int highestWait = 0;
		
		for (Order o: inLine) {
			if (tick - o.getTimeStamp() > highestWait) {
				highestWait = tick - o.getTimeStamp();
			}
		}
		
		for (Order o: assembling) {
			if (tick - o.getTimeStamp() > highestWait) {
				highestWait = tick - o.getTimeStamp();
			}
		}
		
		for (Order o: assembled) {
			if (tick - o.getTimeStamp() > highestWait) {
				highestWait = tick - o.getTimeStamp();
			}
		}
		
		return highestWait;
	}
	
	
	private void moveToAssembly() {
		if(!inLine.isEmpty()) {
		assembling.offer(inLine.poll());
		}
	}
	
	private void moveToAssembled(Order o) {
		assembling.remove(o);
		assembled.add(o);
	}
	
	private void deliver() {
		assembled.poll();
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
