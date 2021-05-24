package com.kh.mini.swing.reservtion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MenuCategory implements ActionListener {
	JFrame frm;
	JLabel label, label1, label2;

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

		label = new JLabel();
		label.setBorder(new TitledBorder(new LineBorder(Color.gray)));
		label.setBounds(20, 20, 400, 100);
		label.setText(
				"<HTML><body><center> <br>서울시 강남구 논현로 87번길 41, 신일유토빌 1층<br>Tel 02-0000-0000   Mobile 010-0000-0000</center></body></HTML>");
		frm.getContentPane().add(label);

		Font f1 = new Font("돋움", Font.BOLD, 18);
		label1 = new JLabel("역삼갈비");
		label1.setBounds(110, 20, 100, 50);
		label1.setFont(f1);
		frm.getContentPane().add(label1);

		Font f2 = new Font("Serif", Font.BOLD, 20);
		label2 = new JLabel("OPEN");
		label2.setBounds(350, 40, 100, 50);
		label2.setFont(f2);
		frm.getContentPane().add(label2);

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
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
