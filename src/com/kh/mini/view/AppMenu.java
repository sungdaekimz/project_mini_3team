package com.kh.mini.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.mini.controller.AppManager;
import com.kh.mini.model.dao.StoreDao;
import com.kh.mini.model.dao.UserDao;
import com.kh.mini.model.vo.Store;
import com.kh.mini.swing.reservtion.SelectStore;

//AppMemu extends JFrame

public class AppMenu extends JFrame {

	JPanel panel;
	JLabel lb;
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn0;

	private Scanner sc = new Scanner(System.in);
	private AppManager am = new AppManager();
	private StoreDao sd = new StoreDao();
	private UserDao ud = new UserDao();

	public AppMenu() {

		this.setTitle("메인 페이지");
		this.setSize(450, 600);
		setResizable(false);
		this.setLocationRelativeTo(null);

		panel = new JPanel(null);

		try {
			this.setIconImage(ImageIO.read(new File("image/배고프조로고.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image icon = new ImageIcon("image/배고프조로고.png").getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		lb = new JLabel(new ImageIcon(icon));
		lb.setBounds(95, 0, 250, 150);

		btn1 = new JButton("전체 매장 조회");
		btn2 = new JButton("인기 매장 조회");
		btn3 = new JButton("예약하기");
		btn4 = new JButton("후기 작성");
		btn5 = new JButton("마이 페이지");
		btn6 = new JButton("사장님 페이지");
		btn7 = new JButton("관리자 페이지");
		btn0 = new JButton("종료하기");

		btn1.setBounds(80, 160, 120, 80);
		btn2.setBounds(240, 160, 120, 80);
		btn3.setBounds(80, 250, 120, 80);
		btn4.setBounds(240, 250, 120, 80);
		btn5.setBounds(80, 340, 120, 80);
		btn6.setBounds(240, 340, 120, 80);
		btn7.setBounds(80, 430, 120, 80);
		btn0.setBounds(240, 430, 120, 80);

		btn1.setBackground(Color.gray);
		btn2.setBackground(Color.gray);
		btn3.setBackground(Color.gray);
		btn4.setBackground(Color.gray);
		btn5.setBackground(Color.gray);
		btn6.setBackground(Color.gray);
		btn7.setBackground(Color.gray);
		btn0.setBackground(Color.gray);

		btn1.setForeground(Color.white);
		btn2.setForeground(Color.white);
		btn3.setForeground(Color.white);
		btn4.setForeground(Color.white);
		btn5.setForeground(Color.white);
		btn6.setForeground(Color.white);
		btn7.setForeground(Color.white);
		btn0.setForeground(Color.white);

		panel.add(lb);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(btn7);
		panel.add(btn0);

		// 이벤트 부분
		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				displayStore_name();
			}

		});
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				displayStore_grade();
			}

		});
		
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seletStore();
			}

		});

		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String storeName = null;
				storeName = JOptionPane.showInputDialog(null, "방문하신 가게 이름을 적어주세요", "일부작성 가능");

				// JOptionPane.showMessageDialog(null, storeName+"에 방문하셨나요?");
				if (storeName == null) {
					return;
				}
				ArrayList<Store> list = sd.displayAllList();
				ArrayList<Store> check = new ArrayList<Store>();
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).getStoreName().contains(storeName)) {
						check.add(list.get(i));
					}
				}
				if(check.isEmpty()) {
					JOptionPane.showMessageDialog(null,"일치하는 가게가 없습니다.");
					return;
				}
				
				setVisible(false);
				am.createReview(storeName);
			}

		});

		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MyPageSwing().myMain();
			}

		});

		btn6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (ud.displayLoginUser().getUserType() == 'P') {
					ownerSubMenu();
				} else {
					JOptionPane.showMessageDialog(getParent(), "사장님 회원만 접근할 수 있습니다.", "접근 경고", JOptionPane.WARNING_MESSAGE);
				}
				
			}

		});
		
		btn7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (ud.displayLoginUser().getUserType() == 'A') {
					adminSubMenu();
				} else {
					JOptionPane.showMessageDialog(getParent(), "관리자만 접근할 수 있습니다.", "접근 경고", JOptionPane.WARNING_MESSAGE);
				}
				
			}

		});
		
		btn0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		this.add(panel);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}	
	
	private void displayStore_name() {
		this.setVisible(false);
		new DisplayStore_name();
		return;
	}
	
	private void displayStore_grade() {
		this.setVisible(false);
		new DisplayStore_grade();
		return;
	}
	
	protected void seletStore() {
		this.setVisible(false);
		new SelectStore();
		return;
	}

	private void ownerSubMenu() {
		this.setVisible(false);
		new OwnerSubMenu();
		return;
		// 사장님 페이지로 패널 전환
		/*
		 * this.remove(panel); this.panel = new OwnerSubMenu(); this.add(panel);
		 * this.revalidate(); this.repaint();
		 */

	}
	
	private void adminSubMenu() {
		this.setVisible(false);
		new AdminSubMenu();
		return;
		
	}
}