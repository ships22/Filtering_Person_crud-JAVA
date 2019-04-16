package com.Servlet;
import com.DAO.PersonDao;
import com.Entity.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonServlet
 */
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonDao dao = new PersonDao();
	Persons p;
	List<Persons> personsList = new ArrayList<Persons>(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
        super();
    
    }
    
    @Override
    public void init() throws ServletException {
    	try {
			personsList = dao.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("gets into doGet");
		String urlString = request.getQueryString();
		List<Persons> pList = new ArrayList<Persons>();
		if(urlString != null) {
				String[] splitsAnd = urlString.split("&");
				Map<String, String> params = new HashMap<String, String>();
				params.clear();
				for(String element : splitsAnd) {
					String[] splitsEqual = element.split("=");
					if(splitsEqual.length == 2) {
						params.put(splitsEqual[0], splitsEqual[1]);
					}
					Map.Entry<String,String> entry = params.entrySet().iterator().next();
					
					String check = entry.getKey();
					switch(check) {
						case "id": 
							String id = entry.getValue();
							int idNb = Integer.parseInt(id);
							try {
								Persons	p = dao.getByid(idNb);
								pList.add(p);
								request.setAttribute("pList", pList);
								request.getRequestDispatcher("/filtered.jsp").forward(request, response);
							} catch (SQLException e) {
								e.printStackTrace();
							} break;
							
						case "fName":
							String fName = entry.getValue().toLowerCase();
							System.out.println(fName);
							try {
								pList = dao.getByFirstName(fName);
								request.setAttribute("pList", pList);
								request.getRequestDispatcher("/filtered.jsp").forward(request, response);
							} catch (SQLException e) {
								e.printStackTrace();
							} break;
							
						case "lName":
							String lName = entry.getValue().toLowerCase();
							try {
								pList = dao.getByLastName(lName);
								request.setAttribute("pList", pList);
								request.getRequestDispatcher("/filtered.jsp").forward(request, response);
							} catch (SQLException e) {
								e.printStackTrace();
							} break;
							
						case "mSt":
							String mSt = entry.getValue().toLowerCase();
							try {
								pList = dao.getByMrSt(mSt);
								request.setAttribute("pList", pList);
								request.getRequestDispatcher("/filtered.jsp").forward(request, response);
							}catch (SQLException e) {
								e.printStackTrace();
							} break;
							
						case "chld": 
							String chld = entry.getValue();
							int chldNb = Integer.parseInt(chld);
							try {
								pList = dao.getByChildren(chldNb);
								request.setAttribute("pList", pList);
								request.getRequestDispatcher("/filtered.jsp").forward(request, response);
							} catch (SQLException e) {
								e.printStackTrace();
							} break;
					}
					pList.clear();
				}
			} else {
				request.setAttribute("personsList", personsList);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				System.out.println("else");
			}	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName  = request.getParameter("firstName");
		String lastName   = request.getParameter("lastName");
		String address    = request.getParameter("address");
		String profession = request.getParameter("profession");
		String mSt 		  = request.getParameter("mSt");
		int children   = (parseInt).request.getParameter("children");
		String dob   = request.getParameter("dob");
		
		System.out.println(dob);
		//Creating personObject in DB -
		dao.createPerson(firstName, lastName, address, profession, mSt, children, new Date(dob));
		
		doGet(request, response);
		}
	}


