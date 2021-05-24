package com.kh.mini.swing.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.mini.model.dao.UserDao;
import com.kh.mini.model.vo.User;
import com.kh.mini.view.AppMenu;

public class SwingLogin implements ActionListener {
//	private ArrayList<User> list = new ArrayList<>();
	// private AppMenu appMenu = new AppMenu();

	UserDao ud = new UserDao();
	JButton btn1, btn2, btn3, btn4;
	JTextField jtf, jpf;
	JCheckBox u, p, a;
	JFrame frm;

	public SwingLogin() {
//		User us = new User("user1", "pass1", "yejin", "010", 28, 'F', 'U');
//		list.add(us);

		// 프레임생성
		frm = new JFrame("로그인");
		frm.setSize(450, 600);
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frm.getContentPane().setLayout(null);

		try {
			frm.setIconImage(ImageIO.read(new File("image/배고프조로고.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 로고 이미지넣기
		Image icon = new ImageIcon("image/배고프조로고.png").getImage().getScaledInstance(300, 300, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setBounds(95, 20, 250, 150);
		frm.getContentPane().add(label);

		// 로그인, 회원가입, 아이디찾기, 비밀번호찾기 버튼생성
		Font f1 = new Font("돋움", Font.BOLD, 20);
		Font f2 = new Font("돋움", Font.BOLD, 25);

		btn1 = new JButton("로그인");
		btn2 = new JButton("회원가입");

		btn3 = new JButton("아이디찾기");
		btn4 = new JButton("비밀번호찾기");

		btn1.setBounds(60, 400, 130, 45);
		btn2.setBounds(240, 400, 130, 45);

		btn3.setBounds(105, 460, 100, 25);
		btn4.setBounds(225, 460, 120, 25);

		btn1.setBackground(Color.LIGHT_GRAY);
		btn2.setBackground(Color.LIGHT_GRAY);
		btn3.setBackground(Color.LIGHT_GRAY);
		btn4.setBackground(Color.LIGHT_GRAY);
		// btn1.setForeground(Color.white);
		// btn2.setForeground(Color.white);
		// btn3.setForeground(Color.white);
		// btn4.setForeground(Color.white);
		btn1.setFont(f1);
		btn2.setFont(f1);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);

		frm.getContentPane().add(btn1);
		frm.getContentPane().add(btn2);
		frm.getContentPane().add(btn3);
		frm.getContentPane().add(btn4);

		// 아이디, 비밀번호 라벨생성
		JLabel lbl1 = new JLabel();
		Image id = new ImageIcon("image/아이디.PNG").getImage().getScaledInstance(50, 50, 0);
		lbl1 = new JLabel(new ImageIcon(id));
		lbl1.setBounds(60, 240, 50, 50);
		frm.getContentPane().add(lbl1);

		jtf = new JTextField();
		jtf.setBounds(120, 240, 250, 50);
		jtf.setFont(f1);
		frm.getContentPane().add(jtf);

		JLabel lbl2 = new JLabel();
		Image pwd = new ImageIcon("image/비밀번호.PNG").getImage().getScaledInstance(50, 50, 0);
		lbl2 = new JLabel(new ImageIcon(pwd));
		lbl2.setBounds(60, 300, 50, 50);
		frm.getContentPane().add(lbl2);

		jpf = new JPasswordField();
		jpf.setBounds(120, 300, 250, 50);
		jpf.setFont(f1);
		frm.getContentPane().add(jpf);

		// 일반회원, 사업자, 관리자 체크박스생성

		u = new JCheckBox("일반회원");
		u.setBounds(80, 200, 80, 20);
		p = new JCheckBox("사업자");
		p.setBounds(190, 200, 80, 20);
		a = new JCheckBox("관리자");
		a.setBounds(290, 200, 80, 20);
		frm.getContentPane().add(u);
		frm.getContentPane().add(p);
		frm.getContentPane().add(a);

		frm.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btn1) {
			ClickButton_login(arg0);
		}

		if (arg0.getSource() == btn2) {
			new Sginup();
			frm.setVisible(false);
		}

		if (arg0.getSource() == btn3) {
			new SearchID();
			frm.setVisible(false);
		}

		if (arg0.getSource() == btn4) {
			new SearchPwd();
			frm.setVisible(false);
		}
	}

	protected void ClickButton_login(ActionEvent arg0) {
		String id = jtf.getText();
		String pwd = jpf.getText();
		
		ud.readFileUser();

		for (int i = 0; i < ud.displayAllList().size(); i++) {
			if (id.equals(ud.displayAllList().get(i).getUserId()) && pwd.equals(ud.displayAllList().get(i).getUserPwd())) {
				ud.writeLoginUser(ud.displayAllList().get(i));
				System.out.println("현재 로그인 계정 : " + ud.displayAllList().get(i));
				JOptionPane.showMessageDialog(null, "로그인 성공!");
				new AppMenu();
				frm.setVisible(false);
				return;
			}
		}
		for (int i = 0; i < ud.displayAllList().size(); i++) {
			if (!id.equals(ud.displayAllList().get(i).getUserId()) || !pwd.equals(ud.displayAllList().get(i).getUserPwd())) {
				JOptionPane.showMessageDialog(null, "일치한 정보가 없습니다.");
				return;
			}
		}
	}
}
