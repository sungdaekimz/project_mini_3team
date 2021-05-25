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
	JLabel[] lbArr_name;
	JLabel[] lbArr_address;
	JLabel[] lbArr_call;

	StoreDao sd = new StoreDao();

	public DisplayStore_name() {
		this.setTitle("전체 매장 조회");
		this.setSize(450, 600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);

		ArrayList<Store> store = sd.displayStore_name(); // 이 내용을 붙여넣기만 하면 ;;

		// 이름
				lbArr_name = new JLabel[sd.displayAllList().size()];
				for (int i = 0; i < lbArr_name.length; i++) {
					lbArr_name[i] = new JLabel(store.get(i).getStoreName());
				}

				int x_name = 70, y_name = -50, width_name = 400, height_name = 180;
				for (int i = 0; i < lbArr_name.length; i++) {
					lbArr_name[i].setBounds(x_name, y_name, width_name, height_name);
					// lbArr[i].setHorizontalAlignment(JLabel.CENTER);
					this.add(lbArr_name[i]);
					y_name += 25;
				}

				// 주소
				lbArr_address = new JLabel[sd.displayAllList().size()];
				for (int i = 0; i < lbArr_address.length; i++) {
					lbArr_address[i] = new JLabel(store.get(i).getStoreAddr());
				}

				int x_address = 190, y_address = -50, width_address = 400, height_address = 180;
				for (int i = 0; i < lbArr_address.length; i++) {
					lbArr_address[i].setBounds(x_address, y_address, width_address, height_address);
					// lbArr[i].setHorizontalAlignment(JLabel.CENTER);
					this.add(lbArr_address[i]);
					y_address += 25;
				}

				// 전화번호
				lbArr_call = new JLabel[sd.displayAllList().size()];
				for (int i = 0; i < lbArr_call.length; i++) {
					lbArr_call[i] = new JLabel(store.get(i).getStoreCall());
				}

				int x_call = 300, y_call = -50, width_call = 400, height_call = 180;
				for (int i = 0; i < lbArr_call.length; i++) {
					lbArr_call[i].setBounds(x_call, y_call, width_call, height_call);
					// lbArr[i].setHorizontalAlignment(JLabel.CENTER);
					this.add(lbArr_call[i]);
					y_call += 25;
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
