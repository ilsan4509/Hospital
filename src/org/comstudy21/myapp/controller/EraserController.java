package org.comstudy21.myapp.controller;

public class EraserController implements Controller{
	public void service() {//입력값 초기화 버튼 작동부
		txtNo.setText("");
		txtName.setText("");
		txtPhone.setText("");
		txtAge.setText("");
		g01.clearSelection();
		roomCombo.setSelectedIndex(0);
		ctrlMap.get(btnAll).service();
	}
	
}
