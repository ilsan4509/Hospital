package org.comstudy21.myapp.controller;

import javax.swing.JOptionPane;

import org.comstudy21.myapp.model.Dao;
import org.comstudy21.myapp.model.Dto;

public class DeleteController implements Controller {
	public void service() {
		if(txtName.getText() == null) {
			JOptionPane.showMessageDialog(null, "삭제 할 이름을 입력 하세요!");
			return;
		}
		
		//값 삭제 확인 
		Dao.delete(new Dto(txtNo.getText(), null, null, null, null, null, null),txtName.getText());
		
		Dao.saveDataList();// 리스트 저장
		
		Dao.LoadListNo();// 리스트 갱신하기
		String noS = "";  
		noS = String.valueOf(Dao.lastNo);
		txtNo.setText(noS);
		txtName.setText("");
		txtPhone.setText("");
		txtAge.setText("");
		g01.clearSelection();
		roomCombo.setSelectedIndex(0);
		ctrlMap.get(btnAll).service();
	}

}
