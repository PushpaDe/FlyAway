package com.flyaway.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Flight implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int FID;
	
	@Column(name = "Capacity")
    private String Capacity;
	
	@Column(name = "DepTime")
    private String DepTime;
	
	@Column(name = "ArrTime")
    private String ArrTime;
	
	@OneToOne(targetEntity= Cities.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "CID",insertable = false, updatable = false)
	private Cities Source;
	
	@OneToOne(targetEntity= Cities.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "CID", insertable = false, updatable = false)
	private Cities Destination;
	
	@Column(name = "Fare")
    private int Fare;
	
	@OneToOne(targetEntity= Airline.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "aid")
	private Airline aid;

	public int getFID() {
		return FID;
	}

	public void setFID(int fID) {
		FID = fID;
	}

	public String getCapacity() {
		return Capacity;
	}

	public void setCapacity(String capacity) {
		Capacity = capacity;
	}

	public String getDepTime() {
		return DepTime;
	}

	public void setDepTime(String depTime) {
		DepTime = depTime;
	}

	public String getArrTime() {
		return ArrTime;
	}

	public void setArrTime(String arrTime) {
		ArrTime = arrTime;
	}

	public Cities getSource() {
		return Source;
	}

	public void setSource(Cities source) {
		Source = source;
	}

	public Cities getDestination() {
		return Destination;
	}

	public void setDestination(Cities destination) {
		Destination = destination;
	}

	public int getFare() {
		return Fare;
	}

	public void setFare(int fare) {
		Fare = fare;
	}

	public Airline getAid() {
		return aid;
	}

	public void setAid(Airline aid) {
		this.aid = aid;
	}
	
	

}
