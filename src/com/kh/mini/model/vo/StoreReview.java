package com.kh.mini.model.vo;

public class StoreReview extends Store {

	private String storeReview; // 가게 리뷰
	private int reviewCount = 0;
	private String reviewDate;

	public StoreReview() {
		// TODO Auto-generated constructor stub
	}

	public StoreReview(String storeName, double storeGrade, String storeReview, int reviewCount, String reviewDate) {
		super(storeName, storeGrade);
		this.storeReview = storeReview;
		this.reviewCount = reviewCount;
		this.reviewDate = reviewDate;
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
	
	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

//	@Override
//	public String toString() {
//		return "StoreReview [storeReview= 이용매장: "+getStoreName()+" / 별점:  "+getStoreGrade()+" / 후기: "+ storeReview + "]";
//	}

	@Override
	public String toString() {
		return "==" + getStoreName() + "이용자의 후기입니다.==\n" + "별점: " + getStoreGrade() + "\n작성일: " +reviewDate+ "\n후기: "+storeReview + "\n";
	}

}