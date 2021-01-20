package org.comstudy21.myapp.resource;

import java.awt.Color;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.comstudy21.myapp.controller.Controller;

public interface R {
	// 상수값을 한곳에 모아 둔다.
	// 결합도는 낮추고, 응집력은 높이는 프로그래밍
	// 결합도가 높은 프로그램은 스파게티코드이다.
	String title = "::: Infectious Disease Patient Management System :::";
	int frameWidth = 1200, frameHeight = 600;
	JLabel lblTitle = new JLabel(title);
	// JTextField는 View와 Controller에서 모두 접근해야 한다.

	// GraphView grapView = new GraphView();

	JTextField txtNo = new JTextField(10);

	JTextField txtName = new JTextField(10);
	JTextField txtPhone = new JTextField(10);
	JTextField txtAge = new JTextField(10);
	JLabel lblAvg = new JLabel();
	JButton btnEra = new JButton("입력값 초기화");
	JButton btnFind = new JButton("찾기");

	// 연령대 명수 받기 라벨
	JLabel lbl20Count = new JLabel();
	JLabel lbl40Count = new JLabel();
	JLabel lbl60Count = new JLabel();
	JLabel lbl80Count = new JLabel();
	JLabel lbl80upCount = new JLabel();

	// 라디오버튼 1
	JRadioButton radio01[] = new JRadioButton[2];
	String text[] = { "확진", "정상" };
	ButtonGroup g01 = new ButtonGroup();

	// 정상자/확진자 명수 받기 라벨
	JLabel goodCount = new JLabel();
	JLabel badCount = new JLabel();

	// 콤보(셀렉트박스)
	String room[] = { "타병원", "1호실", "2호실", "3호실" };
	JComboBox roomCombo = new JComboBox(room);
	// 호실 명수 받기 라벨
	JLabel lblroom01C = new JLabel();
	JLabel lblroom02C = new JLabel();
	JLabel lblroom03C = new JLabel();
	JLabel lblroompEmpty = new JLabel();
	
	//입원환자수 타병원환자수
	JLabel lblroomMember = new JLabel();
	JLabel lblroomNotMember = new JLabel();
	

	ImageIcon bedEmptyImage =new ImageIcon("hospital_bed_b_32px.png");
	JLabel bedEmpty01 = new JLabel(bedEmptyImage);
	JLabel bedEmpty02 = new JLabel(bedEmptyImage);
	JLabel bedEmpty03 = new JLabel(bedEmptyImage);
	JLabel bedEmpty04 = new JLabel(bedEmptyImage);
	
	ImageIcon bedUseImage =new ImageIcon("hospital_bed_c_32px.png");
	JLabel bedUse01 = new JLabel(bedUseImage);
	JLabel bedUse02 = new JLabel(bedUseImage);
	JLabel bedUse03 = new JLabel(bedUseImage);
	JLabel bedUse04 = new JLabel(bedUseImage);
	
	Color BG_COLOR = new Color(0xff4500);
	Color GG_COLOR = new Color(0x787878);
	Color MG_COLOR = new Color(0xfe9247);
	
	ImageIcon duckImage =new ImageIcon("duckSmall.png");
	JLabel lblduck = new JLabel(duckImage);
	
	Vector dataVector = new Vector();
	Vector columnIdentifiers = new Vector();
	DefaultTableModel dm = new DefaultTableModel(dataVector, columnIdentifiers);
	JTable table = new JTable(dm);

	JButton btnAll = new JButton("전체 불러오기");
	JButton btnAppend = new JButton("추가");
	JButton btnModify = new JButton("수정");
	JButton btnDelete = new JButton("삭제");
	JButton btnSearch = new JButton("검색");
	JButton btnReset = new JButton("데이터 불러오기");

	HashMap<JButton, Controller> ctrlMap = new HashMap<>();

}
