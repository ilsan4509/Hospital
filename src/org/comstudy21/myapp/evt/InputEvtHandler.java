package org.comstudy21.myapp.evt;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.comstudy21.myapp.resource.R;

public class InputEvtHandler implements R, ItemListener {
	@Override
	public void itemStateChanged(ItemEvent e) {
		//라디오 버튼 확진 선택 경우 입원호실 셀렉트박스(콤보박스) 활성화
		if (radio01[0].isSelected()) {
			roomCombo.setEnabled(true);
		} else if (radio01[1].isSelected()) {
			roomCombo.setEnabled(false);
		}else {//삭제 등 작동 후 다시 닫혀있게
			roomCombo.setEnabled(false);
		}
	}
	
}