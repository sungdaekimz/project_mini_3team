package com.kh.mini.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.controller.AppManager;
import com.kh.mini.model.dao.StoreDao;
import com.kh.mini.model.dao.UserDao;
import com.kh.mini.model.vo.StoreReview;
import com.kh.mini.model.vo.User;

public class MyPageSwing extends JFrame {

	Scanner sc = new Scanner(System.in);
	private AppManager am = new AppManager();
	private StoreDao sd = new StoreDao();

	JLabel label, label2, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11, lb12, lb13, lb14;
	JButton btn1;

	public void myMain() {

		setTitle("마이페이지");
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

		JButton mb1 = new JButton("회원 정보 조회");
		mb1.setBounds(85, 100, 270, 50);
		mb1.setBackground(Color.GRAY);
		
		JButton mb2 = new JButton("나의 후기 조회");
		mb2.setBounds(85, 180, 270, 50);
		mb2.setBackground(Color.GRAY);
		
		mb1.setForeground(Color.white);
		mb2.setForeground(Color.white);

		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		mb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MyInfo().myInfo();
				return;

			}
		});
		mb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ReviewCollect().reviewCollect();
				return;

			}
		});

		c.add(mb1);
		c.add(mb2);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}

class MyInfo extends JFrame {

	JLabel label, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11, lb12, lb13, lb14, label2;
	JButton btn1;

	public void myInfo() {

		User u = new User();
		UserDao ud = new UserDao();
		ArrayList<User> loginList = new ArrayList<User>();

		setTitle("마이페이지");
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

		Font font = new Font("", Font.BOLD, 25);
		label = new JLabel("회원 정보");
		label.setFont(font);
		label.setBounds(165, 35, 450, 50);

		Image icon = new ImageIcon("image/마이페이지.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		label2 = new JLabel(new ImageIcon(icon));
		label2.setBounds(145, 60, 150, 150);

		lb1 = new JLabel("회원 아이디");
		lb1.setBounds(40, 200, 110, 25);
		lb8 = new JLabel("     " + ud.displayLoginUser().getUserId());
		lb8.setBounds(140, 200, 250, 25);
		lb8.setOpaque(true);
		lb8.setBackground(Color.lightGray);

		lb2 = new JLabel("비밀번호");
		lb2.setBounds(40, 240, 110, 25);
		lb9 = new JLabel("     " + ud.displayLoginUser().getUserPwd());
		lb9.setBounds(140, 240, 250, 25);
		lb9.setOpaque(true);
		lb9.setBackground(Color.lightGray);

		// System.out.println("이름 : ");
		lb3 = new JLabel("이름");
		lb3.setBounds(40, 280, 110, 25);
		// System.out.println(u.getUserName());
		lb10 = new JLabel("     " + ud.displayLoginUser().getUserName());
		lb10.setBounds(140, 280, 250, 25);
		lb10.setOpaque(true);
		lb10.setBackground(Color.lightGray);

		// System.out.println("나이 : ");
		lb4 = new JLabel("나이");
		lb4.setBounds(40, 320, 110, 25);
		// System.out.println(u.getUserAge());
		lb11 = new JLabel(String.valueOf("     " + ud.displayLoginUser().getUserAge()));
		lb11.setBounds(140, 320, 250, 25);
		lb11.setOpaque(true);
		lb11.setBackground(Color.lightGray);

		// System.out.println("성별 : ");
		lb5 = new JLabel("성별");
		lb5.setBounds(40, 360, 110, 25);
		System.out.println(u.getUserGender());
		lb12 = new JLabel(String.valueOf("     " + ud.displayLoginUser().getUserGender()));
		lb12.setBounds(140, 360, 250, 25);
		lb12.setOpaque(true);
		lb12.setBackground(Color.lightGray);

		// System.out.println("휴대전화 : ");
		lb6 = new JLabel("휴대전화");
		lb6.setBounds(40, 400, 110, 25);
		// System.out.println(u.getUserPhone());
		lb13 = new JLabel("     " + ud.displayLoginUser().getUserPhone());
		lb13.setBounds(140, 400, 250, 25);
		lb13.setOpaque(true);
		lb13.setBackground(Color.lightGray);

		// System.out.println("권한 : ");
		lb7 = new JLabel("권한");
		lb7.setBounds(40, 440, 110, 25);
		// System.out.println(u.getUserType());
		lb14 = new JLabel(String.valueOf("     " + ud.displayLoginUser().getUserType()));
		lb14.setBounds(140, 440, 250, 25);
		lb14.setOpaque(true);
		lb14.setBackground(Color.lightGray);

		btn1 = new JButton("홈");
		btn1.setBounds(170, 490, 100, 30);
		btn1.setBackground(Color.gray);
		btn1.setForeground(Color.white);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new AppMenu();
				return;

			}

		});

		c.add(label);
		c.add(label2);
		c.add(lb1);
		c.add(lb2);
		c.add(lb3);
		c.add(lb4);
		c.add(lb5);
		c.add(lb6);
		c.add(lb7);
		c.add(lb8);
		c.add(lb9);
		c.add(lb10);
		c.add(lb11);
		c.add(lb12);
		c.add(lb13);
		c.add(lb14);
		c.add(btn1);

		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}

class ReviewCollect extends JFrame {
	JLabel l1, label;
	JButton b1, b2, b3;

	private StoreDao sd = new StoreDao();
	// 전체 후기 조회
	public void reviewCollect() {

		setTitle("나의 후기");
		setSize(450, 600);
		setResizable(false);
		setLocationRelativeTo(null);

		Container c = getContentPane();
		c.setLayout(null);

		Font font = new Font("", Font.BOLD, 25);
		label = new JLabel("후기 조회");
		label.setFont(font);
		label.setBounds(165, 35, 450, 50);

		b2 = new JButton("홈");
		b2.setBounds(170, 490, 100, 30);
		b2.setBackground(Color.gray);
		b2.setForeground(Color.white);

		JLabel lb1 = new JLabel("가게이름");
		JLabel lb2 = new JLabel("방문일");
		JLabel lb3 = new JLabel("별점");
		JLabel lb4 = new JLabel("후기");
		
		lb1.setBounds(60, 150, 90, 20);
		lb2.setBounds(150, 150, 90, 20);
		lb3.setBounds(250, 150, 90, 20);
		lb4.setBounds(340, 150, 90, 20);
		
		
		String col[] = { "가게이름", "방문일", "별점", "후기" };

		Object rowData[][];

		ArrayList<StoreReview> rList = sd.displayAllReviewList();
		rowData = new Object[rList.size()][4];

		
		
		for (int i = 0; i < rList.size(); i++) {
			rowData[i][0] = rList.get(i).getStoreName();
			rowData[i][1] = rList.get(i).getReviewDate();
			rowData[i][2] = rList.get(i).getStoreGrade();
			rowData[i][3] = rList.get(i).getStoreReview();

		}
		DefaultTableModel model = new DefaultTableModel(rowData, col);
		JTable table = new JTable(model);
		table.setBounds(40, 170, 360, 300);

		c.add(label);
		c.add(b2);
		c.add(lb1);
		c.add(lb2);
		c.add(lb3);
		c.add(lb4);
		c.add(table);

		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				new AppMenu();
				return;
			}

		});

	}

}
