package org.comstudy21.myapp.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleView extends View {
	JPanel titleTPane = new JPanel(new GridLayout(1,3));
	ImageIcon titleImage =new ImageIcon("hospitalnameS1.jpg");
	JLabel leftImage01 = new JLabel(titleImage);
	public TitleView() {
		display();
	}

	@Override
	public void display() {
		add(titleTPane);
		// 상속을 받았기 때문에 TitleView가 곧 JPanel이다.
		// JPanel의 모든 기능 사용가능.
		// JFrame에 View 객체를 붙일 수 있다. 
		
		JPanel titlePane03 = new JPanel();
		titlePane03.setLayout(new BorderLayout());
		titlePane03.setBackground(BG_COLOR);
		JPanel titlePane03_w3 = new JPanel(new GridLayout(3,1));
		titlePane03_w3.setBackground(BG_COLOR);
		JLabel lblTitle03 = new JLabel("전염병 환자 관리 시스템");
		JLabel lblTitle04 = new JLabel("시스템 업데이트: 2020-09-29");
		JLabel lblTitle05 = new JLabel("담당자: 김성곤");
		lblTitle03.setForeground(Color.WHITE);
		lblTitle04.setForeground(Color.WHITE);
		lblTitle05.setForeground(Color.WHITE);
		
		titlePane03_w3.add(lblTitle03);
		titlePane03_w3.add(lblTitle04);
		titlePane03_w3.add(lblTitle05);
		titlePane03.add(BorderLayout.CENTER,titlePane03_w3);
		titleTPane.add(titlePane03);
		JPanel titlePane02 = new JPanel();
		JLabel lblTitle02 = new JLabel(title);
		titlePane02.setLayout(new BorderLayout());
		titlePane02.setBackground(BG_COLOR);
		lblTitle02.setForeground(Color.WHITE);
		lblTitle02.setFont(new Font("", Font.BOLD, 15));
		titlePane02.add(BorderLayout.CENTER,lblTitle02);
		titleTPane.add(titlePane02);
		
		JPanel titlePane01 = new JPanel();
		titlePane01.setLayout(new BorderLayout());
		titlePane01.setBackground(BG_COLOR);
		titlePane01.add(BorderLayout.EAST,leftImage01);//
		titleTPane.add(titlePane01);
		
		setBackground(BG_COLOR);
	}
}
