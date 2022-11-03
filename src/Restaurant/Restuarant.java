package Restaurant;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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
	private int tick;
	
	
	public Restuarant(int burgerCookTime, int friesCookTime, int drinkCookTime, int orderTakingTime,
			int orderDeliveryTime, int burgerBatchSize, int friesBatchSize, int drinkBatchSize) {
		this.burgerCookTime = burgerCookTime;
		this.friesCookTime = friesCookTime;
		this.drinkCookTime = drinkCookTime;
		this.orderTakingTime = orderTakingTime;
		this.orderDeliveryTime = orderDeliveryTime;
		this.burgerBatchSize = burgerBatchSize;
		this.friesBatchSize = friesBatchSize;
		this.drinkBatchSize = drinkBatchSize;
		
		tick = 0;
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
