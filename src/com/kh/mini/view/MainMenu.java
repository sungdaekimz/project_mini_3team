package com.kh.mini.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.mini.controller.AppManager;

// 메인 페이지를 그리는 패널
public class MainMenu extends JPanel {

	JLabel lb;
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn0;

	private Scanner sc = new Scanner(System.in);
	private AppManager am = new AppManager();

	public MainMenu() {
		this.setSize(450, 600);
		this.setLayout(null);

		Image icon = new ImageIcon("images/logo/logo.png").getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
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

		this.add(lb);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(btn6);
		this.add(btn7);
		this.add(btn0);

		// 이벤트 부분
		btn4.addActionListener((e) -> {
			JOptionPane.showInputDialog(null, "방문하신 가게 이름을 적어주세요", "후기작성");
		});

		btn6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ownerSubMenu();
			}

		});

		this.setVisible(true);

	}

	// 사장님 페이지로 패널 전환
	private void ownerSubMenu() {
		this.removeAll();
		this.add(new OwnerSubMenu());
		this.revalidate();
		this.repaint();

	}

}
