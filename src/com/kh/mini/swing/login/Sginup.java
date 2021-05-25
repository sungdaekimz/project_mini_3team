package com.kh.mini.swing.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.mini.model.dao.UserDao;
import com.kh.mini.model.vo.User;

public class Sginup implements ActionListener {
//	private ArrayList<User> list = new ArrayList<>();

	UserDao ud = new UserDao();
	JTextField jtfId, jpfPwd, jtfName, jtfPhone, jtfAge;
	JButton btn1, btn2, btn3;
	JCheckBox u, p, a, w, m;
	JFrame frm;
	
	public Sginup() {

		// 프레임생성
		frm = new JFrame("회원가입");
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

		Font f1 = new Font("돋움", Font.BOLD, 20);
		Font f2 = new Font("돋움", Font.BOLD, 25);
		
		// 일반회원, 사업자, 관리자 체크박스생성
		u = new JCheckBox("일반회원");
		u.setBounds(80, 30, 80, 30);
		p = new JCheckBox("사업자");
		p.setBounds(190, 30, 80, 30);
		a = new JCheckBox("관리자");
		a.setBounds(290, 30, 80, 30);

		JLabel gender = new JLabel();
		gender = new JLabel("성별: ");
		gender.setBounds(40, 380, 80, 40);
		gender.setFont(f1);
		frm.getContentPane().add(gender);
		w = new JCheckBox("여자");
		w.setBounds(120, 380, 80, 30);
		m = new JCheckBox("남자");
		m.setBounds(220, 380, 80, 30);

		frm.getContentPane().add(u);
		frm.getContentPane().add(p);
		frm.getContentPane().add(a);
		frm.getContentPane().add(w);
		frm.getContentPane().add(m);

		// 아이디, 비밀번호 라벨생성

		JLabel id = new JLabel();
		id = new JLabel("아이디: ");
		id.setBounds(40, 60, 80, 40);
		id.setFont(f1);
		frm.getContentPane().add(id);

		jtfId = new JTextField();
		jtfId.setBounds(120, 60, 245, 40);
		jtfId.setFont(f1);
		frm.getContentPane().add(jtfId);

		JLabel pwd = new JLabel();
		pwd = new JLabel("비밀번호: ");
		pwd.setBounds(40, 160, 120, 40);
		pwd.setFont(f1);
		frm.getContentPane().add(pwd);

		jpfPwd = new JPasswordField();
		jpfPwd.setBounds(140, 160, 230, 40);
		jpfPwd.setFont(f1);
		frm.getContentPane().add(jpfPwd);

		JLabel name = new JLabel();
		name = new JLabel("이름: ");
		name.setBounds(40, 215, 80, 40);
		name.setFont(f1);
		frm.getContentPane().add(name);

		jtfName = new JTextField();
		jtfName.setBounds(110, 215, 260, 40);
		jtfName.setFont(f1);
		frm.getContentPane().add(jtfName);

		JLabel phone = new JLabel();
		phone = new JLabel("핸드폰번호: ");
		phone.setBounds(30, 270, 150, 40);
		phone.setFont(f1);
		frm.getContentPane().add(phone);

		jtfPhone = new JTextField();
		jtfPhone.setBounds(155, 270, 215, 40);
		jtfPhone.setFont(f1);
		frm.getContentPane().add(jtfPhone);

		JLabel age = new JLabel();
		age = new JLabel("나이: ");
		age.setBounds(40, 325, 80, 40);
		age.setFont(f1);
		frm.getContentPane().add(age);

		jtfAge = new JTextField();
		jtfAge.setBounds(110, 325, 260, 40);
		jtfAge.setFont(f1);
		frm.getContentPane().add(jtfAge);

		// 회원가입, 취소 버튼생성
		btn1 = new JButton("회원가입");
		btn2 = new JButton("취소");
		btn3 = new JButton("중복확인");

		btn1.setBounds(60, 480, 130, 45);
		btn2.setBounds(240, 480, 130, 45);
		btn3.setBounds(270, 110, 90, 30);
		btn1.setBackground(Color.LIGHT_GRAY);
		btn2.setBackground(Color.LIGHT_GRAY);
		btn3.setBackground(Color.LIGHT_GRAY);
		// btn1.setForeground(Color.white);
		// btn2.setForeground(Color.white);
		// btn3.setForeground(Color.white);
		btn1.setFont(f1);
		btn2.setFont(f1);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		frm.getContentPane().add(btn1);
		frm.getContentPane().add(btn2);
		frm.getContentPane().add(btn3);

		frm.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btn1) {
			ClickButton_sginup(arg0);
		}

		if (arg0.getSource() == btn2) {
			new SwingLogin();
			frm.setVisible(false);
		}

		if (arg0.getSource() == btn3) {
			ClickButton_doubleCheck(arg0);
		}

	}

	protected void ClickButton_doubleCheck(ActionEvent arg0) {
		String id = jtfId.getText();
		boolean check = false;
		ud.readFileUser();

		for (int i = 0; i < ud.displayAllList().size(); i++) {
			if (id.equals(ud.displayAllList().get(i).getUserId())) {
				check = true;
			}
		}
		
		if (check == true) {
			JOptionPane.showMessageDialog(null, "중복된 아이디 입니다!\n다시 입력해주세요!");
		} else {
			JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다.");
		}
	}

	protected void ClickButton_sginup(ActionEvent arg0) {
		char userRole = '\u0000';
		if(u.isSelected()) {//일반회원체크박스 선택시
			userRole = 'U';
		} else if(p.isSelected()) {
			userRole = 'P';
		} else if(a.isSelected()) {
			userRole = 'A';
		}
		
		String id = jtfId.getText();
		String pwd = jpfPwd.getText();
		String name = jtfName.getText();
		String phone =jtfPhone.getText();
		int age = Integer.valueOf(jtfAge.getText());
		
		char gender = 'F';
		if(w.isSelected()) {//성별 체크박스 선택시
			gender = 'F';
		} else if(m.isSelected()) {
			gender = 'M';
		}
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("sginupWriter.txt", true));
			bw.write(id+",");
			bw.write(pwd+",");
			bw.write(name+",");
			bw.write(phone+",");
			bw.write(age+",");
			bw.write(gender+",");
			bw.write(userRole+"\r\n");
			
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User mem = new User(id, pwd, name, phone, age, gender, userRole);
		
		ud.writeUser(mem);
		
		
		JOptionPane.showMessageDialog(null, "성공적으로 회원가입 되었습니다.");
		
		System.out.println(mem.toString());
		new SwingLogin();
		frm.setVisible(false);

	}

}
