package org.comstudy21.myapp.view;

import java.awt.Color;

import javax.swing.JScrollPane;

import org.comstudy21.myapp.evt.MouseEvtHandler;

public class ListView extends View {
	public ListView() {
		columnIdentifiers.add("NO");
		columnIdentifiers.add("NAME");
		columnIdentifiers.add("PHONE");
		columnIdentifiers.add("AGE");
		columnIdentifiers.add("확진유무");
		columnIdentifiers.add("입원호실");
		dm.setColumnCount(6);
		display();
		
		MouseEvtHandler l = new MouseEvtHandler(this);
		table.addMouseListener(l);
	}
	
	@Override
	public void display() {
		//add(new JLabel("List view"));
		add(new JScrollPane(table));
		setBackground(Color.WHITE);
	}
}
