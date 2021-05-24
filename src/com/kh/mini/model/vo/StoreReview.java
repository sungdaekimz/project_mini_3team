package com.kh.mini.model.vo;

public class StoreReview extends Store {

	private String storeReview; // 가게 리뷰
	private int reviewCount = 0;

	public StoreReview() {
		// TODO Auto-generated constructor stub
	}

	public StoreReview(String storeName, double storeGrade, String storeReview, int reviewCount) {
		super(storeName, storeGrade);
		this.storeReview = storeReview;
		this.reviewCount = reviewCount;
	}

	// 추가부분
	public String getStoreReview() {
		return storeReview;
	}

	public void setStoreReview(String storeReview) {
		this.storeReview = storeReview;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

//	@Override
//	public String toString() {
//		return "StoreReview [storeReview= 이용매장: "+getStoreName()+" / 별점:  "+getStoreGrade()+" / 후기: "+ storeReview + "]";
//	}

	@Override
	public String toString() {
		return "==" + getStoreName() + "이용자의 후기입니다.==\n" + "별점: " + getStoreGrade() + "\n" + storeReview + "\n";
	}

}