package com.Servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.PersonDao;

/**
 * Servlet implementation class editPerson
 */
public class editPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonDao dao = new PersonDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("PersonServlet").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("do post...editPerson");
		String id_edit		 = request.getParameter("id_edit");
		int id_edit_int		 = Integer.parseInt(id_edit);
		String firstName  	 = request.getParameter("firstName");
		String lastName   	 = request.getParameter("lastName");
		String address    	 = request.getParameter("address");
		String profession 	 = request.getParameter("profession");
		String mSt 		  	 = request.getParameter("mSt");
		String childrenStr   = request.getParameter("children");
		int    children  	 = Integer.parseInt(childrenStr);	
		String dobStr   	 = request.getParameter("dob");
		Date   dob           = Date.valueOf(dobStr);
		System.out.println(id_edit_int);
			//Editing person details in the database -
		try {
			dao.updatePerson(id_edit_int, firstName, lastName, address, profession, mSt, children, dob);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
