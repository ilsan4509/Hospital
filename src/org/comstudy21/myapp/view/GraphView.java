package org.comstudy21.myapp.view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.comstudy21.myapp.model.Dao;

public class GraphView extends View {
	
	JTabbedPane pane = new JTabbedPane();
	DecimalFormat form = new DecimalFormat("#.##");
	
	JPanel tap01Panel = new JPanel(new GridLayout(2, 1, 1, 1));
	JPanel tap02Panel = new JPanel(new GridLayout(2, 1, 1, 1));
	
	JPanel leftWall01 = new JPanel(new GridLayout(1, 7, 5, 5));

	JPanel leftPane01 = new JPanel(new GridLayout(7, 1, 1, 1));
	JPanel leftPane02 = new JPanel(new GridLayout(7, 1, 1, 1));
	JPanel leftPane03 = new JPanel(new GridLayout(7, 1, 1, 1));
	JPanel leftPane04 = new JPanel(new GridLayout(7, 1, 1, 1));
	JPanel leftPane05 = new JPanel(new GridLayout(7, 1, 1, 1));
	JPanel leftPane06 = new JPanel(new GridLayout(7, 1, 1, 1));
	JPanel leftPane07 = new JPanel(new GridLayout(1, 1, 1, 1));

	JPanel p01_1 = new JPanel();
	JPanel p01_2 = new JPanel();
	JPanel p01_3 = new JPanel();
	JPanel p01_4 = new JPanel();
	JPanel p01_5 = new JPanel();
	JPanel p01_6 = new JPanel();
	JPanel p02_1 = new JPanel();
	JPanel p02_2 = new JPanel();
	JPanel p02_3 = new JPanel();
	JPanel p02_4 = new JPanel();
	JPanel p02_5 = new JPanel();
	JPanel p02_6 = new JPanel();
	JPanel p03_1 = new JPanel();
	JPanel p03_2 = new JPanel();
	JPanel p03_3 = new JPanel();
	JPanel p03_4 = new JPanel();
	JPanel p03_5 = new JPanel();
	JPanel p03_6 = new JPanel();
	JPanel p04_1 = new JPanel();
	JPanel p04_2 = new JPanel();
	JPanel p04_3 = new JPanel();
	JPanel p04_4 = new JPanel();
	JPanel p04_5 = new JPanel();
	JPanel p04_6 = new JPanel();
	JPanel p05_1 = new JPanel();
	JPanel p05_2 = new JPanel();
	JPanel p05_3 = new JPanel();
	JPanel p05_4 = new JPanel();
	JPanel p05_5 = new JPanel();
	JPanel p05_6 = new JPanel();
	
	JPanel pEmpty = new JPanel();

	JPanel leftValuePane = new JPanel(new GridBagLayout());

	JPanel roomWall01 = new JPanel(new GridLayout(1, 5, 5, 5));
	JPanel roomP01 = new JPanel(new GridLayout(5, 1, 1, 1));
	JPanel roomP02 = new JPanel(new GridLayout(5, 1, 1, 1));
	JPanel roomP03 = new JPanel(new GridLayout(5, 1, 1, 1));
	JPanel roomP04 = new JPanel(new GridLayout(5, 1, 1, 1));
	JPanel roomP05 = new JPanel(new GridLayout(1, 1, 1, 1));

	JPanel r02_1 = new JPanel();
	JPanel r02_2 = new JPanel();
	JPanel r02_3 = new JPanel();
	JPanel r02_4 = new JPanel();
	JPanel r02_5 = new JPanel();
	JPanel r03_1 = new JPanel();
	JPanel r03_2 = new JPanel();
	JPanel r03_3 = new JPanel();
	JPanel r03_4 = new JPanel();
	JPanel r03_5 = new JPanel();
	JPanel r04_1 = new JPanel();
	JPanel r04_2 = new JPanel();
	JPanel r04_3 = new JPanel();
	JPanel r04_4 = new JPanel();
	JPanel r04_5 = new JPanel();
	
	JPanel leftRoomPane = new JPanel(new GridBagLayout());

	public GraphView() {
		display();
		// stickGraph();
	}

	@Override
	public void display() {
		
		Dao.loadOldCount();
		Dao.loadValueCount();
		Dao.loadDataAvg();
		Dao.loadDataRoomCount();
		
		add(pane);
		pane.addTab("확진자 통계", add(tap01Panel));
		pane.addTab("입원 호실 상황", add(tap02Panel));
		
		
		tap01Panel.add(leftValuePane);
		tap01Panel.add(leftWall01);
		tap02Panel.add(leftRoomPane);
		tap02Panel.add(roomWall01);

		leftWall01.add(leftPane06);

		JPanel p06_1 = new JPanel();
		p06_1.add(new JLabel("6명(이상)"));
		leftPane06.add(p06_1);

		JPanel p06_2 = new JPanel();
		p06_2.add(new JLabel("      5명"));
		leftPane06.add(p06_2);

		JPanel p06_3 = new JPanel();
		p06_3.add(new JLabel("      4명"));
		leftPane06.add(p06_3);

		JPanel p06_4 = new JPanel();
		p06_4.add(new JLabel("      3명"));
		leftPane06.add(p06_4);

		JPanel p06_5 = new JPanel();
		p06_5.add(new JLabel("      2명"));
		leftPane06.add(p06_5);

		JPanel p06_6 = new JPanel();
		p06_6.add(new JLabel("      1명"));
		leftPane06.add(p06_6);

		JPanel p06_7 = new JPanel();
		p06_7.add(new JLabel("[확진자]"));
		leftPane06.add(p06_7);

		leftWall01.add(leftPane01);
		leftPane01.add(p01_1);
		leftPane01.add(p01_2);
		leftPane01.add(p01_3);
		leftPane01.add(p01_4);
		leftPane01.add(p01_5);
		leftPane01.add(p01_6);

		if (Dao.peo20 >= 6) {
			p01_1.setBackground(GG_COLOR);
			p01_2.setBackground(GG_COLOR);
			p01_3.setBackground(GG_COLOR);
			p01_4.setBackground(GG_COLOR);
			p01_5.setBackground(GG_COLOR);
			p01_6.setBackground(GG_COLOR);
		}
		if (Dao.peo20 == 5) {
			p01_1.setBackground(Color.LIGHT_GRAY);
			p01_2.setBackground(GG_COLOR);
			p01_3.setBackground(GG_COLOR);
			p01_4.setBackground(GG_COLOR);
			p01_5.setBackground(GG_COLOR);
			p01_6.setBackground(GG_COLOR);
		}
		if (Dao.peo20 == 4) {
			p01_1.setBackground(Color.LIGHT_GRAY);
			p01_2.setBackground(Color.LIGHT_GRAY);
			p01_3.setBackground(GG_COLOR);
			p01_4.setBackground(GG_COLOR);
			p01_5.setBackground(GG_COLOR);
			p01_6.setBackground(GG_COLOR);
		}
		if (Dao.peo20 == 3) {
			p01_1.setBackground(Color.LIGHT_GRAY);
			p01_2.setBackground(Color.LIGHT_GRAY);
			p01_3.setBackground(Color.LIGHT_GRAY);
			p01_4.setBackground(GG_COLOR);
			p01_5.setBackground(GG_COLOR);
			p01_6.setBackground(GG_COLOR);
		}
		if (Dao.peo20 == 2) {
			p01_1.setBackground(Color.LIGHT_GRAY);
			p01_2.setBackground(Color.LIGHT_GRAY);
			p01_3.setBackground(Color.LIGHT_GRAY);
			p01_4.setBackground(Color.LIGHT_GRAY);
			p01_5.setBackground(GG_COLOR);
			p01_6.setBackground(GG_COLOR);
		}
		if (Dao.peo20 == 1) {
			p01_1.setBackground(Color.LIGHT_GRAY);
			p01_2.setBackground(Color.LIGHT_GRAY);
			p01_3.setBackground(Color.LIGHT_GRAY);
			p01_4.setBackground(Color.LIGHT_GRAY);
			p01_5.setBackground(Color.LIGHT_GRAY);
			p01_6.setBackground(GG_COLOR);
		}
		if (Dao.peo20 == 0) {
			p01_1.setBackground(Color.LIGHT_GRAY);
			p01_2.setBackground(Color.LIGHT_GRAY);
			p01_3.setBackground(Color.LIGHT_GRAY);
			p01_4.setBackground(Color.LIGHT_GRAY);
			p01_5.setBackground(Color.LIGHT_GRAY);
			p01_6.setBackground(Color.LIGHT_GRAY);
		}
		lbl20Count.setText(String.valueOf(Dao.peo20));

		JPanel p01_7 = new JPanel();
		p01_7.add(new JLabel("~20세:"));
		p01_7.add(lbl20Count);
		leftPane01.add(p01_7);
		///////////

		leftWall01.add(leftPane02);
		leftPane02.add(p02_1);
		leftPane02.add(p02_2);
		leftPane02.add(p02_3);
		leftPane02.add(p02_4);
		leftPane02.add(p02_5);
		leftPane02.add(p02_6);

		if (Dao.peo40 >= 6) {
			p02_1.setBackground(GG_COLOR);
			p02_2.setBackground(GG_COLOR);
			p02_3.setBackground(GG_COLOR);
			p02_4.setBackground(GG_COLOR);
			p02_5.setBackground(GG_COLOR);
			p02_6.setBackground(GG_COLOR);
		}
		if (Dao.peo40 == 5) {
			p02_1.setBackground(Color.LIGHT_GRAY);
			p02_2.setBackground(GG_COLOR);
			p02_3.setBackground(GG_COLOR);
			p02_4.setBackground(GG_COLOR);
			p02_5.setBackground(GG_COLOR);
			p02_6.setBackground(GG_COLOR);
		}
		if (Dao.peo40 == 4) {
			p02_1.setBackground(Color.LIGHT_GRAY);
			p02_2.setBackground(Color.LIGHT_GRAY);
			p02_3.setBackground(GG_COLOR);
			p02_4.setBackground(GG_COLOR);
			p02_5.setBackground(GG_COLOR);
			p02_6.setBackground(GG_COLOR);
		}
		if (Dao.peo40 == 3) {
			p02_1.setBackground(Color.LIGHT_GRAY);
			p02_2.setBackground(Color.LIGHT_GRAY);
			p02_3.setBackground(Color.LIGHT_GRAY);
			p02_4.setBackground(GG_COLOR);
			p02_5.setBackground(GG_COLOR);
			p02_6.setBackground(GG_COLOR);
		}
		if (Dao.peo40 == 2) {
			p02_1.setBackground(Color.LIGHT_GRAY);
			p02_2.setBackground(Color.LIGHT_GRAY);
			p02_3.setBackground(Color.LIGHT_GRAY);
			p02_4.setBackground(Color.LIGHT_GRAY);
			p02_5.setBackground(GG_COLOR);
			p02_6.setBackground(GG_COLOR);
		}
		if (Dao.peo40 == 1) {
			p02_1.setBackground(Color.LIGHT_GRAY);
			p02_2.setBackground(Color.LIGHT_GRAY);
			p02_3.setBackground(Color.LIGHT_GRAY);
			p02_4.setBackground(Color.LIGHT_GRAY);
			p02_5.setBackground(Color.LIGHT_GRAY);
			p02_6.setBackground(GG_COLOR);
		}
		if (Dao.peo40 == 0) {
			p02_1.setBackground(Color.LIGHT_GRAY);
			p02_2.setBackground(Color.LIGHT_GRAY);
			p02_3.setBackground(Color.LIGHT_GRAY);
			p02_4.setBackground(Color.LIGHT_GRAY);
			p02_5.setBackground(Color.LIGHT_GRAY);
			p02_6.setBackground(Color.LIGHT_GRAY);
		}
		lbl40Count.setText(String.valueOf(Dao.peo40));

		JPanel p02_7 = new JPanel();
		p02_7.add(new JLabel("~40세:"));
		p02_7.add(lbl40Count);
		leftPane02.add(p02_7);
		//////////////

		leftWall01.add(leftPane03);

		leftPane03.add(p03_1);
		leftPane03.add(p03_2);
		leftPane03.add(p03_3);
		leftPane03.add(p03_4);
		leftPane03.add(p03_5);
		leftPane03.add(p03_6);

		if (Dao.peo60 >= 6) {
			p03_1.setBackground(GG_COLOR);
			p03_2.setBackground(GG_COLOR);
			p03_3.setBackground(GG_COLOR);
			p03_4.setBackground(GG_COLOR);
			p03_5.setBackground(GG_COLOR);
			p03_6.setBackground(GG_COLOR);
		}
		if (Dao.peo60 == 5) {
			p03_1.setBackground(Color.LIGHT_GRAY);
			p03_2.setBackground(GG_COLOR);
			p03_3.setBackground(GG_COLOR);
			p03_4.setBackground(GG_COLOR);
			p03_5.setBackground(GG_COLOR);
			p03_6.setBackground(GG_COLOR);
		}
		if (Dao.peo60 == 4) {
			p03_1.setBackground(Color.LIGHT_GRAY);
			p03_2.setBackground(Color.LIGHT_GRAY);
			p03_3.setBackground(GG_COLOR);
			p03_4.setBackground(GG_COLOR);
			p03_5.setBackground(GG_COLOR);
			p03_6.setBackground(GG_COLOR);
		}
		if (Dao.peo60 == 3) {
			p03_1.setBackground(Color.LIGHT_GRAY);
			p03_2.setBackground(Color.LIGHT_GRAY);
			p03_3.setBackground(Color.LIGHT_GRAY);
			p03_4.setBackground(GG_COLOR);
			p03_5.setBackground(GG_COLOR);
			p03_6.setBackground(GG_COLOR);
		}
		if (Dao.peo60 == 2) {
			p03_1.setBackground(Color.LIGHT_GRAY);
			p03_2.setBackground(Color.LIGHT_GRAY);
			p03_3.setBackground(Color.LIGHT_GRAY);
			p03_4.setBackground(Color.LIGHT_GRAY);
			p03_5.setBackground(GG_COLOR);
			p03_6.setBackground(GG_COLOR);
		}
		if (Dao.peo60 == 1) {
			p03_1.setBackground(Color.LIGHT_GRAY);
			p03_2.setBackground(Color.LIGHT_GRAY);
			p03_3.setBackground(Color.LIGHT_GRAY);
			p03_4.setBackground(Color.LIGHT_GRAY);
			p03_5.setBackground(Color.LIGHT_GRAY);
			p03_6.setBackground(GG_COLOR);
		}
		if (Dao.peo60 == 0) {
			p03_1.setBackground(Color.LIGHT_GRAY);
			p03_2.setBackground(Color.LIGHT_GRAY);
			p03_3.setBackground(Color.LIGHT_GRAY);
			p03_4.setBackground(Color.LIGHT_GRAY);
			p03_5.setBackground(Color.LIGHT_GRAY);
			p03_6.setBackground(Color.LIGHT_GRAY);
		}
		lbl60Count.setText(String.valueOf(Dao.peo60));

		JPanel p03_7 = new JPanel();
		p03_7.add(new JLabel("~60세:"));
		p03_7.add(lbl60Count);
		leftPane03.add(p03_7);
		//////////////

		leftWall01.add(leftPane04);

		leftPane04.add(p04_1);
		leftPane04.add(p04_2);
		leftPane04.add(p04_3);
		leftPane04.add(p04_4);
		leftPane04.add(p04_5);
		leftPane04.add(p04_6);

		if (Dao.peo80 >= 6) {
			p04_1.setBackground(GG_COLOR);
			p04_2.setBackground(GG_COLOR);
			p04_3.setBackground(GG_COLOR);
			p04_4.setBackground(GG_COLOR);
			p04_5.setBackground(GG_COLOR);
			p04_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80 == 5) {
			p04_1.setBackground(Color.LIGHT_GRAY);
			p04_2.setBackground(GG_COLOR);
			p04_3.setBackground(GG_COLOR);
			p04_4.setBackground(GG_COLOR);
			p04_5.setBackground(GG_COLOR);
			p04_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80 == 4) {
			p04_1.setBackground(Color.LIGHT_GRAY);
			p04_2.setBackground(Color.LIGHT_GRAY);
			p04_3.setBackground(GG_COLOR);
			p04_4.setBackground(GG_COLOR);
			p04_5.setBackground(GG_COLOR);
			p04_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80 == 3) {
			p04_1.setBackground(Color.LIGHT_GRAY);
			p04_2.setBackground(Color.LIGHT_GRAY);
			p04_3.setBackground(Color.LIGHT_GRAY);
			p04_4.setBackground(GG_COLOR);
			p04_5.setBackground(GG_COLOR);
			p04_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80 == 2) {
			p04_1.setBackground(Color.LIGHT_GRAY);
			p04_2.setBackground(Color.LIGHT_GRAY);
			p04_3.setBackground(Color.LIGHT_GRAY);
			p04_4.setBackground(Color.LIGHT_GRAY);
			p04_5.setBackground(GG_COLOR);
			p04_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80 == 1) {
			p04_1.setBackground(Color.LIGHT_GRAY);
			p04_2.setBackground(Color.LIGHT_GRAY);
			p04_3.setBackground(Color.LIGHT_GRAY);
			p04_4.setBackground(Color.LIGHT_GRAY);
			p04_5.setBackground(Color.LIGHT_GRAY);
			p04_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80 == 0) {
			p04_1.setBackground(Color.LIGHT_GRAY);
			p04_2.setBackground(Color.LIGHT_GRAY);
			p04_3.setBackground(Color.LIGHT_GRAY);
			p04_4.setBackground(Color.LIGHT_GRAY);
			p04_5.setBackground(Color.LIGHT_GRAY);
			p04_6.setBackground(Color.LIGHT_GRAY);
		}
		lbl80Count.setText(String.valueOf(Dao.peo80));

		JPanel p04_7 = new JPanel();
		p04_7.add(new JLabel("~80세:"));
		p04_7.add(lbl80Count);
		leftPane04.add(p04_7);
		//////////////

		leftWall01.add(leftPane05);

		leftPane05.add(p05_1);
		leftPane05.add(p05_2);
		leftPane05.add(p05_3);
		leftPane05.add(p05_4);
		leftPane05.add(p05_5);
		leftPane05.add(p05_6);

		if (Dao.peo80up >= 6) {
			p05_1.setBackground(GG_COLOR);
			p05_2.setBackground(GG_COLOR);
			p05_3.setBackground(GG_COLOR);
			p05_4.setBackground(GG_COLOR);
			p05_5.setBackground(GG_COLOR);
			p05_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80up == 5) {
			p05_1.setBackground(Color.LIGHT_GRAY);
			p05_2.setBackground(GG_COLOR);
			p05_3.setBackground(GG_COLOR);
			p05_4.setBackground(GG_COLOR);
			p05_5.setBackground(GG_COLOR);
			p05_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80up == 4) {
			p05_1.setBackground(Color.LIGHT_GRAY);
			p05_2.setBackground(Color.LIGHT_GRAY);
			p05_3.setBackground(GG_COLOR);
			p05_4.setBackground(GG_COLOR);
			p05_5.setBackground(GG_COLOR);
			p05_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80up == 3) {
			p05_1.setBackground(Color.LIGHT_GRAY);
			p05_2.setBackground(Color.LIGHT_GRAY);
			p05_3.setBackground(Color.LIGHT_GRAY);
			p05_4.setBackground(GG_COLOR);
			p05_5.setBackground(GG_COLOR);
			p05_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80up == 2) {
			p05_1.setBackground(Color.LIGHT_GRAY);
			p05_2.setBackground(Color.LIGHT_GRAY);
			p05_3.setBackground(Color.LIGHT_GRAY);
			p05_4.setBackground(Color.LIGHT_GRAY);
			p05_5.setBackground(GG_COLOR);
			p05_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80up == 1) {
			p05_1.setBackground(Color.LIGHT_GRAY);
			p05_2.setBackground(Color.LIGHT_GRAY);
			p05_3.setBackground(Color.LIGHT_GRAY);
			p05_4.setBackground(Color.LIGHT_GRAY);
			p05_5.setBackground(Color.LIGHT_GRAY);
			p05_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80up == 0) {
			p05_1.setBackground(Color.LIGHT_GRAY);
			p05_2.setBackground(Color.LIGHT_GRAY);
			p05_3.setBackground(Color.LIGHT_GRAY);
			p05_4.setBackground(Color.LIGHT_GRAY);
			p05_5.setBackground(Color.LIGHT_GRAY);
			p05_6.setBackground(Color.LIGHT_GRAY);
		}
		lbl80upCount.setText(String.valueOf(Dao.peo80up));

		JPanel p05_7 = new JPanel();
		p05_7.add(new JLabel("81세~:"));
		p05_7.add(lbl80upCount);
		leftPane05.add(p05_7);
		//////////////
		leftWall01.add(leftPane07);

		// 확진자 / 정상인 / 확진자 평균나이
		
		////////////////// 정상개수
		goodCount.setText(String.valueOf(Dao.goodValue));
		JPanel pgv = new JPanel();
		pgv.add(new JLabel("정상자: "));
		pgv.add(goodCount);
		leftValuePane.add(pgv);
		//////////////

		////////////////// 확진개수
		badCount.setText(String.valueOf(Dao.badValue));
		JPanel pbv = new JPanel();
		pbv.add(new JLabel("/ 확진자: "));
		pbv.add(badCount);
		leftValuePane.add(pbv);
		//////////////

		// 확진자 평균나이
		lblAvg.setText(String.valueOf(form.format(Dao.avgValue)));

		JPanel bagAgeAvg = new JPanel();
		bagAgeAvg.add(new JLabel("/ 확진자 평균나이 : "));
		bagAgeAvg.add(lblAvg);
		bagAgeAvg.add(new JLabel("세"));
		leftValuePane.add(bagAgeAvg);
		/////

		/// 2tab
		roomWall01.add(roomP01);

		JPanel r01_1 = new JPanel();
		r01_1.add(new JLabel("4석(만석)"));
		roomP01.add(r01_1);

		JPanel p01_2 = new JPanel();
		p01_2.add(new JLabel("      3석"));
		roomP01.add(p01_2);

		JPanel r01_3 = new JPanel();
		r01_3.add(new JLabel("      2석"));
		roomP01.add(r01_3);

		JPanel r01_4 = new JPanel();
		r01_4.add(new JLabel("      1석"));
		roomP01.add(r01_4);

		JPanel r01_5 = new JPanel();
		r01_5.add(new JLabel("  [병실]"));
		roomP01.add(r01_5);

		roomWall01.add(roomP02);
		roomP02.add(r02_1);
		roomP02.add(r02_2);
		roomP02.add(r02_3);
		roomP02.add(r02_4);
		if (Dao.room01 == 4) {
			r02_1.add(new JLabel(bedUseImage));
			r02_2.add(new JLabel(bedUseImage));
			r02_3.add(new JLabel(bedUseImage));
			r02_4.add(new JLabel(bedUseImage));
		}else if (Dao.room01 == 3) {
			r02_1.add(new JLabel(bedEmptyImage));
			r02_2.add(new JLabel(bedUseImage));
			r02_3.add(new JLabel(bedUseImage));
			r02_4.add(new JLabel(bedUseImage));
		}else if (Dao.room01 == 2) {
			r02_1.add(new JLabel(bedEmptyImage));
			r02_2.add(new JLabel(bedEmptyImage));
			r02_3.add(new JLabel(bedUseImage));
			r02_4.add(new JLabel(bedUseImage));
		}else if (Dao.room01 == 1) {
			r02_1.add(new JLabel(bedEmptyImage));
			r02_2.add(new JLabel(bedEmptyImage));
			r02_3.add(new JLabel(bedEmptyImage));
			r02_4.add(new JLabel(bedUseImage));
		}else if (Dao.room01 == 0) {
			r02_1.add(new JLabel(bedEmptyImage));
			r02_2.add(new JLabel(bedEmptyImage));
			r02_3.add(new JLabel(bedEmptyImage));
			r02_4.add(new JLabel(bedEmptyImage));
		}
		
		lblroom01C.setText(String.valueOf(Dao.room01));
		r02_5.add(new JLabel("1호실:"));
		if(Dao.room01==4) {
			r02_5.add(new JLabel("만석"));
		}else if(Dao.room01==0) {
			r02_5.add(new JLabel("공석"));
		}else {
			r02_5.add(lblroom01C);
			r02_5.add(new JLabel("명"));
		}
		roomP02.add(r02_5);
		
		//2호실
		roomWall01.add(roomP03);
		roomP03.add(r03_1);
		roomP03.add(r03_2);
		roomP03.add(r03_3);
		roomP03.add(r03_4);
		if (Dao.room02 == 4) {
			r03_1.add(new JLabel(bedUseImage));
			r03_2.add(new JLabel(bedUseImage));
			r03_3.add(new JLabel(bedUseImage));
			r03_4.add(new JLabel(bedUseImage));
		}else if (Dao.room02 == 3) {
			r03_1.add(new JLabel(bedEmptyImage));  
			r03_2.add(bedUse02);    
			r03_3.add(new JLabel(bedUseImage));    
			r03_4.add(new JLabel(bedUseImage));    
		}else if (Dao.room02 == 2) {
			r03_1.add(new JLabel(bedEmptyImage));
			r03_2.add(new JLabel(bedEmptyImage));
			r03_3.add(new JLabel(bedUseImage));  
			r03_4.add(new JLabel(bedUseImage));  
		}else if (Dao.room02 == 1) {
			r03_1.add(new JLabel(bedEmptyImage));
			r03_2.add(new JLabel(bedEmptyImage));
			r03_3.add(new JLabel(bedEmptyImage));
			r03_4.add(new JLabel(bedUseImage));  
		}else if (Dao.room02 == 0) {
			r03_1.add(new JLabel(bedEmptyImage));
			r03_2.add(new JLabel(bedEmptyImage));
			r03_3.add(new JLabel(bedEmptyImage));
			r03_4.add(new JLabel(bedEmptyImage));
		}
		
		lblroom02C.setText(String.valueOf(Dao.room02));
		r03_5.add(new JLabel("2호실:"));
		if(Dao.room02==4) {
			r03_5.add(new JLabel("만석"));
		}else if(Dao.room02==0) {
			r03_5.add(new JLabel("공석"));
		}else {
			r03_5.add(lblroom02C);
			r03_5.add(new JLabel("명"));
		}
		roomP03.add(r03_5);
		
		//3호실
		roomWall01.add(roomP04);
		roomP04.add(r04_1);
		roomP04.add(r04_2);
		roomP04.add(r04_3);
		roomP04.add(r04_4);
		if (Dao.room03 == 4) {
			r04_1.add(new JLabel(bedUseImage));
			r04_2.add(bedUse02);
			r04_3.add(new JLabel(bedUseImage));
			r04_4.add(new JLabel(bedUseImage));
		}else if (Dao.room03 == 3) {
			r04_1.add(new JLabel(bedEmptyImage));  
			r04_2.add(bedUse02);    
			r04_3.add(new JLabel(bedUseImage));    
			r04_4.add(new JLabel(bedUseImage));    
		}else if (Dao.room03 == 2) {
			r04_1.add(new JLabel(bedEmptyImage));
			r04_2.add(new JLabel(bedEmptyImage));
			r04_3.add(new JLabel(bedUseImage));  
			r04_4.add(new JLabel(bedUseImage));  
		}else if (Dao.room03 == 1) {
			r04_1.add(new JLabel(bedEmptyImage));
			r04_2.add(new JLabel(bedEmptyImage));
			r04_3.add(new JLabel(bedEmptyImage));
			r04_4.add(new JLabel(bedUseImage));  
		}else if (Dao.room03 == 0) {
			r04_1.add(new JLabel(bedEmptyImage));
			r04_2.add(new JLabel(bedEmptyImage));
			r04_3.add(new JLabel(bedEmptyImage));
			r04_4.add(new JLabel(bedEmptyImage));
		}
		lblroom03C.setText(String.valueOf(Dao.room03));
		r04_5.add(new JLabel("3호실:"));
		if(Dao.room03==4) {
			r04_5.add(new JLabel("만석"));
		}else if(Dao.room03==0) {
			r04_5.add(new JLabel("공석"));
		}else {
			r04_5.add(lblroom03C);
			r04_5.add(new JLabel("명"));
		}
		roomP04.add(r04_5);
		//오른쪽 여백
		roomWall01.add(roomP05);
		
		
		//확진자 /입원환자 /타병원
		badCount.setText(String.valueOf(Dao.badValue));
		JPanel tab01v01 = new JPanel();
		tab01v01.add(new JLabel("확진자: "));
		tab01v01.add(badCount);
		leftRoomPane.add(tab01v01);
		
		lblroomMember.setText(String.valueOf(Dao.room01+Dao.room02+Dao.room03));
		JPanel tab01v02 = new JPanel();
		tab01v02.add(new JLabel("/ 입원환자: "));
		tab01v02.add(lblroomMember);
		leftRoomPane.add(tab01v02);
		
		lblroomNotMember.setText(String.valueOf(Dao.badValue-(Dao.room01+Dao.room02+Dao.room03)));
		JPanel tab01v03 = new JPanel();
		tab01v03.add(new JLabel("/ 타병원: "));
		tab01v03.add(lblroomNotMember);
		leftRoomPane.add(tab01v03);
		
		
		
	}

	public void redisplay() {
		Dao.peo20 = 0;
		Dao.peo40 = 0;
		Dao.peo60 = 0;
		Dao.peo80 = 0;
		Dao.peo80up = 0;
		
		Dao.goodValue = 0;
		Dao.badValue = 0;
		Dao.avgValue = 0;
		Dao.valueC = 0;
		
		Dao.room01 = 0;
		Dao.room02 = 0;
		Dao.room03 = 0;
		
		Dao.loadOldCount();
		Dao.loadValueCount();
		Dao.loadDataAvg();
		Dao.loadDataRoomCount();

		if (Dao.peo20 >= 6) {
			p01_1.setBackground(GG_COLOR);
			p01_2.setBackground(GG_COLOR);
			p01_3.setBackground(GG_COLOR);
			p01_4.setBackground(GG_COLOR);
			p01_5.setBackground(GG_COLOR);
			p01_6.setBackground(GG_COLOR);

		}
		if (Dao.peo20 == 5) {
			p01_1.setBackground(Color.LIGHT_GRAY);
			p01_2.setBackground(GG_COLOR);
			p01_3.setBackground(GG_COLOR);
			p01_4.setBackground(GG_COLOR);
			p01_5.setBackground(GG_COLOR);
			p01_6.setBackground(GG_COLOR);
		}
		if (Dao.peo20 == 4) {
			p01_1.setBackground(Color.LIGHT_GRAY);
			p01_2.setBackground(Color.LIGHT_GRAY);
			p01_3.setBackground(GG_COLOR);
			p01_4.setBackground(GG_COLOR);
			p01_5.setBackground(GG_COLOR);
			p01_6.setBackground(GG_COLOR);
		}
		if (Dao.peo20 == 3) {
			p01_1.setBackground(Color.LIGHT_GRAY);
			p01_2.setBackground(Color.LIGHT_GRAY);
			p01_3.setBackground(Color.LIGHT_GRAY);
			p01_4.setBackground(GG_COLOR);
			p01_5.setBackground(GG_COLOR);
			p01_6.setBackground(GG_COLOR);
		}
		if (Dao.peo20 == 2) {
			p01_1.setBackground(Color.LIGHT_GRAY);
			p01_2.setBackground(Color.LIGHT_GRAY);
			p01_3.setBackground(Color.LIGHT_GRAY);
			p01_4.setBackground(Color.LIGHT_GRAY);
			p01_5.setBackground(GG_COLOR);
			p01_6.setBackground(GG_COLOR);
		}
		if (Dao.peo20 == 1) {
			p01_1.setBackground(Color.LIGHT_GRAY);
			p01_2.setBackground(Color.LIGHT_GRAY);
			p01_3.setBackground(Color.LIGHT_GRAY);
			p01_4.setBackground(Color.LIGHT_GRAY);
			p01_5.setBackground(Color.LIGHT_GRAY);
			p01_6.setBackground(GG_COLOR);
		}
		if (Dao.peo20 == 0) {
			p01_1.setBackground(Color.LIGHT_GRAY);
			p01_2.setBackground(Color.LIGHT_GRAY);
			p01_3.setBackground(Color.LIGHT_GRAY);
			p01_4.setBackground(Color.LIGHT_GRAY);
			p01_5.setBackground(Color.LIGHT_GRAY);
			p01_6.setBackground(Color.LIGHT_GRAY);
		}

		///////////
		lbl20Count.setText(String.valueOf(Dao.peo20));

		///////////

		if (Dao.peo40 >= 6) {
			p02_1.setBackground(GG_COLOR);
			p02_2.setBackground(GG_COLOR);
			p02_3.setBackground(GG_COLOR);
			p02_4.setBackground(GG_COLOR);
			p02_5.setBackground(GG_COLOR);
			p02_6.setBackground(GG_COLOR);
		}
		if (Dao.peo40 == 5) {
			p02_1.setBackground(Color.LIGHT_GRAY);
			p02_2.setBackground(GG_COLOR);
			p02_3.setBackground(GG_COLOR);
			p02_4.setBackground(GG_COLOR);
			p02_5.setBackground(GG_COLOR);
			p02_6.setBackground(GG_COLOR);
		}
		if (Dao.peo40 == 4) {
			p02_1.setBackground(Color.LIGHT_GRAY);
			p02_2.setBackground(Color.LIGHT_GRAY);
			p02_3.setBackground(GG_COLOR);
			p02_4.setBackground(GG_COLOR);
			p02_5.setBackground(GG_COLOR);
			p02_6.setBackground(GG_COLOR);
		}
		if (Dao.peo40 == 3) {
			p02_1.setBackground(Color.LIGHT_GRAY);
			p02_2.setBackground(Color.LIGHT_GRAY);
			p02_3.setBackground(Color.LIGHT_GRAY);
			p02_4.setBackground(GG_COLOR);
			p02_5.setBackground(GG_COLOR);
			p02_6.setBackground(GG_COLOR);
		}
		if (Dao.peo40 == 2) {
			p02_1.setBackground(Color.LIGHT_GRAY);
			p02_2.setBackground(Color.LIGHT_GRAY);
			p02_3.setBackground(Color.LIGHT_GRAY);
			p02_4.setBackground(Color.LIGHT_GRAY);
			p02_5.setBackground(GG_COLOR);
			p02_6.setBackground(GG_COLOR);
		}
		if (Dao.peo40 == 1) {
			p02_1.setBackground(Color.LIGHT_GRAY);
			p02_2.setBackground(Color.LIGHT_GRAY);
			p02_3.setBackground(Color.LIGHT_GRAY);
			p02_4.setBackground(Color.LIGHT_GRAY);
			p02_5.setBackground(Color.LIGHT_GRAY);
			p02_6.setBackground(GG_COLOR);
		}
		if (Dao.peo40 == 0) {
			p02_1.setBackground(Color.LIGHT_GRAY);
			p02_2.setBackground(Color.LIGHT_GRAY);
			p02_3.setBackground(Color.LIGHT_GRAY);
			p02_4.setBackground(Color.LIGHT_GRAY);
			p02_5.setBackground(Color.LIGHT_GRAY);
			p02_6.setBackground(Color.LIGHT_GRAY);
		}

		////////////////
		lbl40Count.setText(String.valueOf(Dao.peo40));

		if (Dao.peo60 >= 6) {
			p03_1.setBackground(GG_COLOR);
			p03_2.setBackground(GG_COLOR);
			p03_3.setBackground(GG_COLOR);
			p03_4.setBackground(GG_COLOR);
			p03_5.setBackground(GG_COLOR);
			p03_6.setBackground(GG_COLOR);
		}
		if (Dao.peo60 == 5) {
			p03_1.setBackground(Color.LIGHT_GRAY);
			p03_2.setBackground(GG_COLOR);
			p03_3.setBackground(GG_COLOR);
			p03_4.setBackground(GG_COLOR);
			p03_5.setBackground(GG_COLOR);
			p03_6.setBackground(GG_COLOR);
		}
		if (Dao.peo60 == 4) {
			p03_1.setBackground(Color.LIGHT_GRAY);
			p03_2.setBackground(Color.LIGHT_GRAY);
			p03_3.setBackground(GG_COLOR);
			p03_4.setBackground(GG_COLOR);
			p03_5.setBackground(GG_COLOR);
			p03_6.setBackground(GG_COLOR);
		}
		if (Dao.peo60 == 3) {
			p03_1.setBackground(Color.LIGHT_GRAY);
			p03_2.setBackground(Color.LIGHT_GRAY);
			p03_3.setBackground(Color.LIGHT_GRAY);
			p03_4.setBackground(GG_COLOR);
			p03_5.setBackground(GG_COLOR);
			p03_6.setBackground(GG_COLOR);
		}
		if (Dao.peo60 == 2) {
			p03_1.setBackground(Color.LIGHT_GRAY);
			p03_2.setBackground(Color.LIGHT_GRAY);
			p03_3.setBackground(Color.LIGHT_GRAY);
			p03_4.setBackground(Color.LIGHT_GRAY);
			p03_5.setBackground(GG_COLOR);
			p03_6.setBackground(GG_COLOR);
		}
		if (Dao.peo60 == 1) {
			p03_1.setBackground(Color.LIGHT_GRAY);
			p03_2.setBackground(Color.LIGHT_GRAY);
			p03_3.setBackground(Color.LIGHT_GRAY);
			p03_4.setBackground(Color.LIGHT_GRAY);
			p03_5.setBackground(Color.LIGHT_GRAY);
			p03_6.setBackground(GG_COLOR);
		}
		if (Dao.peo60 == 0) {
			p03_1.setBackground(Color.LIGHT_GRAY);
			p03_2.setBackground(Color.LIGHT_GRAY);
			p03_3.setBackground(Color.LIGHT_GRAY);
			p03_4.setBackground(Color.LIGHT_GRAY);
			p03_5.setBackground(Color.LIGHT_GRAY);
			p03_6.setBackground(Color.LIGHT_GRAY);
		}
		////////////////
		lbl60Count.setText(String.valueOf(Dao.peo60));

		if (Dao.peo80 >= 6) {
			p04_1.setBackground(GG_COLOR);
			p04_2.setBackground(GG_COLOR);
			p04_3.setBackground(GG_COLOR);
			p04_4.setBackground(GG_COLOR);
			p04_5.setBackground(GG_COLOR);
			p04_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80 == 5) {
			p04_1.setBackground(Color.LIGHT_GRAY);
			p04_2.setBackground(GG_COLOR);
			p04_3.setBackground(GG_COLOR);
			p04_4.setBackground(GG_COLOR);
			p04_5.setBackground(GG_COLOR);
			p04_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80 == 4) {
			p04_1.setBackground(Color.LIGHT_GRAY);
			p04_2.setBackground(Color.LIGHT_GRAY);
			p04_3.setBackground(GG_COLOR);
			p04_4.setBackground(GG_COLOR);
			p04_5.setBackground(GG_COLOR);
			p04_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80 == 3) {
			p04_1.setBackground(Color.LIGHT_GRAY);
			p04_2.setBackground(Color.LIGHT_GRAY);
			p04_3.setBackground(Color.LIGHT_GRAY);
			p04_4.setBackground(GG_COLOR);
			p04_5.setBackground(GG_COLOR);
			p04_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80 == 2) {
			p04_1.setBackground(Color.LIGHT_GRAY);
			p04_2.setBackground(Color.LIGHT_GRAY);
			p04_3.setBackground(Color.LIGHT_GRAY);
			p04_4.setBackground(Color.LIGHT_GRAY);
			p04_5.setBackground(GG_COLOR);
			p04_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80 == 1) {
			p04_1.setBackground(Color.LIGHT_GRAY);
			p04_2.setBackground(Color.LIGHT_GRAY);
			p04_3.setBackground(Color.LIGHT_GRAY);
			p04_4.setBackground(Color.LIGHT_GRAY);
			p04_5.setBackground(Color.LIGHT_GRAY);
			p04_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80 == 0) {
			p04_1.setBackground(Color.LIGHT_GRAY);
			p04_2.setBackground(Color.LIGHT_GRAY);
			p04_3.setBackground(Color.LIGHT_GRAY);
			p04_4.setBackground(Color.LIGHT_GRAY);
			p04_5.setBackground(Color.LIGHT_GRAY);
			p04_6.setBackground(Color.LIGHT_GRAY);
		}

		////////////////
		lbl80Count.setText(String.valueOf(Dao.peo80));

		/////

		if (Dao.peo80up >= 6) {
			p05_1.setBackground(GG_COLOR);
			p05_2.setBackground(GG_COLOR);
			p05_3.setBackground(GG_COLOR);
			p05_4.setBackground(GG_COLOR);
			p05_5.setBackground(GG_COLOR);
			p05_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80up == 5) {
			p05_1.setBackground(Color.LIGHT_GRAY);
			p05_2.setBackground(GG_COLOR);
			p05_3.setBackground(GG_COLOR);
			p05_4.setBackground(GG_COLOR);
			p05_5.setBackground(GG_COLOR);
			p05_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80up == 4) {
			p05_1.setBackground(Color.LIGHT_GRAY);
			p05_2.setBackground(Color.LIGHT_GRAY);
			p05_3.setBackground(GG_COLOR);
			p05_4.setBackground(GG_COLOR);
			p05_5.setBackground(GG_COLOR);
			p05_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80up == 3) {
			p05_1.setBackground(Color.LIGHT_GRAY);
			p05_2.setBackground(Color.LIGHT_GRAY);
			p05_3.setBackground(Color.LIGHT_GRAY);
			p05_4.setBackground(GG_COLOR);
			p05_5.setBackground(GG_COLOR);
			p05_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80up == 2) {
			p05_1.setBackground(Color.LIGHT_GRAY);
			p05_2.setBackground(Color.LIGHT_GRAY);
			p05_3.setBackground(Color.LIGHT_GRAY);
			p05_4.setBackground(Color.LIGHT_GRAY);
			p05_5.setBackground(GG_COLOR);
			p05_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80up == 1) {
			p05_1.setBackground(Color.LIGHT_GRAY);
			p05_2.setBackground(Color.LIGHT_GRAY);
			p05_3.setBackground(Color.LIGHT_GRAY);
			p05_4.setBackground(Color.LIGHT_GRAY);
			p05_5.setBackground(Color.LIGHT_GRAY);
			p05_6.setBackground(GG_COLOR);
		}
		if (Dao.peo80up == 0) {
			p05_1.setBackground(Color.LIGHT_GRAY);
			p05_2.setBackground(Color.LIGHT_GRAY);
			p05_3.setBackground(Color.LIGHT_GRAY);
			p05_4.setBackground(Color.LIGHT_GRAY);
			p05_5.setBackground(Color.LIGHT_GRAY);
			p05_6.setBackground(Color.LIGHT_GRAY);
		}
		lbl80upCount.setText(String.valueOf(Dao.peo80up));

		goodCount.setText(String.valueOf(Dao.goodValue));

		badCount.setText(String.valueOf(Dao.badValue));

		lblAvg.setText(String.valueOf(form.format(Dao.avgValue)));
		
		
		r02_1.removeAll();
		r02_2.removeAll();
		r02_3.removeAll();
		r02_4.removeAll();
		if (Dao.room01 == 4) {
			r02_1.add(new JLabel(bedUseImage));
			r02_2.add(new JLabel(bedUseImage));
			r02_3.add(new JLabel(bedUseImage));
			r02_4.add(new JLabel(bedUseImage));
		}else if (Dao.room01 == 3) {
			r02_1.add(new JLabel(bedEmptyImage));
			r02_2.add(new JLabel(bedUseImage));
			r02_3.add(new JLabel(bedUseImage));
			r02_4.add(new JLabel(bedUseImage));
		}else if (Dao.room01 == 2) {
			r02_1.add(new JLabel(bedEmptyImage));
			r02_2.add(new JLabel(bedEmptyImage));
			r02_3.add(new JLabel(bedUseImage));
			r02_4.add(new JLabel(bedUseImage));
		}else if (Dao.room01 == 1) {
			r02_1.add(new JLabel(bedEmptyImage));
			r02_2.add(new JLabel(bedEmptyImage));
			r02_3.add(new JLabel(bedEmptyImage));
			r02_4.add(new JLabel(bedUseImage));
		}else if (Dao.room01 == 0) {
			r02_1.add(new JLabel(bedEmptyImage));
			r02_2.add(new JLabel(bedEmptyImage));
			r02_3.add(new JLabel(bedEmptyImage));
			r02_4.add(new JLabel(bedEmptyImage));
		}
		//
		lblroom01C.setText(String.valueOf(Dao.room01));
		r02_5.removeAll();
		r02_5.add(new JLabel("1호실:"));
		if(Dao.room01==4) {
			r02_5.add(new JLabel("만석"));
		}else if(Dao.room01==0) {
			r02_5.add(new JLabel("공석"));
		}else {
			r02_5.add(lblroom01C);
			r02_5.add(new JLabel("명"));
		}
		
		r03_1.removeAll();
		r03_2.removeAll();
		r03_3.removeAll();
		r03_4.removeAll();
		if (Dao.room02 == 4) {
			r03_1.add(new JLabel(bedUseImage));
			r03_2.add(new JLabel(bedUseImage));
			r03_3.add(new JLabel(bedUseImage));
			r03_4.add(new JLabel(bedUseImage));
		}else if (Dao.room02 == 3) {
			r03_1.add(new JLabel(bedEmptyImage));  
			r03_2.add(bedUse02);    
			r03_3.add(new JLabel(bedUseImage));    
			r03_4.add(new JLabel(bedUseImage));    
		}else if (Dao.room02 == 2) {
			r03_1.add(new JLabel(bedEmptyImage));
			r03_2.add(new JLabel(bedEmptyImage));
			r03_3.add(new JLabel(bedUseImage));  
			r03_4.add(new JLabel(bedUseImage));  
		}else if (Dao.room02 == 1) {
			r03_1.add(new JLabel(bedEmptyImage));
			r03_2.add(new JLabel(bedEmptyImage));
			r03_3.add(new JLabel(bedEmptyImage));
			r03_4.add(new JLabel(bedUseImage));  
		}else if (Dao.room02 == 0) {
			r03_1.add(new JLabel(bedEmptyImage));
			r03_2.add(new JLabel(bedEmptyImage));
			r03_3.add(new JLabel(bedEmptyImage));
			r03_4.add(new JLabel(bedEmptyImage));
		}
		lblroom02C.setText(String.valueOf(Dao.room02));
		r03_5.removeAll();
		r03_5.add(new JLabel("2호실:"));
		if(Dao.room02==4) {
			r03_5.add(new JLabel("만석"));
		}else if(Dao.room02==0) {
			r03_5.add(new JLabel("공석"));
		}else {
			r03_5.add(lblroom02C);
			r03_5.add(new JLabel("명"));
		}
		
		
		r04_1.removeAll();
		r04_2.removeAll();
		r04_3.removeAll();
		r04_4.removeAll();
		if (Dao.room03 == 4) {
			r04_1.add(new JLabel(bedUseImage));
			r04_2.add(bedUse02);
			r04_3.add(new JLabel(bedUseImage));
			r04_4.add(new JLabel(bedUseImage));
		}else if (Dao.room03 == 3) {
			r04_1.add(new JLabel(bedEmptyImage));  
			r04_2.add(bedUse02);    
			r04_3.add(new JLabel(bedUseImage));    
			r04_4.add(new JLabel(bedUseImage));    
		}else if (Dao.room03 == 2) {
			r04_1.add(new JLabel(bedEmptyImage));
			r04_2.add(new JLabel(bedEmptyImage));
			r04_3.add(new JLabel(bedUseImage));  
			r04_4.add(new JLabel(bedUseImage));  
		}else if (Dao.room03 == 1) {
			r04_1.add(new JLabel(bedEmptyImage));
			r04_2.add(new JLabel(bedEmptyImage));
			r04_3.add(new JLabel(bedEmptyImage));
			r04_4.add(new JLabel(bedUseImage));  
		}else if (Dao.room03 == 0) {
			r04_1.add(new JLabel(bedEmptyImage));
			r04_2.add(new JLabel(bedEmptyImage));
			r04_3.add(new JLabel(bedEmptyImage));
			r04_4.add(new JLabel(bedEmptyImage));
		}
		lblroom03C.setText(String.valueOf(Dao.room03));
		r04_5.removeAll();
		r04_5.add(new JLabel("3호실:"));
		if(Dao.room03==4) {
			r04_5.add(new JLabel("만석"));
		}else if(Dao.room03==0) {
			r04_5.add(new JLabel("공석"));
		}else {
			r04_5.add(lblroom03C);
			r04_5.add(new JLabel("명"));
		}
		
		lblroomMember.setText(String.valueOf(Dao.room01+Dao.room02+Dao.room03));
		lblroomNotMember.setText(String.valueOf(Dao.badValue-(Dao.room01+Dao.room02+Dao.room03)));

	}

}
