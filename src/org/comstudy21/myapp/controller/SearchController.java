package org.comstudy21.myapp.controller;

import javax.swing.JOptionPane;

import org.comstudy21.myapp.model.Dao;
import org.comstudy21.myapp.model.Dto;

public class SearchController implements Controller {

	public void service() {
		//System.out.println("SearchController ...");
		String searchName = txtName.getText();
		Dao dao = new Dao();
		
		if(searchName==null) {
			JOptionPane.showMessageDialog(null, "INFO에 환자이름을 입력해주세요");
		}
		
		Dto member = Dao.findMember01(new Dto(null, searchName, null, null, null, null, null));
		if(member == null) {
			System.out.println("입력하신 이름의 환자가 없음");
		}else {
			// 목록에 있던 내용을 지운다.
			while(dm.getRowCount() > 0) {
				System.out.println("removed");
				dm.removeRow(0);
			}
			
			//System.out.println(member);
			dataVector.clear();
			Dao.findMember02(searchName);
//			dataVector.add(member.getVector());
			dao.LoadListNo();
			String noS = "";
			noS = String.valueOf(dao.lastNo);
			txtNo.setText(noS);
			txtName.setText("");
			txtPhone.setText("");
			txtAge.setText("");
			g01.clearSelection();
			roomCombo.setSelectedIndex(0);
			Dao.saveDataList();
			
			// 데이터 테이블 모델 갱신
			//dm.setDataVector(dataVector, columnIdentifiers);
			dm.fireTableCellUpdated(0, 10);
		}
	}

}
