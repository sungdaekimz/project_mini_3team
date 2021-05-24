package com.kh.mini.model.vo;

public class Food extends Store {

	private int foodNo;
	private String foodName;
	private int foodPrice;

	public Food() {
		// TODO Auto-generated constructor stub
	}

	public Food(String storeName, int foodNo, String foodName, int foodPrice) {
		super(storeName);
		this.foodNo = foodNo;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		// TODO Auto-generated constructor stub
	}

	public int getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
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
		return "Food [foodNo=" + foodNo + ", foodName=" + foodName + ", foodPrice=" + foodPrice + "]";
	}

}
