package com.flyaway.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passengerdetail")
public class PassengerDetails implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int PID;
	
	@ManyToOne(targetEntity= BookingDetails.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "bid")
	private BookingDetails bid;
	
	@Column(name = "PFName")
    private String PFName;
	
	@Column(name = "PLName")
    private String PLName;
	
	@Column(name = "PDOB")
    private String PDOB;
	
	@OneToOne(targetEntity= User.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "UID")
	private User UID;

	public int getPID() {
		return PID;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	public BookingDetails getBid() {
		return bid;
	}

	public void setBid(BookingDetails bid) {
		this.bid = bid;
	}

	public String getPFName() {
		return PFName;
	}

	public void setPFName(String pFName) {
		PFName = pFName;
	}

	public String getPLName() {
		return PLName;
	}

	public void setPLName(String pLName) {
		PLName = pLName;
	}

	public String getPDOB() {
		return PDOB;
	}

	public void setPDOB(String pDOB) {
		PDOB = pDOB;
	}

	public User getUID() {
		return UID;
	}

	public void setUID(User uID) {
		UID = uID;
	}

}
