package com.kh.mini.model.dao;

import java.util.ArrayList;

import com.kh.mini.model.vo.Food;

public class FoodDao {

	static ArrayList<Food> list = new ArrayList<Food>();
	// vo클래스 자료형을 임시로 저장할 컬렉션(ArrayList)
	
	public FoodDao() {
		// TODO Auto-generated constructor stub
	}

	static {
		
		list.add(new Food("은행골", "특상초밥", 20000));
		list.add(new Food("은행골", "특선초밥", 15000));
		list.add(new Food("은행골", "특미초밥", 10000));
		list.add(new Food("은행골", "연어초밥", 13000));
		list.add(new Food("역삼갈비", "김치짜글이", 12000));
		list.add(new Food("역삼갈비", "갈비탕", 11000));
		
		System.out.println(list);
	    System.out.println("메뉴 리스트 생성 완료!");

	}

	// 1. 메뉴 추가
	public void writeFood(Food Food) {
		list.add(Food);
	}

	// 2. 메뉴 전체 보기
	public ArrayList<Food> displayAllList() {

		return list;
	}

	// 2_1. 특정 가게의 메뉴 전체 보기
	public ArrayList<Food> displayAllList(String storeName) {

		ArrayList<Food> searchList = new ArrayList<Food>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStoreName().contains(storeName)) {
				searchList.add(list.get(i));

			}
		}

		return searchList;
	}

	// 3. 메뉴 삭제
	public void deleteFood(String name) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getFoodName().equals(name)) {
				list.remove(i);
				break;
			}
		}
	}
	
}
