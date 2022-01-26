package com.flyaway.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookingdetails")
public class BookingDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int bid;
	
	@OneToOne(targetEntity= Flight.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "FID")
	private Flight FID;
	
	@Column(name = "TicketNo")
    private int TicketNo;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public Flight getFID() {
		return FID;
	}

	public void setFID(Flight fID) {
		FID = fID;
	}

	public int getTicketNo() {
		return TicketNo;
	}

	public void setTicketNo(int ticketNo) {
		TicketNo = ticketNo;
	}
	
}
