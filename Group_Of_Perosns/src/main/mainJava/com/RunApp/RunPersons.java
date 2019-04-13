package com.RunApp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.DAO.*;

import com.DbUtils.DbConnector;
import com.Entity.Persons;

public class RunPersons {

	public static void main(String[] args){
		System.out.println("Works!...");
		PersonDao dao 		  = new PersonDao();
//		Date dob = new Date(0-0-0);
//		Connection connection = DbConnector.getConnection();
		System.out.println("\n");
		
		//Creating person -
//		try {
//			dao.createPerson("Guilleum", "Azbari", "19 Rue de la republique, 75010, Paris, France", "Teacher", "Single", 0, new Date(1981-1-31));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		//Getting all the persons -
//		try {
//			List<Persons> allPersons = dao.getAll();
//			for(Persons p: allPersons) {
//				System.out.println(p.getId() + " - " + "FirstName: " + p.getFirstName() + "  LastName: "+ p.getLastName()+
//				"\n" + " Address: " + p.getAddress() + "\n" +
//				" Profession: " + p.getProfession() + "\n" +
//				" Maritial status: " + p.getMaritital_st() + "\n" +
//				" Children: " + p.getChildren() + "\n" +
//				" Date of birth: " + p.getDob() + "\n" +
//				" Version: " + p.getNb_edition());
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		//Getting by firstName - 
//		try {
//			List<Persons> p = dao.getByFirstName("jack");
//			System.out.println(p);
//			System.out.println(p.getId() + " - " + "FirstName: " + p.getFirstName() + " LastName: " + p.getLastName()+ "\n"+ 
//			" Address: " + p.getAddress() + "\n"+
//			" Profession: " + p.getProfession() + "\n" + 
//			" Maritial status: " + p.getMaritital_st() + "\n" +
//			" Children: " + p.getChildren() + "\n" + 
//			" Date of birth: " + p.getDob() + "\n" +
//			" Version: " + p.getNb_edition());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		//Getting person by children number -
//		try {
//			Persons p = dao.getByChildren(1);
//			System.out.println(p.getId() + " - " + "FirstName: " + p.getFirstName() + " LastName: " + p.getLastName()+ "\n"+ 
//			" Address: " + p.getAddress() + "\n"+
//			" Profession: " + p.getProfession() + "\n" + 
//			" Maritial status: " + p.getMaritital_st() + "\n" +
//			" Children: " + p.getChildren() + "\n" + 
//			" Date of birth: " + p.getDob() + "\n" +
//			" Version: " + p.getNb_edition());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		//Getting by dob (to be fixed)-
//		try {
//			Persons p = dao.getByDOB(new Date(1996-01-30));
//			System.out.println(p.getId() + " - " + "FirstName: " + p.getFirstName() + " LastName: " + p.getLastName()+ "\n"+ 
//					" Address: " + p.getAddress() + "\n"+
//					" Profession: " + p.getProfession() + "\n" + 
//					" Maritial status: " + p.getMaritital_st() + "\n" +
//					" Children: " + p.getChildren() + "\n" + 
//					" Date of birth: " + p.getDob() + "\n" +
//					" Version: " + p.getNb_edition());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		//Update person -
//		try {
//			dao.updatePerson(3, "Manel", "Bouhmaza", "55 Rue de vincenne, 93100, Montreuil, France", "Teacher", "Married", 3, new Date(1980-02-01));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		//delete -
//		try {
//			dao.deletePerson(5);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

}
