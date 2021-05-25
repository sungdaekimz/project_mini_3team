package com.kh.mini.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.mini.model.dao.StoreDao;
import com.kh.mini.model.vo.Food;
import com.kh.mini.model.vo.Store;

public class AdminSubMenu extends JFrame {

	JButton btn1, btn2, btn3;
	JPanel panel;
	

	public AdminSubMenu() {
		this.setTitle("관리자 페이지");
		this.setSize(450, 600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);

		panel = new JPanel(null);
		panel.setSize(450, 600);

		try {
			this.setIconImage(ImageIO.read(new File("image/배고프조로고.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		btn1 = new JButton("가게 추가하기");
		btn2 = new JButton("가게 삭제하기");
		btn3 = new JButton("이전 화면으로");

		btn1.setBounds(80, 60, 300, 120);
		btn2.setBounds(80, 200, 300, 120);
		btn3.setBounds(80, 340, 300, 120);

		btn1.setBackground(Color.gray);
		btn2.setBackground(Color.gray);
		btn3.setBackground(Color.gray);

		btn1.setForeground(Color.white);
		btn2.setForeground(Color.white);
		btn3.setForeground(Color.white);

		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);

		this.add(panel);

		// 이벤트 동작 부분

		btn1.addActionListener(new ActionListener() {

			// 가게추가
			@Override
			public void actionPerformed(ActionEvent e) {
				addStore();
			}

		});

		btn2.addActionListener(new ActionListener() {

			// 가게삭제
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteStore();
			}

		});

		btn3.addActionListener(new ActionListener() {

			// 메인화면으로 돌아가기
			@Override
			public void actionPerformed(ActionEvent e) {
				backmainPanel();
			}

		});

		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	// 패널 전환하기 -> 각 페이지로 넘어감

	protected void addStore() {
		this.setVisible(false);
		new AddStore();
		return;
	}

	protected void deleteStore() {
		this.setVisible(false);
		new DeleteStore();
		return;
	}

	protected void backmainPanel() {
		this.setVisible(false);
		new AppMenu();
		return;
	}

}

class DeleteStore extends JFrame {

	private static String sName = "";
	private StoreDao sd = new StoreDao();
	ArrayList<Store> store = sd.displayAllList();

	JLabel lb1;
	JTextField tf1;
	JButton btn1, btn2;

	public DeleteStore() {
		this.setTitle("가게 삭제하기");
		this.setSize(450, 600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);

		lb1 = new JLabel("삭제할 가게 이름 : ");
		tf1 = new JTextField();

		btn1 = new JButton("삭제하기");
		btn2 = new JButton("돌아가기");

		lb1.setBounds(80, 50, 120, 40);
		tf1.setBounds(200, 50, 160, 40);

		btn1.setBounds(80, 430, 120, 80);
		btn2.setBounds(230, 430, 120, 80);

		btn1.setBackground(Color.gray);
		btn2.setBackground(Color.gray);

		btn1.setForeground(Color.white);
		btn2.setForeground(Color.white);

		// 삭제하기 버튼
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String deleteName = tf1.getText();
				System.out.println("삭제할 가게 이름 : " + deleteName);
				int result = JOptionPane.showConfirmDialog(getParent(), "정말로 삭제하시겠습니까?", "삭제 확인",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

				 

				ArrayList<Store> searchStore = new ArrayList<Store>();
										
				for (int i = 0; i < store.size(); i++) {

					if (store.get(i).getStoreName().contains(deleteName)) {

						searchStore.add(store.get(i));
						for (int j = 0; j < searchStore.size(); j++) {
							sName = searchStore.get(0).getStoreName().toString();
						}
					}
				
				
				if (result == JOptionPane.YES_OPTION) {

					for (int j = 0; j < store.size(); j++) {
						if (store.get(j).getStoreName().equals(sName)) {

							sd.deleteStore_name(deleteName);
							JOptionPane.showMessageDialog(getParent(), deleteName + " 삭제되었습니다.");
							System.out.println(sd.displayAllList());
							return;
						}

						else {
							JOptionPane.showMessageDialog(getParent(), deleteName + " 삭제취소.");
							System.out.println("가게 삭제 취소");
							
						}
						return;
						
						
					}
				}

				else {
					JOptionPane.showMessageDialog(getParent(), deleteName + " 없는 가게입니다.");
					break;
				}

			}
				
			}
		});
		

		// 버튼2번 이벤트
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				backAdminSubMenu();
			}
		});

		this.add(lb1);
		this.add(tf1);
		this.add(btn1);
		this.add(btn2);
		this.setVisible(true);

	}

	protected void backAdminSubMenu() {
		this.setVisible(false);
		new AdminSubMenu();
		return;
		/*
		 * this.removeAll(); this.add(new AdminSubMenu()); this.revalidate();
		 * this.repaint();
		 */
	}
}

class AddStore extends JFrame {

	private StoreDao sd = new StoreDao();

	JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8;
	JButton btn1, btn2;

	public AddStore() {
		this.setTitle("가게 추가하기");
		this.setSize(450, 600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);

		lb1 = new JLabel("가게 번호 : ");
		lb2 = new JLabel("가게 이름 : ");
		lb3 = new JLabel("가게 주소 : ");
		lb4 = new JLabel("가게 전화번호 : ");
		lb5 = new JLabel("가게 종류 : ");
		lb6 = new JLabel("가게 오픈여부 : ");
		lb7 = new JLabel("사장님 이름 : ");
		// lb7 = new JLabel("가게 평점 : ");
		// lb8 = new JLabel("가게 방문 수 : ");

		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		tf6 = new JTextField();
		tf7 = new JTextField();
		// tf8 = new JTextField();

		btn1 = new JButton("추가하기");
		btn2 = new JButton("돌아가기");

		lb1.setBounds(80, 50, 120, 40);
		lb2.setBounds(80, 90, 120, 40);
		lb3.setBounds(80, 130, 120, 40);
		lb4.setBounds(80, 170, 120, 40);
		lb5.setBounds(80, 210, 120, 40);
		lb6.setBounds(80, 250, 120, 40);
		lb7.setBounds(80, 290, 120, 40);
		// lb8.setBounds(80, 330, 120, 40);

		tf1.setBounds(170, 50, 160, 40);
		tf2.setBounds(170, 90, 160, 40);
		tf3.setBounds(170, 130, 160, 40);
		tf4.setBounds(170, 170, 160, 40);
		tf5.setBounds(170, 210, 160, 40);
		tf6.setBounds(170, 250, 160, 40);
		tf7.setBounds(170, 290, 160, 40);
		// tf8.setBounds(170, 330, 160, 40);

		btn1.setBounds(80, 430, 120, 80);
		btn2.setBounds(230, 430, 120, 80);

		btn1.setBackground(Color.gray);
		btn2.setBackground(Color.gray);

		btn1.setForeground(Color.white);
		btn2.setForeground(Color.white);

		// 확인 버튼
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int storeNo = Integer.parseInt(tf1.getText());
				String storeName = tf2.getText();
				String storeAddr = tf3.getText();
				String storeCall = tf4.getText();
				String storeType = tf5.getText();
				boolean storeOpen = tf6.getText() != null;
				String ownerName = tf7.getText();
				// double storeGrade = Integer.parseInt(tf7.getText());
				// int visitCount = Integer.parseInt(tf8.getText());

				if (storeType.equals("양식") || storeType.equals("중식") || storeType.equals("일식")
						|| storeType.equals("한식")) {
					System.out.println("추가한 가게 이름 : " + storeName + ", 주소 : " + storeAddr + ", 번호 : " + storeCall
							+ ", 타입 : " + storeType);
					sd.writeStore(
							new Store(storeNo, storeName, storeAddr, storeCall, storeType, ownerName, storeOpen, 0, 0));
					System.out.println(sd.displayAllList());
					JOptionPane.showMessageDialog(getParent(), "가게 추가가 완료되었습니다.");
					return;
				} else {
					JOptionPane.showMessageDialog(getParent(), "가게 종류를 다시 입력하세요.");
				}

			}
		});

		// 뒤로가기 버튼
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				backAdminSubMenu();
			}
		});

		this.add(lb1);
		this.add(lb2);
		this.add(lb3);
		this.add(lb4);
		this.add(lb5);
		this.add(lb6);
		this.add(lb7);
		// this.add(lb8);

		this.add(tf1);
		this.add(tf2);
		this.add(tf3);
		this.add(tf4);
		this.add(tf5);
		this.add(tf6);
		this.add(tf7);
		// this.add(tf8);

		this.add(btn1);
		this.add(btn2);

		this.setVisible(true);

	}

	// 가게 추가, 삭제 메뉴로 돌아가기
	protected void backAdminSubMenu() {
		this.setVisible(false);
		new AdminSubMenu();
		return;
	}

}
