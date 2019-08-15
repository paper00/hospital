package hfut.se.bean;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class User implements Serializable{
	private Integer id;
	private String username;
	private String password;
	private String usertype;

	public User() {}
	
	public User(Integer id, String username, String password, String usertype) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setEmail(String usertype) {
		this.usertype = usertype;
	}
}
