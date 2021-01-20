package org.comstudy21.myapp.model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.comstudy21.myapp.resource.R;
import org.comstudy21.myapp.view.MainFrame;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Dao {
	static ArrayList<Dto> list = new ArrayList<>();
//	static GraphView g = new GraphView();
	// 요밑에 나이 값을 더하고 나눌변수를 만들어봄////////
	public static double avgValue = 0.0;

	// 마지막 No 받을 변수
	public static int lastNo = 0;

	// 나이 받을 변수 와 인원 누적 변수
	public static int peo = 0;
	public static int peo20 = 0;
	public static int peo40 = 0;
	public static int peo60 = 0;
	public static int peo80 = 0;
	public static int peo80up = 0;

	// 정상 및 확진 명수 확인
	public static String value = "";
	public static int valueC = 0;
	public static int goodValue = 0;
	public static int badValue = 0;

	// 호실 명수 확인
	public static String roomName = "";
	public static int room01 = 0;
	public static int room02 = 0;
	public static int room03 = 0;

	// 검색시 목록서 이름 받을 변수
	public static String listName = "";

	// 그래프 디스플레이 확진자나이 평균값 소숫점 정리
	static DecimalFormat form = new DecimalFormat("#.##");

	// 파일 입출력 준비
	static FileReader reader;
	static FileWriter writer;
	// 데이터 파일의 경로
	static String pathname = "src/org/comstudy21/myapp/resource/data.json";

	public static int LoadListNo() {
		File dataFile = new File(pathname);
		try {
			reader = new FileReader(dataFile);
			// reader를 이용해서 JSONTokener 객체 만들기
			JSONTokener tokener = new JSONTokener(reader);
			// JSONTokener를 JSONObject로 바꾸기
			JSONObject root = new JSONObject(tokener);
			// JSONArray를 뽑아 온다.
			JSONArray array = root.getJSONArray("member");
			for (int i = 0; i < array.length(); i++) {
				if (i == array.length() - 1) {
					lastNo = array.getJSONObject(i).getInt("no");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		lastNo = lastNo + 1;
		return lastNo;
	}

	public static void loadDataList() {
		File dataFile = new File(pathname);
		try {
			if (!dataFile.exists()) {

				// data.json 파일이 없으면 파일을 새로 생성하고 기본 데이터를 저장한다.
				if (dataFile.createNewFile()) {
					// System.out.println(">>> 파일이 생성 되었습니다!");
					// JSONObject 생성 -> JSONArray 생성 -> JSONObject -> 저장
					JSONObject obj = new JSONObject();
					obj.put("no", 1);
					obj.put("name", "test");
					obj.put("phone", "010-0000-0000");
					obj.put("age", "1");
					obj.put("check", "1");
					obj.put("room", "1");
					JSONArray array = new JSONArray();
					array.put(obj);
					JSONObject root = new JSONObject();
					root.put("member", array);
					root.put("seq", 2);

					// 파일쓰기 준비
					writer = new FileWriter(dataFile);
					writer.write(root.toString(2));
					// writer.close();
				}
			}
			// System.out.println("파일이 존재 합니다!");
			// 파일의 내용을 읽어오기 -> list에 담아주기
			reader = new FileReader(dataFile);
			// reader를 이용해서 JSONTokener 객체 만들기
			JSONTokener tokener = new JSONTokener(reader);
			// JSONTokener를 JSONObject로 바꾸기
			JSONObject root = new JSONObject(tokener);
			// JSONArray를 뽑아 온다.
			JSONArray array = root.getJSONArray("member");
			// array의 요소를 DTO로 바꿔서 list에 저장
			list.clear();
			for (int i = 0; i < array.length(); i++) {
				JSONObject obj = array.getJSONObject(i);
				Dto dto = new Dto();
				dto.setNo(obj.getInt("no") + "");
				dto.setName(obj.getString("name"));
				dto.setPhone(obj.getString("phone"));
				dto.setAge(obj.getString("age"));
				dto.setCheck(obj.getString("check"));
				dto.setRoom(obj.getString("room"));
				list.add(dto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static double loadDataAvg() {// 나이값만 불러내서 더하고 나누기...
		File dataFile = new File(pathname);
		try {
			// 파일의 내용을 읽어오기 -> list에 담아주기
			reader = new FileReader(dataFile);
			// reader를 이용해서 JSONTokener 객체 만들기
			JSONTokener tokener = new JSONTokener(reader);
			// JSONTokener를 JSONObject로 바꾸기
			JSONObject root = new JSONObject(tokener);
			// JSONArray를 뽑아 온다.
			JSONArray array = root.getJSONArray("member");
			// array의 요소를 DTO로 바꿔서 list에 저장
			for (int i = 0; i < array.length(); i++) {
				value = array.getJSONObject(i).getString("check");
				if (value.equals("확진")) {
					valueC += 1;
					avgValue += array.getJSONObject(i).getDouble("age");
				}
			}
			avgValue = avgValue / valueC;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return avgValue;
	}

	public static void loadDataRoomCount() {
		loadDataRoom01Count();
		loadDataRoom02Count();
		loadDataRoom03Count();

	}

	public static void loadOldCount() {
		loadData20OldCount();
		loadData40OldCount();
		loadData60OldCount();
		loadData80OldCount();
		loadData80upOldCount();
	}

	public static void loadValueCount() {
		loadDataGoodCount();
		loadDataBadCount();

	}

	public static int loadData20OldCount() {// 나이대별 인원 카운트
		File dataFile = new File(pathname);
		try {
			if (!dataFile.exists()) {
//				JOptionPane.showMessageDialog(null, "데이터가 존재 하지 않습니다!");
			}

			reader = new FileReader(dataFile);
			JSONTokener tokener = new JSONTokener(reader);
			JSONObject root = new JSONObject(tokener);
			JSONArray array = root.getJSONArray("member");

			for (int i = 0; i < array.length(); i++) {
				peo = array.getJSONObject(i).getInt("age");
				value = array.getJSONObject(i).getString("check");
				if (peo <= 20 && value.equals("확진")) {
					peo20 += 1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return peo20;
	}

	public static int loadData40OldCount() {// 40
		File dataFile = new File(pathname);
		try {
			if (!dataFile.exists()) {
//				JOptionPane.showMessageDialog(null, "데이터가 존재 하지 않습니다!");
			}
			reader = new FileReader(dataFile);
			JSONTokener tokener = new JSONTokener(reader);
			JSONObject root = new JSONObject(tokener);
			JSONArray array = root.getJSONArray("member");

			for (int i = 0; i < array.length(); i++) {
				peo = array.getJSONObject(i).getInt("age");
				value = array.getJSONObject(i).getString("check");
				if (peo > 20 && peo <= 40 && value.equals("확진")) {
					peo40 += 1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return peo40;
	}

	public static int loadData60OldCount() {
		File dataFile = new File(pathname);
		try {
			if (!dataFile.exists()) {
				// JOptionPane.showMessageDialog(null, "데이터가 존재 하지 않습니다!");
			}
			reader = new FileReader(dataFile);
			JSONTokener tokener = new JSONTokener(reader);
			JSONObject root = new JSONObject(tokener);
			JSONArray array = root.getJSONArray("member");

			for (int i = 0; i < array.length(); i++) {
				peo = array.getJSONObject(i).getInt("age");
				value = array.getJSONObject(i).getString("check");
				if (peo > 40 && peo <= 60 && value.equals("확진")) {
					peo60 += 1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return peo60;
	}

	public static int loadData80OldCount() {
		File dataFile = new File(pathname);
		try {
			if (!dataFile.exists()) {
				// JOptionPane.showMessageDialog(null, "데이터가 존재 하지 않습니다!");
			}
			reader = new FileReader(dataFile);
			JSONTokener tokener = new JSONTokener(reader);
			JSONObject root = new JSONObject(tokener);
			JSONArray array = root.getJSONArray("member");

			for (int i = 0; i < array.length(); i++) {
				peo = array.getJSONObject(i).getInt("age");
				value = array.getJSONObject(i).getString("check");
				if (peo > 60 && peo <= 80 && value.equals("확진")) {
					peo80 += 1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return peo80;
	}

	public static int loadData80upOldCount() {
		File dataFile = new File(pathname);
		try {
			if (!dataFile.exists()) {
				// JOptionPane.showMessageDialog(null, "데이터가 존재 하지 않습니다!");
			}
			reader = new FileReader(dataFile);
			JSONTokener tokener = new JSONTokener(reader);
			JSONObject root = new JSONObject(tokener);
			JSONArray array = root.getJSONArray("member");

			for (int i = 0; i < array.length(); i++) {
				peo = array.getJSONObject(i).getInt("age");
				value = array.getJSONObject(i).getString("check");
				if (peo > 80 && value.equals("확진")) {
					peo80up += 1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return peo80up;
	}

	public static int loadDataGoodCount() {
		File dataFile = new File(pathname);
		try {
			if (!dataFile.exists()) {
				// JOptionPane.showMessageDialog(null, "데이터가 존재 하지 않습니다!");
			}
			reader = new FileReader(dataFile);
			JSONTokener tokener = new JSONTokener(reader);
			JSONObject root = new JSONObject(tokener);
			JSONArray array = root.getJSONArray("member");

			for (int i = 0; i < array.length(); i++) {
				value = array.getJSONObject(i).getString("check");
				if (value.equals("정상")) {
					goodValue += 1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return goodValue;
	}

	public static int loadDataBadCount() {
		File dataFile = new File(pathname);
		try {
			if (!dataFile.exists()) {
				// JOptionPane.showMessageDialog(null, "데이터가 존재 하지 않습니다!");
			}
			reader = new FileReader(dataFile);
			JSONTokener tokener = new JSONTokener(reader);
			JSONObject root = new JSONObject(tokener);
			JSONArray array = root.getJSONArray("member");

			for (int i = 0; i < array.length(); i++) {
				value = array.getJSONObject(i).getString("check");
				if (value.equals("확진")) {
					badValue += 1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return badValue;
	}

	public static int loadDataRoom01Count() {// 나이대별 인원 카운트
		File dataFile = new File(pathname);
		try {
			if (!dataFile.exists()) {
//				JOptionPane.showMessageDialog(null, "데이터가 존재 하지 않습니다!");
			}

			reader = new FileReader(dataFile);
			JSONTokener tokener = new JSONTokener(reader);
			JSONObject root = new JSONObject(tokener);
			JSONArray array = root.getJSONArray("member");

			for (int i = 0; i < array.length(); i++) {
				roomName = array.getJSONObject(i).getString("room");
				if (roomName.equals("1호실")) {
					room01 += 1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return room01;
	}

	public static int loadDataRoom02Count() {// 나이대별 인원 카운트
		File dataFile = new File(pathname);
		try {
			if (!dataFile.exists()) {
//				JOptionPane.showMessageDialog(null, "데이터가 존재 하지 않습니다!");
			}

			reader = new FileReader(dataFile);
			JSONTokener tokener = new JSONTokener(reader);
			JSONObject root = new JSONObject(tokener);
			JSONArray array = root.getJSONArray("member");

			for (int i = 0; i < array.length(); i++) {
				roomName = array.getJSONObject(i).getString("room");
				if (roomName.equals("2호실")) {
					room02 += 1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return room02;
	}

	public static int loadDataRoom03Count() {// 나이대별 인원 카운트
		File dataFile = new File(pathname);
		try {
			if (!dataFile.exists()) {
//				JOptionPane.showMessageDialog(null, "데이터가 존재 하지 않습니다!");
			}

			reader = new FileReader(dataFile);
			JSONTokener tokener = new JSONTokener(reader);
			JSONObject root = new JSONObject(tokener);
			JSONArray array = root.getJSONArray("member");

			for (int i = 0; i < array.length(); i++) {
				roomName = array.getJSONObject(i).getString("room");
				if (roomName.equals("3호실")) {
					room03 += 1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return room03;
	}

	public static void saveDataList() {
		// 리스트의 내용이 없다면 그냥 종료
		if (list.size() == -1) {
			JOptionPane.showMessageDialog(null, "저장 할 내용이 없습니다!");
			return;
		}

		File dataFile = new File(pathname);
		if (!dataFile.exists()) {
			JOptionPane.showMessageDialog(null, "저장 파일이 존재 하지 않습니다!");
			return;
		}
		// System.out.println(">>> 파일이 생성 되었습니다!");
		// JSONObject 생성 -> JSONArray 생성 -> JSONObject -> 저장
		JSONArray array = new JSONArray();
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			Dto dto = list.get(i);
			JSONObject obj = new JSONObject();
			int no = Integer.parseInt(dto.getNo());
			if (no > max) {
				max = no;
			}
			obj.put("no", no);
			obj.put("name", dto.getName());
			obj.put("phone", dto.getPhone());
			obj.put("age", dto.getAge());
			obj.put("check", dto.getCheck());
			obj.put("room", dto.getRoom());
			array.put(obj);
		}
		JSONObject root = new JSONObject();
		root.put("member", array);
		root.put("seq", max + 1);

		try {
			// 파일쓰기 준비
			writer = new FileWriter(dataFile);
			writer.write(root.toString(2));
			// writer.close();
			System.out.println("리스트 갱신");
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 중요: 저장 후에 파일 스트림을 close() 하지 않으면 쓰기가 완료 되지 않는다.
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		MainFrame.graphView.redisplay();
	}

	public static ArrayList<Dto> selectAll() {

		return list;
	}

	public static void insert(Dto dto) {
		list.add(dto);
		saveDataList();
		// 리스트의 내용을 json 파일에 저장하는 기능.
	}

	public static Dto findMember01(Dto name) {
		int index = list.indexOf(name);

		if (index == -1) {// 배열값으로 인덱스 받아서 넘길까 고민중, 넘기면 배열로 index값 풀기
			JOptionPane.showMessageDialog(null, "입력하신 이름의 환자가 없습니다!");
			return null;
		}

		return list.get(index);
	}

	public static void findMember02(String name) {
		File dataFile = new File(pathname);
		try {
			if (!dataFile.exists()) {
//				JOptionPane.showMessageDialog(null, "데이터가 존재 하지 않습니다!");
			}
			reader = new FileReader(dataFile);
			JSONTokener tokener = new JSONTokener(reader);
			JSONObject root = new JSONObject(tokener);
			JSONArray array = root.getJSONArray("member");

			for (int i = 0; i < array.length(); i++) {
				listName = array.getJSONObject(i).getString("name");
				if (listName.equals(name)) {
					R.dataVector.add((list.get(i)).getVector());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void delete(Dto dto, String name) {
		int index = list.indexOf(dto);
		if (index == -1) {
			JOptionPane.showMessageDialog(null, "삭제 할 대상을 클릭해주세요!");
			return;
		}
		int result = JOptionPane.showConfirmDialog(null, name + "님을 정말 삭제하시겠습니까", "Confirm", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.CANCEL_OPTION) {

		} else if (result == JOptionPane.YES_OPTION) {
			list.remove(index);
			JOptionPane.showMessageDialog(null, "삭제 완료!");
		}
	}

	public static Dto modify(Dto dto) {
		int index = list.indexOf(dto);
		if (index == -1) {
			JOptionPane.showMessageDialog(null, "수정 할 대상을 알맞게 클릭해주세요!");
			return null;
		}
		return list.get(index);
	}
}
