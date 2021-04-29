package com.example.mo3amlat;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="mo3amleh")
@Table(name="mo3amlat")
@JsonIgnoreProperties(ignoreUnknown = true)
public class moaamleh implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column
	int number;
	@Column
	String place;
	@Column
	String date;
	@Column
	String name;
	@Column
	String details;
	@Override
	public String toString() {
		return "moaamleh [number=" + number + ", place=" + place + ", date=" + date + ", name=" + name + ", details="
				+ details + "]";
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public moaamleh(int number, String place, String date, String name, String details) {
		super();
		this.number = number;
		this.place = place;
		this.date = date;
		this.name = name;
		this.details = details;
	}
	public moaamleh() {
		super();
	}
	
	

}
