<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    	<head>
    		<%@page import="java.util.List"%>
    		<%@page import="java.util.ArrayList"%>
    		<%@page import="com.Entity.*" %>
    		<title>Managing group of persons</title>
    		<meta charset="UTF-8">
    		<link href="https://fonts.googleapis.com/css?family=Montserrat:100,300,400,700" rel="stylesheet">
    		<link rel="stylesheet" href="style.css">
    	</head>
    	<body>
    		<div class="main">
    			<header>
    				<h1>Group of Persons</h1>
    				<nav>
    					<ul>
    						<li><a href="PersonServlet">Home</a></li>
    						<li><a href="addPerson.jsp">Add person</a></li>
    						
    					</ul>
    				</nav>
    			</header>
    			<div class="container">
    				<h3>Filtered Person List</h3>
    				<table class="filtered">
    					<thead>
    						<tr>
    							<th>First Name</th>
    							<th>Last Name</th>
    							<th>Address</th>
    							<th>Profession</th>
    							<th>Children</th>
    							<th>Maritial st</th>
    							<th>Version</th>
    							<th>Edit/Delete</th>
    						</tr>
    					</thead>
    					<tbody>
    							<% if ((ArrayList<?>)request.getAttribute("pList") != null) {
    								@SuppressWarnings("unchecked")
    								ArrayList<Persons>personsList = (ArrayList<Persons>)request.getAttribute("pList");
    								for(int i = 0; i < personsList.size(); i++){
    									Persons person = personsList.get(i);%>
    									<tr>
    										<td><%= person.getFirstName() %></td>
    										<td><%= person.getLastName() %></td>
    										<td><%= person.getAddress() %></td>
    										<td><%= person.getProfession() %></td>
    										<td><%= person.getChildren() %></td>
    										<td><%= person.getMaritital_st() %></td>
    										<td><%= person.getNb_edition() %></td>
    										<td>
    											<form method="get" action="PersonServlet">
    												<input type="hidden" name="id_edit" value="<%= person.getId()%>">
    												<button class="btn_edit" type="submit">Edit</button>
    											</form>
    											<form method="get" action="PersonServlet">
    												<input type="hidden" name="id_delete" value="<%= person.getId()%>">
    												<button class="btn_delete" type="submit">Delete</button>
    											</form>
    										</td>
    									</tr>			
    								<%}%>
    							<%}%>	
    					</tbody>
    				</table>
    			</div>
    			<footer>
    				<marquee>Person group dataTable| copyrights reserved - 2019 © Ships</marquee>
    			</footer>
    		</div>
    	</body>
    </html>