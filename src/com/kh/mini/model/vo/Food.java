package com.kh.mini.model.vo;

public class Food extends Store {

	private String foodName;
	private int foodPrice;

	public Food() {
		// TODO Auto-generated constructor stub
	}

	public Food(String storeName, String foodName, int foodPrice) {
		super(storeName);
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		// TODO Auto-generated constructor stub
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

	@Override
	public String toString() {
		return foodName + " " + foodPrice + "원";
	}

}