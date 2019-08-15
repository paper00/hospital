package hfut.se.bean;

import java.io.Serializable;

public class Medicine implements Serializable {
	
	private String id;
	private String name;
	private String med_type;
	private Integer number;
	private Double price;

	public Medicine() {}
	
	public Medicine(String id, String name, Integer number, String med_type, Double price){
		this.id = id;
		this.name = name;
		this.med_type = med_type;
		this.number = number;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", med_type=" + med_type + ", number=" + number + ", price="
				+ price + "]";
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

	public String getMed_type() {
		return med_type;
	}

	public void setMed_type(String med_type) {
		this.med_type = med_type;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}

