package hfut.se.bean;

import java.io.Serializable;
import java.util.Date;

public class CheckInfo implements Serializable{
	
	private Integer id;
	private String tollUsername;
	private String patientCardId;
	private Integer price;
	private Date chargetime;
	
	public CheckInfo() {}
	
	public CheckInfo(Integer id, String tollUsername, String patientCardId, Integer price, Date chargetime) {
		this.id = id;
		this.tollUsername = tollUsername;
		this.patientCardId = patientCardId;
		this.price = price;
		this.chargetime = chargetime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTollUsername() {
		return tollUsername;
	}

	public void setTollUsername(String tollUsername) {
		this.tollUsername = tollUsername;
	}

	public String getPatientCardId() {
		return patientCardId;
	}

	public void setPatientCardId(String patientCardId) {
		this.patientCardId = patientCardId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getChargetime() {
		return chargetime;
	}

	public void setChargetime(Date chargetime) {
		this.chargetime = chargetime;
	}

	@Override
	public String toString() {
		return "CheckInfo [id=" + id + ", tollUsername=" + tollUsername + ", patientCardId=" + patientCardId
				+ ", price=" + price + ", chargetime=" + chargetime + "]";
	}

	
	
	
}
