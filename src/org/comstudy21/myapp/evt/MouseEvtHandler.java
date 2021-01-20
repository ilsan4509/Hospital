package org.comstudy21.myapp.evt;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import org.comstudy21.myapp.resource.R;
import org.comstudy21.myapp.view.ListView;

public class MouseEvtHandler extends MouseAdapter implements R {
	ListView target;

	public MouseEvtHandler(ListView target) {
		this.target = target;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// 마우스를 눌렀을때 반응하는 메소드
		JTable table = target.table;

		int row = table.getSelectedRow();
		int column = table.getSelectedColumn();
		// System.out.println(dm.getValueAt(row, column));

		// System.out.print(dm.getValueAt(row, 0)+", ");
		// System.out.print(dm.getValueAt(row, 1)+", ");
		// System.out.print(dm.getValueAt(row, 2)+", ");
		// System.out.println(dm.getValueAt(row, 3));

		// 텍스트 필드에 표시하기 ..그니까 목록에서 클릭시 인풋박스에 나타나귀
		txtNo.setText((String) dm.getValueAt(row, 0));
		txtName.setText((String) dm.getValueAt(row, 1));
		txtPhone.setText((String) dm.getValueAt(row, 2));
		txtAge.setText((String) dm.getValueAt(row, 3));
		if (((String) dm.getValueAt(row, 4)).equals("확진")) {
			radio01[0].setSelected(true); // setSelected() - RadioButton 내용을...
		} else if (((String) dm.getValueAt(row, 4)).equals("정상")){
			radio01[1].setSelected(true);
		} else {//확진이나 정상값이 없는경우 선택을 풀어줘야한다.
			g01.clearSelection();
		}
		
		if (((String) dm.getValueAt(row, 5)).equals("타병원")) {
			roomCombo.setSelectedIndex(0); // setSelected() - RadioButton 내용을...
		} else if (((String) dm.getValueAt(row, 5)).equals("1호실")){
			roomCombo.setSelectedIndex(1);
		} else if (((String) dm.getValueAt(row, 5)).equals("2호실")){//확진이나 정상값이 없는경우 선택을 풀어줘야한다.
			roomCombo.setSelectedIndex(2);
		} else {
			roomCombo.setSelectedIndex(3);
		}
	}
}
