package org.comstudy21.myapp;

import org.comstudy21.myapp.model.Dao;
import org.comstudy21.myapp.view.MainFrame;

public class AppMain {

	public static MainFrame mainframe;

	public static void main(String[] args) {
		Dao.loadDataList();//json 데이터 불러오기
		
		mainframe = new MainFrame();
	}
}
