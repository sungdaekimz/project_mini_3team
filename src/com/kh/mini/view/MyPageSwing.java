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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.controller.AppManager;
import com.kh.mini.model.dao.StoreDao;
import com.kh.mini.model.vo.StoreReview;
import com.kh.mini.model.vo.User;

public class MyPageSwing extends JFrame {

	Scanner sc = new Scanner(System.in);
	private AppManager am = new AppManager();
	private StoreDao sd = new StoreDao();

	JLabel label, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11, lb12, lb13, lb14, label2;
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
		
		JButton mb1= new JButton("회원정보");
		JButton mb2= new JButton("예약하기");
		
		mb1.setBounds(100, 200, 100, 50);
		mb2.setBounds(100, 300, 100, 50);
		
		
		
		c.add(mb1);
		c.add(mb2);
		
		
	}

	public void myInfo() {

		User u = new User();
		ArrayList<User> uList = new ArrayList<User>();

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
		lb8 = new JLabel(u.getUserId());
		lb8.setBounds(140, 200, 250, 25);
		lb8.setOpaque(true);
		lb8.setBackground(Color.lightGray);

		lb2 = new JLabel("비밀번호");
		lb2.setBounds(40, 240, 110, 25);
		lb9 = new JLabel(u.getUserPwd());
		lb9.setBounds(140, 240, 250, 25);
		lb9.setOpaque(true);
		lb9.setBackground(Color.lightGray);

		// System.out.println("이름 : ");
		lb3 = new JLabel("이름");
		lb3.setBounds(40, 280, 110, 25);
		// System.out.println(u.getUserName());
		lb10 = new JLabel(u.getUserName());
		lb10.setBounds(140, 280, 250, 25);
		lb10.setOpaque(true);
		lb10.setBackground(Color.lightGray);

		// System.out.println("나이 : ");
		lb4 = new JLabel("나이");
		lb4.setBounds(40, 320, 110, 25);
		// System.out.println(u.getUserAge());
		lb11 = new JLabel(String.valueOf(u.getUserAge()));
		lb11.setBounds(140, 320, 250, 25);
		lb11.setOpaque(true);
		lb11.setBackground(Color.lightGray);

		// System.out.println("성별 : ");
		lb5 = new JLabel("성별");
		lb5.setBounds(40, 360, 110, 25);
		System.out.println(u.getUserGender());
		lb12 = new JLabel(String.valueOf(u.getUserGender()));
		lb12.setBounds(140, 360, 250, 25);
		lb12.setOpaque(true);
		lb12.setBackground(Color.lightGray);

		// System.out.println("휴대전화 : ");
		lb6 = new JLabel("휴대전화");
		lb6.setBounds(40, 400, 110, 25);
		// System.out.println(u.getUserPhone());
		lb13 = new JLabel(u.getUserPhone());
		lb13.setBounds(140, 400, 250, 25);
		lb13.setOpaque(true);
		lb13.setBackground(Color.lightGray);

		// System.out.println("권한 : ");
		lb7 = new JLabel("권한");
		lb7.setBounds(40, 440, 110, 25);
		// System.out.println(u.getUserType());
		lb14 = new JLabel(String.valueOf(u.getUserType()));
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

	JLabel l1;
	JButton b1, b2, b3;

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

		b1 = new JButton("검색");
		b1.setBounds(300, 100, 100, 30);
		b1.setBackground(Color.gray);
		b1.setForeground(Color.white);

		b2 = new JButton("홈");
		b2.setBounds(170, 490, 100, 30);
		b2.setBackground(Color.gray);
		b2.setForeground(Color.white);
		
		
		String col[] = {"가게", "별점", "후기"};
		
		Object rowData[][];
		ArrayList<StoreReview> rList = sd.displayAllReviewList();
		rowData = new Object[rList.size()][10];
		
		
		for (int i = 0; i < rList.size(); i++) {
			rowData[i][0] = rList.get(i).getStoreName();
				
			rowData[i][1] = rList.get(i).getStoreReview();
			
		}
		DefaultTableModel model =  new DefaultTableModel(rowData, col);;
		JTable table = new JTable(model);
		table.setBounds(40, 150, 360, 300);
		

		c.add(label);
		c.add(b1);
		c.add(b2);
		c.add(table);

		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new SearchReview().searchReview();
				return;
			}

		});


		
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				new AppMenu();
				return;
			}

		});

		// System.out.println("후기 전체 조회"); b1: 나의 후기

		

	}

}
class SearchReview extends JFrame{
	
	Scanner sc = new Scanner(System.in);
	private AppManager am = new AppManager();
	
	public void searchReview() {

		setTitle("후기 검색");
		setSize(450, 600);
		setResizable(false);
		setLocationRelativeTo(null);

		Container c1 = getContentPane();
		c1.setLayout(null);

		ArrayList<StoreReview> rList = new ArrayList<StoreReview>();

		
		Font font = new Font("", Font.BOLD, 20);
		JLabel l2 = new JLabel("가게 이름을 입력하세요.");
		l2.setFont(font);
		l2.setBounds(100, 100, 250, 30);
		
		JTextField tf = new JTextField();
		tf.setBounds(100, 150, 230, 30);
		
		JButton b4 = new JButton("검색");// 검색버튼
		b4.setBounds(160, 200, 100, 30);
		b4.setBackground(Color.gray);
		b4.setForeground(Color.white);

		

		System.out.println("가게 이름을 검색하세요");
		String sName = sc.nextLine();

		ArrayList<StoreReview> sList = new ArrayList<StoreReview>();

		for (int i = 0; i < sList.size(); i++) {
			if (rList.get(i).getStoreName().contains(tf.getText())) {
				sList.add(rList.get(i));
			}
		}

		String[] fl = new String[] { "번호", "가게", "후기" };
		DefaultTableModel model = new DefaultTableModel(fl, 0);

		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);

		if (sList.isEmpty()) {
			JLabel l3 = new JLabel("검색 결과가 없습니다.");
		} else {
			for (int i = 0; i < sList.size(); i++) {
				System.out.println(sList.get(i));
			}
		}

	
		c1.add(l2);
		c1.add(b4);
		c1.add(tf);

		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}