package com.kh.mini.model.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.kh.mini.model.vo.Store;
import com.kh.mini.model.vo.StoreReview;

public class StoreDao {

	private static ArrayList<Store> list = new ArrayList<Store>();
	private static ArrayList<StoreReview> reviewList = new ArrayList<StoreReview>();

	public StoreDao() {
		// TODO Auto-generated constructor stub
	}

	static {

		list.add(new Store(1, "다운타우너", "논현역", "02-1234-5678", "양식", "이예진", true, 5, 0));
		list.add(new Store(2, "브루클린", "논현역", "02-4321-5678", "양식", "이예진", true, 2, 0));
		list.add(new Store(3, "쉐이크쉑", "강남역", "02-2334-5667", "양식", "이예진", true, 1, 0));
		list.add(new Store(4, "바스버거", "신논현역", "02-3454-5098", "양식", "이예진", true, 3, 0));

		list.add(new Store(5, "웍셔너리", "논현역", "02-1432-5648", "중식", "이예진", true, 4, 0));
		list.add(new Store(6, "명성관", "논현역", "02-1112-5678", "중식", "이예진", true, 3, 0));
		list.add(new Store(7, "화양루", "강남역", "02-6443-0999", "중식", "이예진", true, 3.5, 0));
		list.add(new Store(8, "중식루", "신논현역", "02-0128-8362", "중식", "이예진", true, 1, 0));

		list.add(new Store(9, "우오하나", "논현역", "02-0148-1127", "일식", "이예진", true, 5, 0));
		list.add(new Store(10, "은행골", "논현역", "02-3883-3525", "일식", "yejin", true, 3, 0));
		list.add(new Store(11, "청담이상", "강남역", "02-9223-5556", "일식", "이예진", true, 2.1, 0));
		list.add(new Store(12, "희로", "신논현역", "02-0642-2447", "일식", "이예진", true, 5, 0));

		list.add(new Store(13, "호족반", "논현역", "02-0913-2347", "한식", "이예진", true, 5, 0));
		list.add(new Store(14, "역삼갈비", "논현역", "02-2291-2231", "한식", "김성대", true, 2, 0));
		list.add(new Store(15, "경복궁", "강남역", "02-1939-6450", "한식", "이예진", true, 2, 0));
		list.add(new Store(16, "오라방", "신논현역", "02-2401-5441", "한식", "이예진", true, 5, 0));

		System.out.println(list);
		System.out.println("가게 리스트 생성 완료!");

	}

	// 리스트의 마지막 번호 얻어오기
	public int getLastStoreNo() {

		return list.get(list.size() - 1).getStoreNo();
	}

	// 1. 게시글 쓰기
	public void writeStore(Store store) {
		list.add(store);
	}

	// 2. 전체 가게 보기
	public ArrayList<Store> displayAllList() {

		return list;
	}

	// 2_1. 특정 가게 보기
	public Store displayStore(String storeName) {
		Store Store = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStoreName().contains(storeName)) {
				// 반복문을 돌리면서 list에 있는 Store객체들의 게시글 번호를 확인하고
				// 사용자가 입력했던 번호랑 일치하는게 이씨다면
				Store = list.get(i);
				// 그 Store객체를 저장
				break;
			}
		}
		return Store;
	}

	// 2_2. 점주 이름(로그인 된 계정)으로 가게 이름 찾기
	public String findStoreName(String ownerName) {
		String storeName = "";
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getOwnerName().contains(ownerName)) {
				storeName = list.get(i).getStoreName();
				break;
			}
		}
		return storeName;
	}

	// 3. 조회수 올리기
	public void upReadCount(int no) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStoreNo() == no) {
				list.get(i).setVisitCount(list.get(i).getVisitCount() + 1);
				// (기존의 조회수 + 1)을 조회수로써 수정한다.
				break;
			}
		}

	}

	/*// 4. 게시글 제목 수정
	public void modifyTitle(int no, String name) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStoreNo() == no) {
				list.get(i).setStoreName(name);
				break;
			}
		}
	}

	// 5. 게시글 내용 수정
	public void modifyContent(int no, String content) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStoreNo() == no) {
				list.get(i).setStoreAddr(content);
				break;
			}
		}
	}

	// 6. 게시글 삭제
	public void deleteStore(int no) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStoreNo() == no) {
				list.remove(i);
				break;
			}
		}
	}

	// 7. 게시글 검색
	public ArrayList<Store> searchStore(String title) {

		ArrayList<Store> searchList = new ArrayList<Store>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStoreName().contains(title)) {
				searchList.add(list.get(i));

				
				 * // 조회수 올리기 list.get(i).setVisitCount(list.get(i).getVisitCount() + 1);
				 
			}
		}

		return searchList;
	}*/
	
	
	// --------
	public int getLastReviewCount(String sName) {		// 가게 마지막 방문번호 얻어오기 // 필요없어짐.
		
		ArrayList<StoreReview> lastRC = new ArrayList<StoreReview>();
		
		for (int i = 0; i < reviewList.size(); i++) {
			if (reviewList.get(i).getStoreName().equals(sName)) {
				lastRC.add(reviewList.get(i));
				}
			
		}
		if(lastRC.isEmpty()) {
			return 0;
		}
		return lastRC.get(lastRC.size()-1).getReviewCount();
	}
	
	
	
	public void addReview(StoreReview store) {
		reviewList.add(store);
	}
	
	public ArrayList<StoreReview> displayAllReviewList() {
		
		return reviewList;
	}

	public void addStoreStar(String sName, double star) {
		
//		System.out.println(sName+"(은/는) "+star);
		
		double storeGrade = 0;
		int visitCount = 0;
		
		ArrayList<Store> vc = new ArrayList<Store>();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStoreName().equals(sName)) {
				vc.add(list.get(i));
				storeGrade = vc.get(0).getStoreGrade();
				visitCount = vc.get(0).getVisitCount();
			} 
		}
		double totalStoreGrade = 0;
		
		if(visitCount == 1) {
			totalStoreGrade = storeGrade+star;
		}else {
			totalStoreGrade = storeGrade*(visitCount-1)+star;
		}
		double avgStoreGrade = totalStoreGrade/(double)(visitCount);
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStoreName().equals(sName)) {
				list.get(i).setStoreGrade(avgStoreGrade);
			} 
		}
		System.out.println(avgStoreGrade);
	}

	// 이름순정렬

	public ArrayList<Store> displayStore_name() {

		Store Store = null;

		Comparator<Store> comparator = new Comparator<Store>() {
			@Override
			public int compare(Store o1, Store o2) {
				// TODO Auto-generated method stub
				return o1.getStoreName().compareTo(o2.getStoreName());
			};
		};

		Collections.sort(list, comparator);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getStoreName()+list.get(i).getStoreAddr());
			//System.out.println(list.get(i).getStoreAddr());
			Store = list.get(i);
		}
		return list;

	}

	// 가게 평점순 출력
	public ArrayList<Store> displayStore_grade() {
		Store Store = null;

		Comparator<Store> comparator = new Comparator<Store>() {
			@Override
			public int compare(Store a, Store b) {
				return (int) (b.getStoreGrade() - a.getStoreGrade());
			}
		};

		Collections.sort(list, comparator);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getStoreName()+list.get(i).getStoreAddr());
			Store = list.get(i);
		}
		return list;

	}

	// 가게삭제 ??
	public void deleteStore_name(String deleteName) {

		for (int i = 0; i < list.size(); i++) {
			list.get(i).getStoreName().equals(deleteName);
			list.remove(i);
			break;
		}
	}

}
