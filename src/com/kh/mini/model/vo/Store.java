package com.kh.mini.model.vo;

public class Store extends User {

	private int storeNo;
	private String storeName; // 가게명
	private String storeAddr; // 가게 주소
	private String storeCall; // 가게 전화번호
	private String storeType; // 가게 종류 (카페, 한식, 양식 등)
	private String ownerName; // 사장님 이름
	private boolean storeOpen; // 가게 오픈 여부
	private double storeGrade; // 별점
	private int visitCount; // 방문 횟수

	public Store() {
		// TODO Auto-generated constructor stub
	}	

	public Store(int storeNo, String storeName, String storeAddr, String storeCall, String storeType, String ownerName,
			boolean storeOpen, double storeGrade, int visitCount) {
		super();
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.storeAddr = storeAddr;
		this.storeCall = storeCall;
		this.storeType = storeType;
		this.ownerName = ownerName;
		this.storeOpen = storeOpen;
		this.storeGrade = storeGrade;
		this.visitCount = visitCount;
	}
	
	public Store(String storeName) {
		super();
		this.storeName = storeName;
	}
	
	public Store(String storeName,  double storeGrade) {
		super();
		this.storeName = storeName;
		this.storeGrade = storeGrade;
	}

	public int getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddr() {
		return storeAddr;
	}

	public void setStoreAddr(String storeAddr) {
		this.storeAddr = storeAddr;
	}

	public String getStoreCall() {
		return storeCall;
	}

	public void setStoreCall(String storeCall) {
		this.storeCall = storeCall;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public boolean isStoreOpen() {
		return storeOpen;
	}

	public void setStoreOpen(boolean storeOpen) {
		this.storeOpen = storeOpen;
	}

	public double getStoreGrade() {
		return storeGrade;
	}

	public void setStoreGrade(double storeGrade) {
		this.storeGrade = storeGrade;
	}

	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	@Override
	public String toString() {
		return "Store [storeNo=" + storeNo + ", storeName=" + storeName + ", storeAddr=" + storeAddr + ", storeCall="
				+ storeCall + ", storeType=" + storeType + ", ownerName=" + ownerName + ", storeOpen=" + storeOpen
				+ ", storeGrade=" + storeGrade + ", visitCount=" + visitCount + "]";
	}

}
