package com.kh.mini.swing.reservtion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.mini.model.dao.StoreDao;
import com.kh.mini.model.dao.UserDao;
import com.kh.mini.model.vo.Store;

public class MenuCategory implements ActionListener {
	UserDao ud = new UserDao();
	StoreDao sd = new StoreDao();
	JFrame frm;
	JLabel label, label1, label2;
	JButton btn1;
	JButton[] btnArr;

	public void Korean() {
		frm = new JFrame("한식");
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
		
		int y = 20;
		btnArr = new JButton[sd.searchStore("한식").size()];
		for (int i=0; i<sd.searchStore("한식").size(); i++) {
			Store store = sd.displayStore(sd.searchStore("한식").get(i).getStoreName());
			String isStoreOpen = "";
			if (store.isStoreOpen() == true) {
				isStoreOpen = "Open";
			} else {
				isStoreOpen = "Close";
			}
			
			label = new JLabel();
			label.setBorder(new TitledBorder(new LineBorder(Color.gray)));
			label.setBounds(20, y, 400, 100);
			frm.getContentPane().add(label);
			
			label1 = new JLabel();
			label1.setBounds(20, y, 250, 100);
			label1.setText(
					"<HTML><body><center> <br>" + store.getStoreAddr() +
					"<br>Tel " + store.getStoreCall() + "</center></body></HTML>");
			label1.setHorizontalAlignment(JLabel.CENTER);
			frm.getContentPane().add(label1);
			
			Font f1 = new Font("돋움", Font.BOLD, 18);
			label2 = new JLabel(store.getStoreName());
			label2.setBounds(20, y, 250, 50);
			label2.setFont(f1);
			label2.setHorizontalAlignment(JLabel.CENTER);
			frm.getContentPane().add(label2);
			
			Font f2 = new Font("Serif", Font.BOLD, 20);
			btnArr[i] = new JButton(isStoreOpen);
			btnArr[i].setBounds(300, y+20, 100, 50);
			btnArr[i].setFont(f2);
			frm.getContentPane().add(btnArr[i]);
			
			y += 120;
			
			btnArr[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					sd.writeReserveStore(store);
					System.out.println("선택한 가게 : " + sd.displayReserveList().toString());
					new Reserve();
					frm.setVisible(false);
					return;
				}
			});
			
		}

		frm.setVisible(true);
		
	}

	public void Western() {
		frm = new JFrame("양식");
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
		
		int y = 20;
		btnArr = new JButton[sd.searchStore("양식").size()];
		for (int i=0; i<sd.searchStore("양식").size(); i++) {
			Store store = sd.displayStore(sd.searchStore("양식").get(i).getStoreName());
			String isStoreOpen = "";
			if (store.isStoreOpen() == true) {
				isStoreOpen = "Open";
			} else {
				isStoreOpen = "Close";
			}
			
			label = new JLabel();
			label.setBorder(new TitledBorder(new LineBorder(Color.gray)));
			label.setBounds(20, y, 400, 100);
			frm.getContentPane().add(label);
			
			label1 = new JLabel();
			label1.setBounds(20, y, 250, 100);
			label1.setText(
					"<HTML><body><center> <br>" + store.getStoreAddr() +
					"<br>Tel " + store.getStoreCall() + "</center></body></HTML>");
			label1.setHorizontalAlignment(JLabel.CENTER);
			frm.getContentPane().add(label1);
			
			Font f1 = new Font("돋움", Font.BOLD, 18);
			label2 = new JLabel(store.getStoreName());
			label2.setBounds(20, y, 250, 50);
			label2.setFont(f1);
			label2.setHorizontalAlignment(JLabel.CENTER);
			frm.getContentPane().add(label2);
			
			Font f2 = new Font("Serif", Font.BOLD, 20);
			btnArr[i] = new JButton(isStoreOpen);
			btnArr[i].setBounds(300, y+20, 100, 50);
			btnArr[i].setFont(f2);
			frm.getContentPane().add(btnArr[i]);
			
			y += 120;
			
			btnArr[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					sd.writeReserveStore(store);
					System.out.println("선택한 가게 : " + sd.displayReserveList().toString());
					new Reserve();
					frm.setVisible(false);
					return;
				}
			});
			
		}

		frm.setVisible(true);
		
	}

	public void Chinese() {
		frm = new JFrame("중식");
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
		
		int y = 20;
		btnArr = new JButton[sd.searchStore("중식").size()];
		for (int i=0; i<sd.searchStore("중식").size(); i++) {
			Store store = sd.displayStore(sd.searchStore("중식").get(i).getStoreName());
			String isStoreOpen = "";
			if (store.isStoreOpen() == true) {
				isStoreOpen = "Open";
			} else {
				isStoreOpen = "Close";
			}
			
			label = new JLabel();
			label.setBorder(new TitledBorder(new LineBorder(Color.gray)));
			label.setBounds(20, y, 400, 100);
			frm.getContentPane().add(label);
			
			label1 = new JLabel();
			label1.setBounds(20, y, 250, 100);
			label1.setText(
					"<HTML><body><center> <br>" + store.getStoreAddr() +
					"<br>Tel " + store.getStoreCall() + "</center></body></HTML>");
			label1.setHorizontalAlignment(JLabel.CENTER);
			frm.getContentPane().add(label1);
			
			Font f1 = new Font("돋움", Font.BOLD, 18);
			label2 = new JLabel(store.getStoreName());
			label2.setBounds(20, y, 250, 50);
			label2.setFont(f1);
			label2.setHorizontalAlignment(JLabel.CENTER);
			frm.getContentPane().add(label2);
			
			Font f2 = new Font("Serif", Font.BOLD, 20);
			btnArr[i] = new JButton(isStoreOpen);
			btnArr[i].setBounds(300, y+20, 100, 50);
			btnArr[i].setFont(f2);
			frm.getContentPane().add(btnArr[i]);
			
			y += 120;
			
			btnArr[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					sd.writeReserveStore(store);
					System.out.println("선택한 가게 : " + sd.displayReserveList().toString());
					new Reserve();
					frm.setVisible(false);
					return;
				}
			});
			
		}

		frm.setVisible(true);
		
	}
	
	public void Japanese() {
		frm = new JFrame("일식");
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
		
		int y = 20;
		btnArr = new JButton[sd.searchStore("일식").size()];
		for (int i=0; i<sd.searchStore("일식").size(); i++) {
			Store store = sd.displayStore(sd.searchStore("일식").get(i).getStoreName());
			String isStoreOpen = "";
			if (store.isStoreOpen() == true) {
				isStoreOpen = "Open";
			} else {
				isStoreOpen = "Close";
			}
			
			label = new JLabel();
			label.setBorder(new TitledBorder(new LineBorder(Color.gray)));
			label.setBounds(20, y, 400, 100);
			frm.getContentPane().add(label);
			
			label1 = new JLabel();
			label1.setBounds(20, y, 250, 100);
			label1.setText(
					"<HTML><body><center> <br>" + store.getStoreAddr() +
					"<br>Tel " + store.getStoreCall() + "</center></body></HTML>");
			label1.setHorizontalAlignment(JLabel.CENTER);
			frm.getContentPane().add(label1);
			
			Font f1 = new Font("돋움", Font.BOLD, 18);
			label2 = new JLabel(store.getStoreName());
			label2.setBounds(20, y, 250, 50);
			label2.setFont(f1);
			label2.setHorizontalAlignment(JLabel.CENTER);
			frm.getContentPane().add(label2);
			
			Font f2 = new Font("Serif", Font.BOLD, 20);
			btnArr[i] = new JButton(isStoreOpen);
			btnArr[i].setBounds(300, y+20, 100, 50);
			btnArr[i].setFont(f2);
			frm.getContentPane().add(btnArr[i]);
			
			y += 120;
			
			btnArr[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					sd.writeReserveStore(store);
					System.out.println("선택한 가게 : " + sd.displayReserveList().toString());
					new Reserve();
					frm.setVisible(false);
					return;
				}
			});
			
		}

		frm.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
