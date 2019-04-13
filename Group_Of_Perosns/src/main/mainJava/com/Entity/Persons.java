package com.Entity;

import java.util.Date;

public class Persons {
	private int    id;
	private String firstName;
	private String lastName;
	private String address;
	private String profession;
	private String maritital_st;
	private int	   children;
	private Date   dob;
	private int nb_edition;
	
	public Persons(int id, String firstName, String lastName, String address, String profession, String maritital_st,
			int children, Date dob, int nb_edition) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.profession = profession;
		this.maritital_st = maritital_st;
		this.children = children;
		this.dob = dob;
		this.nb_edition = nb_edition;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getMaritital_st() {
		return maritital_st;
	}

	public void setMaritital_st(String maritital_st) {
		this.maritital_st = maritital_st;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getNb_edition() {
		return nb_edition;
	}

	public void setNb_edition(int nb_edition) {
		this.nb_edition = nb_edition;
	}

	@Override
	public String toString() {
		return "Persons [firstName=" + firstName + "]";
	}
	
	
}
