package com.kh.mini.swing.reservtion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import com.kh.mini.model.dao.FoodDao;
import com.kh.mini.model.dao.StoreDao;
import com.kh.mini.model.vo.Store;
import com.kh.mini.view.AppMenu;

public class Reserve implements ActionListener {
	JFrame frm;
	JCheckBox f, t;
	JLabel time, numPeople, menu, name;
	JButton btn1, btn2;
	StoreDao sd = new StoreDao();
	FoodDao fd = new FoodDao();

	public Reserve() {
		frm = new JFrame("방문 및 포장 예약");
		frm.setSize(450, 650);
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.getContentPane().setLayout(null);

		try {
			frm.setIconImage(ImageIO.read(new File("image/배고프조로고.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Store store = sd.displayReserveList().get(0);

		Font f1 = new Font("돋움", Font.BOLD, 20);
		Font f2 = new Font("Serif", Font.BOLD, 36);
		Font f3 = new Font("돋움", Font.BOLD, 15);

		JLabel main = new JLabel();
		main = new JLabel(store.getStoreName());
		main.setBounds(-10, 30, 450, 40);
		main.setFont(f2);
		main.setHorizontalAlignment(JLabel.CENTER);
		frm.getContentPane().add(main);

		JLabel menu = new JLabel();
		menu = new JLabel();
		String menuStr = "";
		int j = 1;
		Iterator it = fd.displayAllList(store.getStoreName()).iterator();
		while (it.hasNext()) {
			menuStr += (j++) + ". ";
			menuStr += it.next().toString();
			menuStr += "<br>";
		}

		menu.setText("<HTML><body><center>Menu <br>" + menuStr + "</center></body></HTML>");

		menu.setBounds(-10, 80, 450, 200);
		menu.setFont(new Font("Serif", Font.BOLD, 20));
		menu.setHorizontalAlignment(JLabel.CENTER);
		frm.getContentPane().add(menu);

		f = new JCheckBox("매장 식사");
		f.setBounds(100, 270, 80, 30);
		t = new JCheckBox("방문 포장");
		t.setBounds(220, 270, 80, 30);
		frm.getContentPane().add(f);
		frm.getContentPane().add(t);

		time = new JLabel("예약 시간 :");
		time.setBounds(80, 310, 100, 30);
		time.setFont(f3);
		frm.getContentPane().add(time);

		String[] time1 = { "12:00", "13:00", "14:00", "15:00", "18:00", "17:00" };
		JComboBox timeCombo = new JComboBox(time1);
		timeCombo.setBounds(180, 310, 160, 30);
		frm.getContentPane().add(timeCombo);

		numPeople = new JLabel("인원 수 :");
		numPeople.setBounds(80, 350, 100, 30);
		numPeople.setFont(f3);
		frm.getContentPane().add(numPeople);

		String[] num = { "1명", "2명", "3명", "4명", "5명 이상", "미정" };
		JComboBox numCombo = new JComboBox(num);
		numCombo.setBounds(180, 350, 160, 30);
		frm.getContentPane().add(numCombo);

		int i = 0;
		String[] menu1 = new String[fd.displayAllList(store.getStoreName()).size()];
		it = fd.displayAllList(store.getStoreName()).iterator();
		while (it.hasNext()) {
			menuStr = (i + 1) + ". " + it.next().toString();
			menu1[i++] = menuStr;
		}

		menu = new JLabel("메뉴 :");
		menu.setBounds(80, 390, 100, 30);
		menu.setFont(f3);
		frm.getContentPane().add(menu);

		// String[] menu1 = { menuStr };
		JComboBox menuList = new JComboBox(menu1);
		menuList.setBounds(180, 390, 160, 30);
		frm.getContentPane().add(menuList);

		name = new JLabel("예약자 이름 :");
		name.setBounds(80, 430, 100, 30);
		name.setFont(f3);
		frm.getContentPane().add(name);

		JTextField txt = new JTextField();
		txt.setBounds(180, 430, 160, 30);
		frm.getContentPane().add(txt);

		btn1 = new JButton("예약");
		btn2 = new JButton("취소");

		btn1.setBounds(60, 480, 130, 45);
		btn2.setBounds(240, 480, 130, 45);

		btn1.setBackground(Color.LIGHT_GRAY);
		btn2.setBackground(Color.LIGHT_GRAY);
		btn1.setFont(f1);
		btn2.setFont(f1);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		frm.getContentPane().add(btn1);
		frm.getContentPane().add(btn2);

		frm.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btn1) {
			sd.clearReserveList();
			ClickButton_reserve(arg0);
			Store store = sd.displayReserveList().get(0);
			store.setVisitCount(store.getVisitCount()+1);
			frm.setVisible(false);
			new AppMenu();
			return;
		}

		if (arg0.getSource() == btn2) {

			sd.clearReserveList();
			new SelectStore();

			frm.setVisible(false);
			new AppMenu();
			return;
		}

	}

	private void ClickButton_reserve(ActionEvent arg0) {

		JOptionPane.showMessageDialog(null, "예약을 완료하였습니다.");
	}

}
