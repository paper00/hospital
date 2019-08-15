package hfut.se.bean;

import java.io.Serializable;

public class Doctor implements Serializable{
	private String id;
	private String name;
	private String sex;
	private Integer sid;
	private String password;
	private String phone;
	private String email;
	private String info;
	
	public Doctor() {}
	
	public Doctor(String id, String name, String sex, Integer sid, String password) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.sid = sid;
		this.password = password;
	}

	

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", sex=" + sex + ", sid=" + sid + ", password=" + password
				+ ", phone=" + phone + ", email=" + email + ", info=" + info + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
