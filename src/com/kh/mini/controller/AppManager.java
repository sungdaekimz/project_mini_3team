package com.kh.mini.controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import com.kh.mini.model.dao.FoodDao;
import com.kh.mini.model.dao.StoreDao;
import com.kh.mini.model.vo.Food;
import com.kh.mini.model.vo.Store;
import com.kh.mini.model.vo.StoreReview;
import com.kh.mini.view.AppMenu;

public class AppManager extends JFrame {

	private StoreDao sd = new StoreDao();
	private FoodDao fd = new FoodDao();
	private Scanner sc = new Scanner(System.in);
	private Store store = new Store();
	// private static ArrayList<Store> list = new ArrayList<Store>();
	private static String sName = "";
	private static double star = 0;
	private static int lastVisit;
	private static int reviewCount;

	public AppManager() {
		// TODO Auto-generated constructor stub
	}

	/*public void addMenu(Store store) {
		// 로그인 정보에 따라 가게 이름을 가져온다.
		// (store 배열리스트에서 점주 이름 검색 -> 가게 객체 찾고 -> 가게 이름 가져오기)
		String storeName = store.getStoreName();

		// 가게의 메뉴 전체 출력
		// (가게 이름 가져온걸로 food 배열리스트에서 메뉴 찾기?)
		// Store 라는 클래스가 Food를 상속 or implements 하는 게 좋을듯
		System.out.println("******* MENU *******");
		Iterator it = fd.displayAllList(storeName).iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println("추가할 메뉴 이름 : ");
		String foodName = sc.nextLine();
		System.out.println("추가할 메뉴 가격 : ");
		int foodPrice = sc.nextInt();
		sc.nextLine();

		fd.writeFood(new Food(storeName, fd.getLastFoodNo() + 1, foodName, foodPrice));

		System.out.println("메뉴 추가가 완료되었습니다.");

	}

	public void deleteMenu(Store store) {
		// 로그인 정보에 따라 가게 이름을 가져온다.
		String storeName = store.getStoreName();

		// 가게의 메뉴 전체 출력
		System.out.println("******* MENU *******");
		Iterator it = fd.displayAllList().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println("삭제할 메뉴 번호 : ");
		int no = sc.nextInt();
		sc.nextLine();

		Food food = fd.displayFood(no);
		if (food == null) {
			System.out.println("해당하는 메뉴가 없습니다.");
		} else {
			System.out.println(food);
			System.out.println("정말로 삭제하시겠습니까? (y/n) : ");
			char answer = sc.nextLine().toUpperCase().charAt(0);

			if (answer == 'Y') {
				fd.deleteFood(no);
				System.out.println(no + "번 메뉴가 삭제되었습니다.");
			}
		}

	}

	public void settingOpen(Store store) {
		// 로그인 정보에 따라 가게 이름을 가져온다.
		String storeName = store.getStoreName();

		
		 * // 가게 정보 출력 System.out.println("******* STORE INFORMATION *******"); Iterator
		 * it = sd.displayStore(storeName).iterator(); while (it.hasNext()) {
		 * System.out.println(it.next()); }
		 

		// 현재 온/오프 여부 출력
		String isStoreOpen = "";
		if (store.isStoreOpen() == true) {
			isStoreOpen = "Open";
		} else {
			isStoreOpen = "Close";
		}

		System.out.println("가게의 현재 예약 설정은 " + isStoreOpen + " 입니다.");
		System.out.println("설정을 변경하시겠습니까? (y/n) : ");
		char answer = sc.nextLine().toUpperCase().charAt(0);

		if (store.isStoreOpen() == true) {
			if (answer == 'Y') {
				store.setStoreOpen(false);
				System.out.println("설정 변경이 완료되었습니다.");
			}
		} else {
			if (answer == 'N') {
				store.setStoreOpen(true);
				System.out.println("설정 변경이 완료되었습니다.");
			}
		}

	}*/

	public void createReview(String storeName) {

		setTitle("후기페이지");
		setSize(450, 600);
		setResizable(false);
		setLocationRelativeTo(null);

		Container c = getContentPane();
		c.setLayout(null);

		try {
			this.setIconImage(ImageIO.read(new File("image/배고프조로고.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Font font = new Font("", Font.BOLD, 15);
		JLabel lb1 = new JLabel("=========== 별점을 입력하세요 ===========");
		lb1.setFont(font);
		JLabel lb2 = new JLabel("=========== 후기를 입력하세요 ===========");
		lb2.setFont(font);

		JTextArea ta = new JTextArea(10, 20);
		ta.setLineWrap(true); // 자동 줄바꿈
		ta.setWrapStyleWord(true); // 단어 줄바꿈

		JButton btn1 = new JButton("취소");
		JButton btn2 = new JButton("등록");
		btn1.setBackground(Color.GRAY);
		btn2.setBackground(Color.GRAY);
		btn1.setForeground(Color.WHITE);
		btn2.setForeground(Color.WHITE);

		lb1.setBounds(50, 30, 340, 100);
		lb2.setBounds(50, 150, 340, 100);
		ta.setBounds(50, 220, 340, 200);
		btn1.setBounds(100, 450, 100, 30);
		btn2.setBounds(250, 450, 100, 30);

		ButtonGroup radioGroup = new ButtonGroup();
		JRadioButton r1 = new JRadioButton("5");
		JRadioButton r2 = new JRadioButton("4");
		JRadioButton r3 = new JRadioButton("3");
		JRadioButton r4 = new JRadioButton("2");
		JRadioButton r5 = new JRadioButton("1");
		radioGroup.add(r1);
		radioGroup.add(r2);
		radioGroup.add(r3);
		radioGroup.add(r4);
		radioGroup.add(r5);

		r1.setBounds(50, 130, 50, 20);
		r2.setBounds(120, 130, 50, 20);
		r3.setBounds(190, 130, 50, 20);
		r4.setBounds(260, 130, 50, 20);
		r5.setBounds(330, 130, 50, 20);

		c.add(lb1);
		c.add(r1);
		c.add(r2);
		c.add(r3);
		c.add(r4);
		c.add(r5);

		c.add(lb2);
		c.add(ta);
		c.add(btn1);
		c.add(btn2);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 식사여부 확인
		ArrayList<Store> searchStore = new ArrayList<Store>();
		ArrayList<Store> list = sd.displayAllList();

		// list일떄 검색한 가게명이 포함되면 sName에 getStoreName() 넣기
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getStoreName().contains(storeName)) {

				searchStore.add(list.get(i));
				for (int j = 0; j < searchStore.size(); j++) {
					sName = searchStore.get(0).getStoreName().toString();
					lastVisit = searchStore.get(0).getVisitCount();
					reviewCount = sd.getLastReviewCount(sName);
				}

				int ans1 = JOptionPane.showConfirmDialog(null, sName + "에 방문하셨나요?", "방문확인", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);

				if (ans1 == JOptionPane.YES_OPTION) {

					for (int j = 0; j < list.size(); j++) {
						if (list.get(j).getStoreName().equals(sName) && list.get(j).getVisitCount() == 0) { // 수정했음

							JOptionPane.showMessageDialog(null, sName + " 방문내역이 없습니다.\n다른 음식점을 이용하신 경우 이름을 다시 확인해주세요!");
							setVisible(false);
							new AppMenu();
							return;
						} else if (list.get(j).getStoreName().equals(sName) && reviewCount == lastVisit) {
							JOptionPane.showMessageDialog(null, sName + " 방문 후 이미 모든 후기를 작성했습니다.");
							setVisible(false);
							new AppMenu();
							return;
						} else {
							continue;
						}
					}

					int ans2 = JOptionPane.showConfirmDialog(null, "후기를 작성하시겠습니까?", "작성 여부 확인",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (ans2 == JOptionPane.YES_OPTION) {

						r1.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								int rStar = 5;
								star = rStar;

							}
						});
						r2.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								int rStar = 4;
								star = rStar;
							}
						});
						r3.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								int rStar = 3;
								star = rStar;
							}
						});
						r4.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								int rStar = 2;
								star = rStar;
							}
						});
						r5.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								int rStar = 1;
								star = rStar;
							}
						});
						btn1.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								int ans3 = JOptionPane.showConfirmDialog(null, "후기작성을 취소하시나요?", "작성 취소",
										JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

								if (ans3 == JOptionPane.YES_OPTION) {
									JOptionPane.showMessageDialog(null, "후기작성이 취소되었습니다.");
									star = 0;
									setVisible(false);
									new AppMenu();
									return;
								} else if (ans3 == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "다시작성해주세요");
								}
							}
						});
						btn2.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								String text = ta.getText();
								Date today = new Date();
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd(E)");
								String review = text;

								// ******

								if (star == 0 && review.isEmpty()) {
									JOptionPane.showMessageDialog(null, "별점과 후기를 남겨주세요");
									return;
								} else if (star == 0 && !review.isEmpty()) {
									JOptionPane.showMessageDialog(null, "별점을 남겨주세요");
									return;
								} else if (star != 0 && review.isEmpty()) {
									JOptionPane.showMessageDialog(null, "후기를 남겨주세요");
									return;
								} else {
									sd.addStoreStar(sName, star);

									int ans = JOptionPane.showConfirmDialog(null,
											"[==내용을 확인해주세요.==]\n" + "별점: " + star + "\n" + "작성일: " + sdf.format(today)
													+ "\n" + "후기: " + review,
											"확인", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
									if (ans == JOptionPane.YES_OPTION) {

										reviewCount++;
										sd.addReview(
												new StoreReview(sName, star, review, reviewCount, sdf.format(today)));
										JOptionPane.showMessageDialog(null, "소중한 후기 감사합니다~!");
										setVisible(false);
										new AppMenu();
										System.out.println(sd.displayAllReviewList());
										return;

									} else if (ans == JOptionPane.NO_OPTION) {
										return;
									}
								}

							}

						});

					} else if (ans2 == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "후기작성이 취소되었습니다.");
						this.setVisible(false);
						new AppMenu();
						return;
					}
				} else if (ans1 == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "메인페이지로 돌아갑니다.");

					this.setVisible(false);
					new AppMenu();
					return;
				}
			}

		}

	}

}
