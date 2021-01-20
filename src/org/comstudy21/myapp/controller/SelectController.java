package org.comstudy21.myapp.controller;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

import org.comstudy21.myapp.model.Dao;
import org.comstudy21.myapp.model.Dto;

public class SelectController implements Controller {

	public void service() {
		
		ArrayList<Dto> list = Dao.selectAll();
		Dao.loadDataList();
		// 기존의 데이터를 비워주고 시작한다.
		dataVector.clear();
		for(Dto dto : list) {
			dataVector.add(dto.getVector());
		}
		Dao.loadDataList();
//		Dao.loadDataList();
		dm.setDataVector(dataVector, columnIdentifiers);
//		ctrlMap.get(btnAll).service();
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
