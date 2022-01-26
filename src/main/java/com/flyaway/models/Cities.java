package com.flyaway.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Cities {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int CID;
	
	@Column(name = "CName")
    private String CName;
	
	@Column(name = "CCode")
    private String CCode;
	
	@Column(name = "Country")
    private String Country;
	
	@Column(name = "CountryCode")
    private String CountryCode;

	public int getCID() {
		return CID;
	}

	public void setCID(int cID) {
		CID = cID;
	}

	public String getCName() {
		return CName;
	}

	public void setCName(String cName) {
		CName = cName;
	}

	public String getCCode() {
		return CCode;
	}

	public void setCCode(String cCode) {
		CCode = cCode;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}

	
	
	public Cities(String cName, String cCode, String country, String countryCode) {
		super();
		CName = cName;
		CCode = cCode;
		Country = country;
		CountryCode = countryCode;
	}

	public Cities(String cName) {
		super();
		System.out.println("1 Parameter Constructor Called");
		CName = cName;
	}

	public Cities() {
		super();
		// TODO Auto-generated constructor stub
	}

}
