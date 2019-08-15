package hfut.se.bean;

import java.util.Date;

public class EntryDelivery {

	private String id;
	private Date date;
	private String medicine_id;
	private Integer number;
	
	EntryDelivery(){
		
	}

	@Override
	public String toString() {
		return "EntryDelivery [id=" + id + ", date=" + date + ", medicine_id=" + medicine_id + ", number=" + number
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMedicine_id() {
		return medicine_id;
	}

	public void setMedicine_id(String medicine_id) {
		this.medicine_id = medicine_id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
		
}
