package hfut.se.bean;

import java.io.Serializable;
import java.util.Date;

public class Prescription implements Serializable{
	private Integer id;
	private String cardid;
	private String med_id;
	private Integer number;
	private Date date;
	private Integer ispaid;
	private String did;
	
	public Prescription() {}
	public Prescription(Integer id,String cardid, String med_id, Integer number, Date date,String did,Integer ispaid) {
		this.id=id;
		this.cardid = cardid;
		this.med_id = med_id;
		this.number = number;
		this.date= date;
		this.did=did;
		this.ispaid=ispaid;	
	}
	
	@Override
	public String toString() {
		return "Prescription [id=" + id + ", cardid=" + cardid + ", med_id=" + med_id + ", number=" + number + ", date="
				+ date + ", ispaid=" + ispaid + ", did=" + did + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getMed_id() {
		return med_id;
	}

	public void setMed_id(String med_id) {
		this.med_id = med_id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getIspaid() {
		return ispaid;
	}

	public void setIspaid(Integer ispaid) {
		this.ispaid = ispaid;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}
	
}
