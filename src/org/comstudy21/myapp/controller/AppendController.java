package org.comstudy21.myapp.controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

import org.comstudy21.myapp.model.Dao;
import org.comstudy21.myapp.model.Dto;

public class AppendController implements Controller {
	public void service() {
		// Dto 객체를 만든다.
		Dto dto = new Dto();
		// info 이름 및 나이 숫자값 확인
		if (txtName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "이름이 비어있습니다. 입력해주세요");
			return;
		}
		try {
			int txtAgeInt = Integer.parseInt(txtAge.getText());
			if (txtAgeInt >= 0) {
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "나이는 0이상의 숫자를 입력해주세요");
			return;
		}
		if (roomCombo.getSelectedItem().toString() == "1호실") {
			if (Dao.room01 >= 4) {
				JOptionPane.showMessageDialog(null, "1호실이 가득 찼습니다.");
				return;
			}
		}
		if (roomCombo.getSelectedItem().toString() == "2호실") {
			if (Dao.room02 >= 4) {
				JOptionPane.showMessageDialog(null, "2호실이 가득 찼습니다.");
				return;
			}
		}
		if (roomCombo.getSelectedItem().toString() == "3호실") {
			if (Dao.room03 >= 4) {
				JOptionPane.showMessageDialog(null, "3호실이 가득 찼습니다.");
				return;
			}
		}
		//값 저장
		try {
			dto.setNo(String.valueOf(Dao.lastNo));// 리스트 클릭하다가 표시된 no값이 아닌 , 실제 들어가야하는 no값 입력
			dto.setName(txtName.getText());
			dto.setPhone(txtPhone.getText());
			dto.setAge(txtAge.getText());
			try {
				JOptionPane.showMessageDialog(null, txtName.getText() + "님 " + g01.getSelection().getActionCommand());
				dto.setCheck(g01.getSelection().getActionCommand());
			} catch (NullPointerException e) {
				// 콘솔창 에러 나타나는것 없에기
			}
			// 확진or정상 라디오버튼을 미 입력시 또는 정상입력시에 입원호실 값 ""으로 등록
			if (g01.getSelection() == null || g01.getSelection().getActionCommand().equals("정상")) {
				dto.setRoom("");
			} else {
				dto.setRoom(roomCombo.getSelectedItem().toString());
			}
			Dao.insert(dto);
			Dao.LoadListNo();
			txtNo.setText(String.valueOf(Dao.lastNo));
			txtName.setText("");
			txtPhone.setText("");
			txtAge.setText("");
			g01.clearSelection();
			roomCombo.setSelectedIndex(0);
			Dao.saveDataList();

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "INFO에 내용을 모두 입력해주세요");
			return;
		}
		
		ctrlMap.get(btnAll).service();
	}
}
