package com.kh.mini.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.mini.model.dao.FoodDao;
import com.kh.mini.model.dao.StoreDao;
import com.kh.mini.model.dao.UserDao;
import com.kh.mini.model.vo.Food;
import com.kh.mini.model.vo.Store;

//OwnerSubMenu extends JFrame

public class OwnerSubMenu extends JFrame {

	UserDao ud = new UserDao();
	StoreDao sd = new StoreDao();
	JLabel[] lbArr;
	JLabel lbIcon;
	JButton btn1, btn2, btn3, btn4;
	JPanel panel;

	public OwnerSubMenu() {
		this.setTitle("사장님 페이지");
		this.setSize(450, 600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);

		panel = new JPanel(null);
		panel.setSize(450, 600);

		try {
			this.setIconImage(ImageIO.read(new File("image/배고프조로고.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image icon = new ImageIcon("image/배고프조로고.png").getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		lbIcon = new JLabel(new ImageIcon(icon));
		lbIcon.setBounds(95, 0, 250, 150);

		// 가게 정보 보여주기
		String storeName = sd.findStoreName(ud.displayLoginUser().getUserName());
		Store store = sd.displayStore(storeName);
		String isStoreOpen = "";
		if (store.isStoreOpen() == true) {
			isStoreOpen = "Open";
		} else {
			isStoreOpen = "Close";
		}

		lbArr = new JLabel[6];
		lbArr[0] = new JLabel(store.getStoreName());
		lbArr[1] = new JLabel(store.getStoreAddr());
		lbArr[2] = new JLabel(store.getStoreCall());
		lbArr[3] = new JLabel(store.getStoreType());
		lbArr[4] = new JLabel(isStoreOpen);
		lbArr[5] = new JLabel(Double.toString(store.getStoreGrade()));

		int x = 10, y = -50, width = 400, height = 200;
		for (int i = 0; i < lbArr.length; i++) {
			if (i == 0) {
				lbArr[i].setFont(new Font("Serif", Font.BOLD, 36));
			}
			lbArr[i].setBounds(x, y, width, height);
			lbArr[i].setHorizontalAlignment(JLabel.CENTER);
			panel.add(lbArr[i]);
			y += 30;
		}

		btn1 = new JButton("메뉴 추가");
		btn2 = new JButton("메뉴 삭제");
		btn3 = new JButton("예약 설정 변경");
		btn4 = new JButton("돌아가기");

		btn1.setBounds(80, 240, 260, 60);
		btn2.setBounds(80, 310, 260, 60);
		btn3.setBounds(80, 380, 260, 60);
		btn4.setBounds(80, 450, 260, 60);

		btn1.setBackground(Color.gray);
		btn2.setBackground(Color.gray);
		btn3.setBackground(Color.gray);
		btn4.setBackground(Color.gray);

		btn1.setForeground(Color.white);
		btn2.setForeground(Color.white);
		btn3.setForeground(Color.white);
		btn4.setForeground(Color.white);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 메뉴 추가 페이지로 넘어가기
				addMenu();

			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 메뉴 삭제 페이지로 넘어가기
				deleteMenu();

			}
		});

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 예약 설정 변경 페이지로 넘어가기
				settingOpen();
			}
		});

		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 메인으로 돌아가기
				backToMain();

			}
		});

		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);

		this.add(panel);

		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	protected void addMenu() {
		this.setVisible(false);
		new AddMenu();
		return;

	}

	protected void deleteMenu() {
		this.setVisible(false);
		new DeleteMenu();
		return;

	}

	protected void settingOpen() {
		this.setVisible(false);
		new SettingOpen();
		return;

	}

	protected void backToMain() {
		this.setVisible(false);
		new AppMenu();
		return;

	}

}

class AddMenu extends JFrame {

	private FoodDao fd = new FoodDao();
	private StoreDao sd = new StoreDao();
	private UserDao ud = new UserDao();
	
	JLabel[] lbArr;
	JLabel lbIcon, lb1, lb2, lb3;
	JTextField tf1, tf2;
	JButton btn1, btn2;

	public AddMenu() {
		this.setTitle("메뉴 추가");
		this.setSize(450, 600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		try {
			this.setIconImage(ImageIO.read(new File("image/배고프조로고.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image icon = new ImageIcon("image/배고프조로고.png").getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		lbIcon = new JLabel(new ImageIcon(icon));
		lbIcon.setBounds(95, 0, 250, 150);

		// 메뉴 보여주기
		lb3 = new JLabel("MENU");
		lb3.setFont(new Font("Serif", Font.BOLD, 36));
		lb3.setBounds(10, -40, 400, 200);
		lb3.setHorizontalAlignment(JLabel.CENTER);

		
		String storeName = sd.findStoreName(ud.displayLoginUser().getUserName());
		System.out.println(ud.displayLoginUser().getUserName() + " storeName : " + storeName);
		int x = 10, y = 10, width = 400, height = 200;
		lbArr = new JLabel[10];
		Iterator it = fd.displayAllList(storeName).iterator();
		while (it.hasNext()) {
			for (int i = 0; i < fd.displayAllList(storeName).size(); i++) {
				lbArr[i] = new JLabel((i + 1) + ". " + it.next().toString());
				lbArr[i].setBounds(x, y, width, height);
				lbArr[i].setHorizontalAlignment(JLabel.CENTER);
				this.add(lbArr[i]);
				y += 30;
			}
		}

		lb1 = new JLabel("메뉴 이름 : ");
		lb2 = new JLabel("메뉴 가격 : ");
		tf1 = new JTextField();
		tf2 = new JTextField();
		btn1 = new JButton("추가하기");
		btn2 = new JButton("돌아가기");

		lb1.setBounds(80, 280, 120, 40);
		lb2.setBounds(80, 340, 120, 40);
		tf1.setBounds(160, 280, 160, 40);
		tf2.setBounds(160, 340, 160, 40);
		btn1.setBounds(80, 430, 120, 80);
		btn2.setBounds(230, 430, 120, 80);

		btn1.setBackground(Color.gray);
		btn2.setBackground(Color.gray);

		btn1.setForeground(Color.white);
		btn2.setForeground(Color.white);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String foodName = tf1.getText();
				int foodPrice = Integer.parseInt(tf2.getText());
				System.out.println("추가한 메뉴 이름 : " + foodName + ", 가격 : " + foodPrice);
				fd.writeFood(new Food(storeName, foodName, foodPrice));
				System.out.println(fd.displayAllList());

				JOptionPane.showMessageDialog(getParent(), "메뉴 추가가 완료되었습니다.");
				reloadPanel();

			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				backToOwnerSubMenu();
			}
		});

		this.add(lb1);
		this.add(lb2);
		this.add(lb3);
		this.add(tf1);
		this.add(tf2);
		this.add(btn1);
		this.add(btn2);

		this.setVisible(true);

	}
	
	protected void reloadPanel() {
		this.setVisible(false);
		new AddMenu();
		return;
		
	}

	protected void backToOwnerSubMenu() {
		this.setVisible(false);
		new OwnerSubMenu();
		return;

	}

}

class DeleteMenu extends JFrame {

	private FoodDao fd = new FoodDao();

	StoreDao sd = new StoreDao();
	UserDao ud = new UserDao();
	JLabel[] lbArr;
	JLabel lbIcon, lb1, lb3;
	JTextField tf1, tf2;
	JButton btn1, btn2;

	public DeleteMenu() {
		this.setTitle("메뉴 삭제");
		this.setSize(450, 600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		try {
			this.setIconImage(ImageIO.read(new File("image/배고프조로고.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image icon = new ImageIcon("image/배고프조로고.png").getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		lbIcon = new JLabel(new ImageIcon(icon));
		lbIcon.setBounds(95, 0, 250, 150);

		// 메뉴 보여주기
		lb3 = new JLabel("MENU");
		lb3.setFont(new Font("Serif", Font.BOLD, 36));
		lb3.setBounds(10, -40, 400, 200);
		lb3.setHorizontalAlignment(JLabel.CENTER);

		String storeName = sd.findStoreName(ud.displayLoginUser().getUserName());
		System.out.println(ud.displayLoginUser().getUserName() + " storeName : " + storeName);
		int x = 10, y = 10, width = 400, height = 200;
		lbArr = new JLabel[10];
		Iterator it = fd.displayAllList(storeName).iterator();
		while (it.hasNext()) {
			for (int i = 0; i < fd.displayAllList(storeName).size(); i++) {
				lbArr[i] = new JLabel((i + 1) + ". " + it.next().toString());
				lbArr[i].setBounds(x, y, width, height);
				lbArr[i].setHorizontalAlignment(JLabel.CENTER);
				this.add(lbArr[i]);
				y += 30;
			}
		}

		lb1 = new JLabel("삭제할 메뉴 이름 : ");
		tf1 = new JTextField();
		btn1 = new JButton("삭제하기");
		btn2 = new JButton("돌아가기");

		lb1.setBounds(80, 340, 120, 40);
		tf1.setBounds(190, 340, 160, 40);
		btn1.setBounds(80, 430, 120, 80);
		btn2.setBounds(230, 430, 120, 80);

		btn1.setBackground(Color.gray);
		btn2.setBackground(Color.gray);

		btn1.setForeground(Color.white);
		btn2.setForeground(Color.white);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String foodName = tf1.getText();
				System.out.println("삭제할 메뉴 이름 : " + foodName);
				
				for (int i = 0; i < fd.displayAllList(storeName).size(); i++) {
					if (foodName.equals(fd.displayAllList(storeName).get(i).getFoodName())) {
						int result = JOptionPane.showConfirmDialog(getParent(), "정말로 삭제하시겠습니까?", "메뉴 삭제 확인",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

						if (result == JOptionPane.YES_OPTION) {
							fd.deleteFood(foodName);
							JOptionPane.showMessageDialog(getParent(), foodName + " 메뉴가 삭제되었습니다.");
							System.out.println(fd.displayAllList());
							reloadPanel();

						} else {
							System.out.println("메뉴 삭제 취소");
						}

						return;
					}
				}
				
				for (int i = 0; i < fd.displayAllList(storeName).size(); i++) {
					if (!foodName.equals(fd.displayAllList(storeName).get(i).getFoodName())) {
						JOptionPane.showMessageDialog(getParent(), "없는 메뉴입니다.");
						return;
					}
				}

			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				backToOwnerSubMenu();
			}
		});

		this.add(lb1);
		this.add(lb3);
		this.add(tf1);
		this.add(btn1);
		this.add(btn2);

		this.setVisible(true);
	}

	protected void reloadPanel() {
		this.setVisible(false);
		new DeleteMenu();
		return;
		
	}

	protected void backToOwnerSubMenu() {
		this.setVisible(false);
		new OwnerSubMenu();
		return;

	}

}

class SettingOpen extends JFrame {

	UserDao ud = new UserDao();
	StoreDao sd = new StoreDao();
	JLabel[] lbArr;
	JLabel lbIcon;
	JButton btn1, btn2;
	String isStoreOpen;

	public SettingOpen() {
		this.setTitle("예약 설정 변경");
		this.setSize(450, 600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		try {
			this.setIconImage(ImageIO.read(new File("image/배고프조로고.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Image icon = new ImageIcon("image/배고프조로고.png").getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		lbIcon = new JLabel(new ImageIcon(icon));
		lbIcon.setBounds(95, 0, 250, 150);

		// 가게 정보 보여주기
		String storeName = sd.findStoreName(ud.displayLoginUser().getUserName());
		Store store = sd.displayStore(storeName);
		isStoreOpen = "";
		if (store.isStoreOpen() == true) {
			isStoreOpen = "Open";
		} else {
			isStoreOpen = "Close";
		}

		lbArr = new JLabel[6];
		lbArr[0] = new JLabel(store.getStoreName());
		lbArr[1] = new JLabel(store.getStoreAddr());
		lbArr[2] = new JLabel(store.getStoreCall());
		lbArr[3] = new JLabel(store.getStoreType());
		lbArr[4] = new JLabel(isStoreOpen);
		lbArr[5] = new JLabel(Double.toString(store.getStoreGrade()));

		int x = 10, y = -50, width = 400, height = 200;
		for (int i = 0; i < lbArr.length; i++) {
			if (i == 0) {
				lbArr[i].setFont(new Font("Serif", Font.BOLD, 36));
			}
			lbArr[i].setBounds(x, y, width, height);
			lbArr[i].setHorizontalAlignment(JLabel.CENTER);
			this.add(lbArr[i]);
			y += 30;
		}

		btn1 = new JButton("변경하기");
		btn2 = new JButton("돌아가기");

		btn1.setBounds(80, 430, 120, 80);
		btn2.setBounds(230, 430, 120, 80);

		btn1.setBackground(Color.gray);
		btn2.setBackground(Color.gray);

		btn1.setForeground(Color.white);
		btn2.setForeground(Color.white);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(getParent(),
						"현재 예약 설정은 " + isStoreOpen + " 입니다.\r\n" + "설정을 변경하시겠습니까?", "예약 설정 변경",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					store.setStoreOpen(!(store.isStoreOpen()));
					JOptionPane.showMessageDialog(getParent(), "설정 변경이 완료되었습니다.");
					reloadPanel();
				} else {
					System.out.println("설정 변경 취소");
				}

			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				backToOwnerSubMenu();

			}
		});

		this.add(btn1);
		this.add(btn2);

		this.setVisible(true);

	}

	protected void reloadPanel() {
		this.setVisible(false);
		new SettingOpen();
		return;

	}

	protected void backToOwnerSubMenu() {
		this.setVisible(false);
		new OwnerSubMenu();
		return;

	}
}