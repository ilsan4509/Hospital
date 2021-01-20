package org.comstudy21.myapp.view;

import static org.comstudy21.myapp.resource.R.title;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

import org.comstudy21.myapp.resource.R;

public class MainFrame extends JFrame implements R {
	static Container c = null;

	public static GraphView graphView = new GraphView();
	static TitleView titleView = new TitleView();
	static InputView inputView = new InputView();
	static ListView listView = new ListView();
	static BtnView btnView = new BtnView();

	public MainFrame() {

		c = getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(title);
		try {
			Image image = new ImageIcon("hospital_icon.png").getImage();
			setIconImage(image);
		} catch (Exception e) {
			System.out.println("Application icon not found");
		}
		// 레이아웃 및 패널 추가
		display();
		// 창 사이즈 조정
		setSize(frameWidth, frameHeight);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	}
	// View 패널을 선언한다.

	public void display() {
		c.setLayout(new BorderLayout());

		c.add(BorderLayout.NORTH, titleView);
		c.add(BorderLayout.WEST, graphView);
		c.add(BorderLayout.EAST, inputView);
		c.add(BorderLayout.CENTER, listView);
		c.add(BorderLayout.SOUTH, btnView);

		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		table.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);

	}
}
