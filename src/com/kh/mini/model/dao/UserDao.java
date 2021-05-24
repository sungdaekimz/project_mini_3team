package com.kh.mini.model.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.kh.mini.model.vo.User;

public class UserDao {
	
	static ArrayList<User> list = new ArrayList<User>();
	static ArrayList<User> loginList = new ArrayList<User>();
	
	/*
	static {
		
		list.add(new User("admin", "admin", "관리자", "010-0000-0000", 28, 'F', 'A'));
		
		System.out.println("계정 리스트 생성 완료!");
		
	}
	*/
	
	public UserDao() {
		// TODO Auto-generated constructor stub
	}
	
	// 회원 리스트의 마지막 번호 얻어오기
	public int getListSize() {

		return list.size();
	}
	
	// 1. 리스트에 회원 추가
	public void writeUser(User User) {
		list.add(User);
	}

	// 1_1. 로그인 리스트에 로그인한 회원을 추가
	public void writeLoginUser(User User) {
		loginList.add(User);
	}

	// 2. 회원 정보 전체 보기
	public ArrayList<User> displayAllList() {

		return list;
	}

	// 2_1. 특정 회원의 정보 전체 보기
	public ArrayList<User> displayAllList(String userId) {

		ArrayList<User> searchList = new ArrayList<User>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUserId().contains(userId)) {
				searchList.add(list.get(i));

			}
		}

		return searchList;
	}
	
	// 2_2. 로그인 유저 보기
	public User displayLoginUser() {

		return loginList.get(0);
	}

	// 3. 회원 한 명 보기
	public User displayUser(String userId) {
		User user = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUserId().contains(userId)) {
				user = list.get(i);
				// 그 User객체를 저장
				break;
			}
		}
		return user;
	}

	// 4. 회원 검색
	public ArrayList<User> searchUser(String title) {

		ArrayList<User> searchList = new ArrayList<User>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUserName().contains(title)) {
				searchList.add(list.get(i));

				/*
				 * // 조회수 올리기 list.get(i).setReadCount(list.get(i).getReadCount() + 1);
				 */
			}
		}

		return searchList;
	}
	
	
	public void readFileUser() {
		
		String userId = null, userPwd = null, userName = null, userPhone = null;
		int userAge = 0;
		char userGender = '\u0000', userType = '\u0000';

		try {
			FileReader fr = new FileReader("sginupWriter.txt");
			BufferedReader br = new BufferedReader(fr);

			String userinfo = br.readLine();
			
			while (userinfo != null) {
				StringTokenizer st = new StringTokenizer(userinfo, ",");
				int i = 0;
				while (st.hasMoreTokens()) {
					String info = st.nextToken();

					switch (i) {
					case 0:
						userId = info;
						break;
					case 1:
						userPwd = info;
						break;
					case 2:
						userName = info;
						break;
					case 3:
						userPhone = info;
						break;
					case 4:
						userAge = Integer.valueOf(info);
						break;
					case 5:
						userGender = info.charAt(0);
						break;
					case 6:
						userType = info.charAt(0);
						break;
					}
					i++;
				}

				i = 0;
				User mem = new User(userId, userPwd, userName, userPhone, userAge, userGender, userType);
				writeUser(mem);
				userinfo = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public boolean readFileUserType(String inputUserId, char inputUserType) {

		String userId = "";
		char userType = '\u0000';

		try {
			FileReader fr = new FileReader("sginupWriter.txt");
			BufferedReader br = new BufferedReader(fr);

			String userinfo = br.readLine();

			while (userinfo != null) {
				StringTokenizer st = new StringTokenizer(userinfo, ",");
				int i = 0;
				while (st.hasMoreTokens()) {
					String info = st.nextToken();

					switch (i) {
					case 0:
						userId = info;
						break;
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						userType = info.charAt(0);
						break;
					}
					i++;
				}

				i = 0;
				userinfo = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (userId.equals(inputUserId) && userType == inputUserType) {
			return true;
		} else {
			return false;
		}

	}

}
