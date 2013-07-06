
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>Bootstrap 101 Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<script src="js/bootstrap.min.js"></script>
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/ajax.js"></script>
	<link rel="stylesheet" type="text/css" href="css/my.css" />
  </head>
  <body>
	<script src="js/bootstrap.min.js"></script>
`	<script src="http://code.jquery.com/jquery.js"></script>
	<div class="navbar  navbar-inverse navbar-fixed-top">
	  <div class="navbar-inner">
		<div class="container">
	 		 <ul class="nav">
	 		 
			  	<li><a class="brand" id="email" name="email" href="#"><%=session.getAttribute("email") %></a></li>
	    		<!-- <a href="logOff">Logout</a> -->
		 		<li><a id="header-login-button" href="logOff" class="button gray proxima-bold login">Logout</a></li>
		 	</ul>
		</div>
	  </div>
	</div>
	<div id="main">
		<div id="left">
			<div id="totalMoney">
			Total momey ${total}
			</div>
			<div id="messages"></div>
			
		</div>
		<div id="right">
			<div  id="tabMenu">
				<div class="tabbable"  style="background:white"> <!-- Only required for left/right tabs -->
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab1" data-toggle="tab">Money out</a></li>
						<li><a href="#tab2" data-toggle="tab">Money come</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tab1">
							 <div class="tab-pane" id="tab1">
								<form   method="POST">
										<select class="selectpicker" id="category" >
											<c:forEach items="${categoryList}" var="category">
												<option value="${category.name}">${category.name}</option>
											</c:forEach> 
										</select>
										<input type="text" placeholder="Amount" id="amount">
										<select class="selectpicker" id="type">
											<c:forEach items="${typeList}" var="type">
												<option value="${type.name}">${type.name}</option>
											</c:forEach>
										</select>
										<input type="text" placeholder="Description" id="descrip"><br>
										<input type="button" value="Add" id="outMoney">
								</form>
							</div>
						</div>
						<div class="tab-pane" id="tab2">
								<form action="addmoney" method="POST">
									<select class="selectpicker" name="category">
										<optgroup label="Personal">
										 <!-- <option name="wallet">Wallet</option>
										<option name="save">Save</option>  -->
										
										<c:forEach items="${categoryList}" var="category">
											<option name="${category.name}">${category.name}</option>
										  
										</c:forEach>   
									</select>
									<input type="text" placeholder="Amount" name="amount">
									<select class="selectpicker" name="type">
										<c:forEach items="${typeList}" var="type">
											<option name="${type.name}" >${type.name}</option>
										</c:forEach>
									</select>
									<input type="text" placeholder="Description" name="descrip"><br>
									<input type="submit"  value="Add">
								</form>
							</div>
					</div>
				</div>
			</div>
			<div id="userTransaction">
				Last transaction			
			</div>
		</div>
		
	</div>
  </body>
</html>
