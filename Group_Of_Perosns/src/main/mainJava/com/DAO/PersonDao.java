package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.DbUtils.DbConnector;
import com.Entity.Persons;
import com.mysql.cj.xdevapi.Result;

public class PersonDao {
	private final String CREATE    		  = "INSERT INTO persons(firstName, lastName, address, profession, maritial_st, children, dob, nb_edition) VALUES (?, ?, ?, ?, ?, ?, ?, 0)";
	private final String GET_ALL          = "SELECT * FROM persons";
	private final String GET_BY_ID        = "SELECT * FROM persons WHERE id = ?";
	private final String GET_BY_FIRSTNAME = "SELECT * FROM persons WHERE firstName = ?";
	private final String GET_BY_LASTNAME  = "SELECT * FROM persons WHERE lastName = ?";
	private final String GET_BY_MAR_ST	  = "SELECT * FROM persons WHERE maritial_st = ?";
	private final String GET_BY_CHILD	  = "SELECT * FROM persons WHERE children = ?";
	private final String GET_BY_DOB		  = "SELECT * FROM persons WHERE dob = ?";
	private final String UPDATE			  = "UPDATE persons SET firstName = ?, lastName = ?, address = ?, profession = ?, maritial_st = ?, children = ?, dob = ?, nb_edition = nb_edition + 1 WHERE id = ?";
	private final String DELETE 		  = "DELETE FROM persons WHERE id = ?";
	Connection connection				  = DbConnector.getConnection();
	
	//Creating peroson -
	public void createPerson(String firstName, String lastName, String address, String profession, String mar_st, int children, Date dob) throws SQLException{
		PreparedStatement ps = connection.prepareStatement(CREATE);
		ps.clearParameters();
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, address);
		ps.setString(4, profession);
		ps.setString(5, mar_st);
		ps.setInt(6, children);
		ps.setDate(7, dob);
		ps.executeUpdate();
//		Persons p = getByFirstName(firstName);
//		System.out.println(p.getFirstName() + " " + p.getLastName() + " has been added in the group.");
	}
	//Getting all the persons - 
	public List<Persons> getAll() throws SQLException{
		List<Persons> personsList = new ArrayList<Persons>();
		PreparedStatement ps = connection.prepareStatement(GET_ALL);
		ResultSet rs		 = ps.executeQuery();
		personsList.clear();
		while(rs.next()) {
			personsList.add(buildPerson(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getInt(8), rs.getInt(9)));
		}
//		connection.close();
		return personsList;
	}
	//Getting person by id - 
	public Persons getByid(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_BY_ID);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
//		connection.close();
		return buildPerson(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getInt(8), rs.getInt(9));
	}
	//Getting person by firstName -
	public List<Persons> getByFirstName(String firstName) throws SQLException {
		List<Persons>listedFname = new ArrayList<Persons>();
		PreparedStatement ps = connection.prepareStatement(GET_BY_FIRSTNAME);
		ps.setString(1, firstName);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Persons p =  buildPerson(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getInt(8), rs.getInt(9));
			listedFname.add(p);
		}
		return listedFname;
//		connection.close();
	}
	//Getting person by lastName -
	public List<Persons> getByLastName(String lastName) throws SQLException {
		List<Persons>listedLname = new ArrayList<Persons>();
		PreparedStatement ps = connection.prepareStatement(GET_BY_LASTNAME);
		ps.setString(1, lastName);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Persons p = buildPerson(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getInt(8), rs.getInt(9));
			listedLname.add(p);
		}
		return listedLname;
//		connection.close();
	}
	//Getting person by maritial status - 
	public List<Persons> getByMrSt(String mrSt) throws SQLException {
		List<Persons>listedMst = new ArrayList<Persons>();
		PreparedStatement ps = connection.prepareStatement(GET_BY_MAR_ST);
		ps.setString(1, mrSt);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Persons p = buildPerson(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getInt(8), rs.getInt(9));
			listedMst.add(p);
		}
		return listedMst;
//		connection.close();
	}
	//Getting person by children number -
	public List<Persons> getByChildren(int children) throws SQLException {
		List<Persons>listedChld = new ArrayList<Persons>();
		PreparedStatement ps = connection.prepareStatement(GET_BY_CHILD);
		ps.setInt(1, children);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Persons p = buildPerson(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getInt(8), rs.getInt(9));
			listedChld.add(p);
		}
		return listedChld;
//		connection.close();
	}
	//Getiing person by DOB -
//	public Persons getByDOB(Date dob) throws SQLException {
//		PreparedStatement ps = connection.prepareStatement(GET_BY_CHILD);
//		ps.setDate(1, dob);
//		ResultSet rs = ps.executeQuery();
//		rs.next();
//		connection.close();
//		return buildPerson(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8), rs.getInt(9));
//	}
	//Building person obeject -
	private Persons buildPerson(String firstName, String lastName, String address, String profession, String mar_st, int children, Date dob, int nb_edition, int id) {
		return new Persons(id, firstName, lastName, address, profession, mar_st, children, dob, nb_edition);
	}
	//Update - 
	public void updatePerson(int id, String firstName, String lastName, String address, String profession, String mr_st, int child, Date dob) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, address);
		ps.setString(4, profession);
		ps.setString(5, mr_st);
		ps.setInt(6, child);
		ps.setDate(7, dob);
		ps.setInt(8, id);
		ps.executeUpdate();
		Persons p = getByid(id);
		System.out.println("Person with id " + id + " " + "has been updated " + p.getNb_edition() + " times." + "\n");
		System.out.println("New details of this person is: " + "\n");
		System.out.println(p.getId() + "| FirstName: " + p.getFirstName() + ", LastName: " + p.getLastName() + 
							"\n" + " | Profession: " + p.getProfession() + ", Address: " + p.getAddress() +
							"\n" + " | Children: " + p.getChildren() + ", Date of birth: " + p.getDob() +
							"\n" + " | Updated: " + p.getNb_edition() + " times");
//		connection.close();
	}
	//Delete -
	public void deletePerson(int id) throws SQLException{
		PreparedStatement ps1 = connection.prepareStatement(GET_BY_ID);
		ps1.setInt(1, id);
		ResultSet rs = ps1.executeQuery();
		if(rs.next()) {
			Persons p = getByid(id);
			System.out.println(p.getFirstName() + " " + p.getLastName() + " has been deleted!");
			PreparedStatement ps = connection.prepareStatement(DELETE);
			ps.setInt(1, id);
			ps.executeUpdate();
		}else {
			System.out.println("Person with id " + id + " doesn't exist!");
		}
//		connection.close();
	}
}

















