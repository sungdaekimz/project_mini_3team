package com.kh.mini.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.model.vo.StoreReview;
import com.kh.mini.model.vo.User;

public class MyPageSwing extends JFrame{
	
	Scanner sc = new Scanner(System.in);
	
	JPanel panel1, panel2, panel3;
	JLabel label, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11, lb12, lb13, lb14, 
           label2;
	JButton btn1;
	
	
	public void myInfo() {
		
		User u = new User();
		ArrayList<User> uList = new ArrayList<User>();
		
		panel1 = new JPanel();
		this.setTitle("맛집 관리 프로그램");
		this.setBounds(200,300, 450, 600);
		this.setLayout(null);
		
		label = new JLabel("마이페이지");
		//label.setSize(450, 50);
		label.setBounds(10, 50, 450, 50);
		label.setOpaque(true);
		label.setBackground(Color.BLUE);
		
		lb1 = new JLabel("회원 아이디");
		lb1.setSize(20, 20);
		lb8 = new JLabel(u.getUserId());
		lb8.setSize(50, 20);
		lb8.setOpaque(true);
		lb8.setBackground(Color.gray);

		lb2 = new JLabel("비밀번호");
		lb9 = new JLabel(u.getUserPwd());

		// System.out.println("이름 : ");
		lb3 = new JLabel("이름");
		// System.out.println(u.getUserName());
		lb10 = new JLabel(u.getUserName());

		// System.out.println("나이 : ");
		lb4 = new JLabel("나이");
		// System.out.println(u.getUserAge());
		// lb11 = new JLabel(u.getUserAge());오류

		// System.out.println("성별 : ");
		lb5 = new JLabel("성별");
		// System.out.println(u.getUserGender());
		// lb12 = new JLabel(u.getUserGender());오류

		// System.out.println("휴대전화 : ");
		lb6 = new JLabel("휴대전화");
		// System.out.println(u.getUserPhone());
		lb13 = new JLabel(u.getUserPhone());

		// System.out.println("권한 : ");
		lb7 = new JLabel("권한");
		// System.out.println(u.getUserType());
		// lb14 = new JLabel(u.getUserType());
		
		btn1 = new JButton("홈");
		btn1.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);

		panel1.add(label);
		panel1.add(lb1);
		panel1.add(lb2);
		panel1.add(lb3);
		panel1.add(lb4);
		panel1.add(lb5);
		panel1.add(lb6);
		panel1.add(lb7);
		panel1.add(lb8);
		panel1.add(lb9);
		panel1.add(lb10);
		// panel.add(lb11);
		// panel.add(lb12);
		panel1.add(lb13);
		// panel.add(lb14);
		panel1.add(btn1);
		
		this.add(panel1);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	
	
	JLabel l1;
	JButton b1, b2, b3;
	
	//전체 후기 조회
		public void reviewCollect() {
			
			this.setLayout(null);
			
			panel2 = new JPanel();
			this.setTitle("맛집 관리 프로그램");
			this.setBounds(200, 300, 450, 600);
			
			// 마이페이지 상단바
			
			l1 = new JLabel("나의 후기");
	        l1.setBounds(300, 400, 450, 50);
	        
	        b1 = new JButton("검색");
			b1.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);
			
			b2 = new JButton("작성");
			b2.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);
			
			b1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					searchReview();
				}
				
			});
			
			b2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//후기 작성
				}
				
			});
			
	        //System.out.println("후기 전체 조회"); b1: 나의 후기
			
			ArrayList<StoreReview> rList = new ArrayList<StoreReview>();
			
			Iterator it = rList.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			
			//System.out.println(rList);
			
			b3 = new JButton("홈");
			b3.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);
			
			b3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//홈화면
				}
				
			});
			
			panel2.add(l1);
			panel2.add(b1);
			panel2.add(b2);
			panel2.add(b3);
			
			this.add(panel2);
			
			this.setVisible(true);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		}
	

		
		
    JLabel l2, l3;
	JButton b4;
	
	//후기 검색(가게 이름)
	public void searchReview() {
		this.setLayout(null);
		//this.getContentPane().setLayout(null);
		
		panel3 = new JPanel();
		this.setTitle("맛집 관리 프로그램");
		this.setBounds(200, 300, 450, 600);
		
		// 마이페이지 상단바
		
		ArrayList<StoreReview> rList = new ArrayList<StoreReview>();
		
		b4 = new JButton();//검색버튼
        b4.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);
		
        l2 = new JLabel("가게 이름을 입력하세요.");
		l2.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);
        
		JTextField tf = new JTextField();
		tf.setBounds(400, 500, 450, 600);
		
		//System.out.println("가게 이름을 검색하세요");
		String sName = sc.nextLine();
		
		
		ArrayList<StoreReview> sList = new ArrayList<StoreReview>();
		
		for(int i = 0; i < sList.size(); i++) {
			if(rList.get(i).getStoreName().contains(tf.getText())) {
				sList.add(rList.get(i));
			}
		}
		
		String[] fl = new String[] {"번호", "가게", "후기"};
		DefaultTableModel model = new DefaultTableModel(fl, 0);
		
		
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
		if(sList.isEmpty()) {
			l3 = new JLabel("검색 결과가 없습니다.");
		}else {
			for(int i = 0; i <sList.size(); i++) {
				System.out.println(sList.get(i));
			}
		}
		
		
		panel3.add(b4);
		panel3.add(l2);
		panel3.add(l3);
		panel3.add(tf);
		panel3.add(sp);
		
		this.add(panel3);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	

}