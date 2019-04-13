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
    						<li><a href="#">Add person</a></li>
    						<li><a href="#">Edit person</a></li>
    					</ul>
    				</nav>
    			</header>
    			<div class="container">
    				<h3>Person List</h3>
    				<table>
    					<thead>
    						<tr>
    							<th>First Name</th>
    							<th>Last Name</th>
    							<th>Address</th>
    							<th>Profession</th>
    							<th>Children</th>
    							<th>Maritial st</th>
    							<th>Version</th>
    						</tr>
    					</thead>
    					<tbody>
    							<% if ((ArrayList<?>)request.getAttribute("personsList") != null) {
    								@SuppressWarnings("unchecked")
    								ArrayList<Persons>personsList = (ArrayList<Persons>)request.getAttribute("personsList");
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
    									</tr>			
    								<%}%>
    							<%}%>
    					</tbody>
    				</table>
    				<div class="filter">
    					<h3>Filter person</h3>
    					<form action="PersonServlet" method="get">
    						<div class="inputs">
		    					<label>Get by Id :</label>
		    					<input type="number" name="id" id="id">
		    				</div>
		    				<br>
		    				<button type="submit">Submit</button>
    					</form>
    					<form action="PersonServlet" method="get">
    						<div class="inputs">
		    					<label>Get by FirstName :</label>
		    					<input type="text" name="fName" id="fName">
		    				</div>
		    				<br>
		    				<button type="submit">Submit</button>
    					</form>
    					<form action="PersonServlet" method="get">
    						<div class="inputs">
		    					<label>Get by LasttName :</label>
		    					<input type="text" name="lName" id="lName">
		    				</div>
		    				<br>
		    				<button type="submit">Submit</button>
    					</form>
    					<form action="PersonServlet" method="get">
    						<div class="inputs">
		    					<label>Get by Maritial St :</label>
		    					<input type="radio" name="mSt" value="single">Single
		    					<br>
		    					<input type="radio" name="mSt" value="married">Married
		    				</div>
		    				<br>
		    				<button type="submit">Submit</button>
    					</form>
    					<form action="PersonServlet" method="get">
    						<div class="inputs">
		    					<label>Get by Children :</label>
		    					<input type="number" name="chld" id="chld">
		    				</div>
		    				<br>
		    				<button type="submit">Submit</button>
    					</form>
    				</div>
    			</div>
    			<footer>
    				<marquee>Person group dataTable| copyrights reserved - 2019 © Ships</marquee>
    			</footer>
    		</div>
    	</body>
    </html>