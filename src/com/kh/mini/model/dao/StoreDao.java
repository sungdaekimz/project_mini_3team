package com.kh.mini.model.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.kh.mini.model.vo.Store;
import com.kh.mini.model.vo.StoreReview;
import com.kh.mini.model.vo.User;

public class StoreDao {

	private static ArrayList<Store> list = new ArrayList<Store>();
	private static ArrayList<Store> reserveList = new ArrayList<Store>();
	private static ArrayList<StoreReview> reviewList = new ArrayList<StoreReview>();

	public StoreDao() {
		// TODO Auto-generated constructor stub
	}

	static {

		list.add(new Store(1, "다운타우너", "논현역", "1", "양식", "이태민", true, 5, 0));
		list.add(new Store(2, "브루클린", "논현역", "2", "양식", "김철수", true, 5, 0));
		list.add(new Store(3, "쉐이크쉑", "강남역", "3", "양식", "김영희", true, 5, 0));
		list.add(new Store(4, "바스버거", "신논현역", "4", "양식", "한강", true, 5, 0));

		list.add(new Store(5, "중화루", "논현역", "1", "중식", "최진영", true, 5, 0));
		list.add(new Store(6, "금장각", "논현역", "2", "중식", "향돌", true, 5, 0));
		list.add(new Store(7, "화양루", "강남역", "3", "중식", "육성재", true, 5, 0));
		list.add(new Store(8, "중식루", "신논현역", "4", "중식", "나재민", true, 5, 0));

		list.add(new Store(9, "우오하나", "논현역", "1", "일식", "현승희", true, 5, 0));
		list.add(new Store(10, "은행골", "논현역", "2", "일식", "이예진", true, 3, 0));
		list.add(new Store(11, "청담이상", "강남역", "3", "일식", "아린", true, 5, 0));
		list.add(new Store(12, "스시루", "신논현역", "4", "일식", "주학년", true, 5, 0));

		list.add(new Store(13, "호족반", "논현역", "1", "한식", "서은광", true, 5, 0));
		list.add(new Store(14, "역삼갈비", "논현역", "2", "한식", "김성대", true, 5, 0));
		list.add(new Store(15, "경복궁", "강남역", "3", "한식", "이창섭", true, 5, 0));
		list.add(new Store(16, "광화문", "신논현역", "4", "한식", "유강민", true, 5, 0));

		System.out.println(list);
		System.out.println("가게 리스트 생성 완료!");

	}

	// 리스트의 마지막 번호 얻어오기
	public int getLastStoreNo() {

		return list.get(list.size() - 1).getStoreNo();
	}

	// 1. 가게 추가
	public void writeStore(Store store) {
		list.add(store);
	}
	
	// 1_1. 예약할 가게 정보를 예약 리스트에 추가
	public void writeReserveStore(Store store) {
		reserveList.add(store);
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
	
	// 3. 가게 유형별로 검색
	public ArrayList<Store> searchStore(String type) {

		ArrayList<Store> searchList = new ArrayList<Store>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStoreType().contains(type)) {
				searchList.add(list.get(i));

			}
		}

		return searchList;
	}
	
	// 4. 예약한 가게 보기
		public ArrayList<Store> displayReserveList() {

			return reserveList;
		}

	
	// -------------------- 여기부터 삭제해도 될런지?
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
	// --------------------
	
	
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
		double avgStoreGrade = totalStoreGrade/(double)(visitCount+1);
		
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
			System.out.println(list.get(i).getStoreName());
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
			System.out.println(list.get(i).getStoreName());
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
