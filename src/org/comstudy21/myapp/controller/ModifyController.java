package org.comstudy21.myapp.controller;

import javax.swing.JOptionPane;

import org.comstudy21.myapp.model.Dao;
import org.comstudy21.myapp.model.Dto;

public class ModifyController implements Controller {
	public void service() {
		Dao.loadDataList();
		int index = table.getSelectedRow();
		System.out.println(index);

		Dto dto = Dao.modify(new Dto(txtNo.getText(), null, null, null, null, null, null));
		if (dto == null) {
			return;
		}
		if (txtName.getText().equals("") && !(dto == null)) {
			JOptionPane.showMessageDialog(null, "이름이 비어있습니다. 입력해주세요");
			return;
		}
		try {
			if (Integer.parseInt(txtAge.getText().toString()) >= 0) {
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
		int result = JOptionPane.showConfirmDialog(null, txtName.getText() + "님을 정말 수정하시겠습니까", "Confirm", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.CANCEL_OPTION) {
			return ;
		} else if (result == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "수정 완료!");
			try {
				dto.setNo(txtNo.getText());
				dto.setName(txtName.getText());
				dto.setPhone(txtPhone.getText());
				dto.setAge(txtAge.getText());
				dto.setCheck(g01.getSelection().getActionCommand());

				// 확진or정상 라디오버튼을 미 입력시 또는 정상입력시에 입원호실 값 ""으로 등록
				if (g01.getSelection() == null || g01.getSelection().getActionCommand().equals("정상")) {
					dto.setRoom("");
				} else {
					dto.setRoom(roomCombo.getSelectedItem().toString());
				}
				
			} catch (NullPointerException e) {
				// 콘솔창 에러 나타나는것 없에기
			}
		}

		Dao.LoadListNo();
		txtNo.setText(String.valueOf(Dao.lastNo));
		txtName.setText("");
		txtPhone.setText("");
		txtAge.setText("");
		g01.clearSelection();
		roomCombo.setSelectedIndex(0);
		Dao.saveDataList(); 

		ctrlMap.get(btnAll).service();

	}
}
