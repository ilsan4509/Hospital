package org.comstudy21.myapp.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.comstudy21.myapp.evt.InputEvtHandler;
import org.comstudy21.myapp.model.Dao;

public class InputView extends View  {
	JPanel leftPane = new JPanel(new GridLayout(13,1));
	JPanel titPane = new JPanel();

	public InputView() {
		display();
	}

	@Override
	public void display() {
		Dao.LoadListNo();
		add(leftPane);
		titPane.add(new JLabel(":::: INFO ::::"));
		leftPane.add(titPane);
		
		JPanel p1 = new JPanel();
		p1.add(new JLabel("   NO   : "));
		txtNo.setEnabled(false);
		String noS = "";  
		noS = String.valueOf(Dao.lastNo);
		txtNo.setText(noS);
		p1.add(txtNo);
		leftPane.add(p1);
		
		JPanel p2 = new JPanel();
		p2.add(new JLabel("NAME : "));
		p2.add(txtName);
		leftPane.add(p2);
		
		JPanel p3 = new JPanel();
		p3.add(new JLabel("PHONE : "));
		p3.add(txtPhone);
		leftPane.add(p3);
		
		JPanel p4 = new JPanel();
		p4.add(new JLabel("AGE : "));
		p4.add(txtAge);
		leftPane.add(p4);
		
		JPanel p5 = new JPanel();
		p5.add(new JLabel("확진유무 : "));
		for(int i = 0; i < radio01.length; i++) {
			radio01[i] = new JRadioButton(text[i]);
			radio01[i].setActionCommand(radio01[i].getText());
			radio01[i].addItemListener(new InputEvtHandler());
			g01.add(radio01[i]);
			p5.add(radio01[i]);
		}
		leftPane.add(p5);
		
		JPanel p6 = new JPanel();
		roomCombo.setEnabled(false);
		p6.add(new JLabel("입원호실:   "));
		p6.add(roomCombo);
		leftPane.add(p6);
		
		JPanel p7 = new JPanel();
		p7.add(btnEra);
		leftPane.add(p7);
		
		JPanel p8 = new JPanel();
		leftPane.add(p8);
		
		JPanel p9 = new JPanel();
		leftPane.add(p9);
		
		JPanel p10 = new JPanel();
		leftPane.add(p10);
		
		leftPane.add(lblduck);
		
		
		
	}
}
