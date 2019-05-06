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
    		<style>
     			.backPic { 
     				background-image: url("person1.jpg"); 
     				color: white; 
     				position: absolute;
     				height: 600px;
     				width: 100%;
      				z-index: -1; 
					top: 205px;
					left: 0;
					filter: blur(2px);
     			} 
     			.edit_details {
     				background-color: rgba(0, 0, 0, 0.8);
     				color: white;
     			}
     			
    		</style>
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
    			<div class="backPic"></div>
    			<div class="container">
    				<h3>Edit details</h3>
    				<div class="edit_details">
    					<form action="editPerson" method="POST">
    						
    							<% String strValue = (String)request.getAttribute("id_Str"); %>
    						
    						<section class="left">
    							<input type="hidden" name="id_edit" value="<%=strValue %>">
    							<label>First name : </label>
    							<input type="text" id="firstName" name="firstName" required placeholder="Ex: Ships">
    							<label>Last name : </label>
    							<input type="text" id="lastName" name="lastName" required placeholder="Ex: Haq">
    							<label>Address : </label>
    							<input type="text" id="address" name="address" required placeholder="Ex: 18 Rue kleber, 93100, Montrueil">
    							<label>Profession : </label>
    							<input type="text" id="profession" name="profession" required placeholder="Ex: Developper Java / JS">
    						</section>
    						<section class="right">
    							<label>Number of children : </label>
    							<input type="number" id="children" name="children" required placeholder="Ex: 3">
    							<label>Select marital status : </label>
		    					<div class="radioEdit">
		    						Single
			    					<input type="radio" name="mSt" value="single" checked>
			    					Married
			    					<input type="radio" name="mSt" value="married">
		    					</div>
		    					<br>
		    					<label>Date of birth : </label>
		    					<input type="date" name="dob" required placeholder="YYYY-MM-DD">
    						</section>
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