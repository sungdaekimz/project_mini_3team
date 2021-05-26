package com.kh.mini.swing.reservtion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.kh.mini.view.AppMenu;

public class SelectStore implements ActionListener{
	JLabel label1, label2, label3, label4;
	JButton btn1, btn2, btn3, btn4, btn5;
	JFrame frm;

	public SelectStore() {
		frm = new JFrame("음식점 선택");
		frm.setSize(450,650);
		frm.setLocationRelativeTo(null);		
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frm.getContentPane().setLayout(null);
		
		try {
			frm.setIconImage(ImageIO.read(new File("image/배고프조로고.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Image table = new ImageIcon("image/테이블플레이팅.png").getImage().getScaledInstance(450, 200, 0);
		JLabel label = new JLabel(new ImageIcon(table));
		label.setBounds(0,0,450,200);
        frm.getContentPane().add(label);
		
		
        ImageIcon kor = new ImageIcon("image/한식.jpg");
        label1 = new JLabel(kor);
        btn1 = new JButton(kor);
		btn1.setBounds(30,270,80,70);
        frm.getContentPane().add(btn1);
        
        ImageIcon  wes = new ImageIcon("image/양식.jpg");
		label2 = new JLabel(wes);
		btn2 = new JButton(wes);
		btn2.setBounds(130,270,80,70);
        frm.getContentPane().add(btn2);
       
        ImageIcon chi = new ImageIcon("image/중식.jpg");
		label3 = new JLabel(chi);
		btn3 = new JButton(chi);
		btn3.setBounds(220,270,80,70);
		frm.getContentPane().add(btn3);
       
        ImageIcon jap = new ImageIcon("image/일식.jpg");
		label4 = new JLabel(jap);
		btn4 = new JButton(jap);
		btn4.setBounds(320,270,80,70);
        frm.getContentPane().add(btn4);
        
        btn5 = new JButton("홈");
        btn5.setBounds(170, 490, 100, 30);
		btn5.setBackground(Color.gray);
		btn5.setForeground(Color.white);
		frm.getContentPane().add(btn5);
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
       
        Font f1 = new Font("돋움",Font.BOLD,17);
        Font f2 = new Font("Serif",Font.BOLD,36);
        
        JLabel main = new JLabel();
        main = new JLabel("Main Menu");
        main.setBounds(125, 210, 200, 40);
        main.setFont(f2);
		frm.getContentPane().add(main);
        
        JLabel kor1 = new JLabel();
        kor1 = new JLabel("한식");
        kor1.setBounds(50, 340, 50, 40);
        kor1.setFont(f1);
		frm.getContentPane().add(kor1);
		
		JLabel wes1 = new JLabel();
		wes1 = new JLabel("양식");
		wes1.setBounds(150, 340, 50, 40);
		wes1.setFont(f1);
		frm.getContentPane().add(wes1);
		
		JLabel chi1 = new JLabel();
		chi1 = new JLabel("중식");
		chi1.setBounds(240, 340, 50, 40);
		chi1.setFont(f1);
		frm.getContentPane().add(chi1);
		
		JLabel jap1 = new JLabel();
		jap1 = new JLabel("일식");
		jap1.setBounds(340, 340, 50, 40);
		jap1.setFont(f1);
		frm.getContentPane().add(jap1);
		
        frm.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		MenuCategory mc = new MenuCategory();
	
		if (arg0.getSource() == btn1) {
			mc.Korean();;
			frm.setVisible(false);
			return;
		}
		if (arg0.getSource() == btn2) {
			mc.Western();
			frm.setVisible(false);
			return;
		}
		if (arg0.getSource() == btn3) {
			mc.Chinese();
			frm.setVisible(false);
			return;
		}
		if (arg0.getSource() == btn4) {
			mc.Japanese();
			frm.setVisible(false);
			return;
		}
		if (arg0.getSource() == btn5) {
			frm.setVisible(false);
			new AppMenu();
			return;
		}
		
	}

}
