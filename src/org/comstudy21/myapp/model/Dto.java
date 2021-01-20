package org.comstudy21.myapp.model;

import java.util.Vector;

public class Dto {
	String no;
	String name;
	String phone;
	String age;
	String check;
	String room;

	public Dto(String no, String name, String email, String phone, String age, String check, String room) {
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.check = check;
		this.room = room;
	}

	public Dto() {
		no = "";
		name = "";
		phone = "";
		age = "";
		check = "";
		room = "";
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}
	
	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Dto [no=" + no + ", name=" + name + ", phone=" + phone + ", age=" + age + ", check=" + check + ", room="+room+"]";
	}

	public Vector<String> getVector() {
		Vector<String> v = new Vector<>();
		v.add(no);
		v.add(name);
		v.add(phone);
		v.add(age);
		v.add(check);
		v.add(room);
		return v;
	}

	// hashCode와 equals를 재정의 해야 한다.
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Dto dto = (Dto) obj;
		if (obj instanceof Dto) {
			try {
				if (no.equals(dto.no)) {
					return true;
				}
			} catch (NullPointerException e) {

			}
		}
		if (obj instanceof Dto) {
			try {
				if (name.equals(dto.name)) {
					return true;
				}
			} catch (NullPointerException e) {

			}
		}
		// 암것도 안들어갔으면 흘려보내고 밑에 false값을 넣는다.
		return false;
	}
}
