package com.kh.mini.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.kh.mini.model.dao.StoreDao;
import com.kh.mini.model.vo.Store;

public class DisplayStore_name extends JFrame {

	JButton btn;
	JLabel[] lbArr;

	StoreDao sd = new StoreDao();

	public DisplayStore_name() {
		this.setTitle("전체 매장 조회");
		this.setSize(450, 600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);

		ArrayList<Store> store = sd.displayStore_name(); // 이 내용을 붙여넣기만 하면 ;;

		lbArr = new JLabel[sd.displayAllList().size()];
		for (int i = 0; i < lbArr.length; i++) {
			lbArr[i] = new JLabel(store.get(i).getStoreName());
		}

		int x = 10, y = -50, width = 400, height = 180;
		for (int i = 0; i < lbArr.length; i++) {
			lbArr[i].setBounds(x, y, width, height);
			lbArr[i].setHorizontalAlignment(JLabel.CENTER);
			this.add(lbArr[i]);
			y += 25;
		}

		btn = new JButton("돌아가기");
		btn.setBounds(150, 430, 150, 80);
		btn.setBackground(Color.gray);
		btn.setForeground(Color.white);

		btn.addActionListener(new ActionListener() {

			// 메인화면으로 돌아가기
			@Override
			public void actionPerformed(ActionEvent e) {
				backmainPanel();
			}

		});

		this.add(btn);
		this.setVisible(true);
	}

	protected void backmainPanel() {
		this.setVisible(false);
		new AppMenu();
		return;

	}

}
