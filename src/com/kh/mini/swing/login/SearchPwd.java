package com.kh.mini.swing.login;

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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.kh.mini.model.dao.UserDao;

public class SearchPwd implements ActionListener {

	UserDao ud = new UserDao();
	JTextField jtfId, jtfName, jtfPhone;
	JButton btn1, btn2;
	JFrame frm;
	
	public SearchPwd() {

		// 프레임생성
		frm = new JFrame("비밀번호 찾기");
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

		// 이름, 핸드폰번호 라벨 생성

		Font f1 = new Font("돋움", Font.BOLD, 20);
		Font f2 = new Font("돋움", Font.BOLD, 25);

		JLabel id = new JLabel();
		id = new JLabel("아이디: ");
		id.setBounds(40, 110, 80, 40);
		id.setFont(f1);
		frm.getContentPane().add(id);

		jtfId = new JTextField();
		jtfId.setBounds(120, 110, 245, 40);
		jtfId.setFont(f1);
		frm.getContentPane().add(jtfId);

		JLabel name = new JLabel();
		name = new JLabel("이름: ");
		name.setBounds(40, 190, 80, 40);
		name.setFont(f1);
		frm.getContentPane().add(name);

		jtfName = new JTextField();
		jtfName.setBounds(110, 190, 260, 40);
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

		// 확인, 취소 버튼 생성
		btn1 = new JButton("확인");
		btn2 = new JButton("취소");

		btn1.setBounds(60, 480, 130, 45);
		btn2.setBounds(240, 480, 130, 45);

		btn1.setBackground(Color.LIGHT_GRAY);
		btn2.setBackground(Color.LIGHT_GRAY);
		// btn1.setForeground(Color.white);
		// btn2.setForeground(Color.white);
		
		btn1.setFont(f1);
		btn2.setFont(f1);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		frm.getContentPane().add(btn1);
		frm.getContentPane().add(btn2);
		
		// 핸드폰번호로 본인인증하기. 생성
		JLabel IdLabel = new JLabel();
		IdLabel = new JLabel("  핸드폰번호로 본인인증하기. ");
		IdLabel.setBounds(70, 30, 300, 60);
		IdLabel.setFont(f1);
		IdLabel.setOpaque(true);
		IdLabel.setBackground(Color.gray);
		IdLabel.setForeground(Color.white);
		frm.getContentPane().add(IdLabel);

		frm.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btn1) {
			ClickButton_searchPwd(arg0);
		}

		if (arg0.getSource() == btn2) {
			new SwingLogin();
			frm.setVisible(false);
		}

	}

	protected void ClickButton_searchPwd(ActionEvent arg0) {
		String id = jtfId.getText();
		String name = jtfName.getText();
		String phone = jtfPhone.getText();

		ud.readFileUser();
		
		for (int k = 0; k < ud.displayAllList().size(); k++) {
			if (id.equals(ud.displayAllList().get(k).getUserId()) && name.equals(ud.displayAllList().get(k).getUserName())
					&& phone.equals(ud.displayAllList().get(k).getUserPhone())) {
				JOptionPane.showMessageDialog(null, "회원님의 비밀번호는\n" + ud.displayAllList().get(k).getUserPwd() + " 입니다.");
				new SwingLogin();
				frm.setVisible(false);
				return;
			} 
			if (id.equals(ud.displayAllList().get(k).getUserId()) && name.equals(ud.displayAllList().get(k).getUserName())
					&& phone.equals(ud.displayAllList().get(k).getUserPhone())) {
				JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다.\n다시 입력해주세요!");
				return;
			}
		}
	}
}
