package hfut.se.bean;

import java.io.Serializable;

public class Patient implements Serializable {
	private String cardid;
	private String password;
	private String name;
	private String sex;
	private String phone;
	
	@Override
	public String toString() {
		return "Patient [cardid=" + cardid + ", password=" + password + ", name=" + name + ", sex=" + sex + ", phone="
				+ phone + "]";
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
