
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<script src="js/bootstrap.min.js"></script>
	<script src="http://code.jquery.com/jquery.js"></script>
<title>Insert title here</title>
</head>
<body>
	<script src="js/bootstrap.min.js"></script>
`	<script src="http://code.jquery.com/jquery.js"></script>
	<div class="navbar  navbar-inverse navbar-fixed-top">
	  <div class="navbar-inner">
		<div class="container">
	 		 <ul class="nav">
	 		 
			  	<li><a class="brand" name="email" href="#"><%=session.getAttribute("email") %></a></li>
	    		<!-- <a href="logOff">Logout</a> -->
		 		<li><a id="header-login-button" href="logOff" class="button gray proxima-bold login">Logout</a></li>
		 	</ul>
		</div>
	  </div>
	</div>
	<div style="margin-top:30px;">
		<div style="width:250px; height:200px; border:1px solid; margin:30px 20px 0px 40px; float:left">
			Total momey
		</div>
		<div style="border:1px solid;float:left;width:800px;height:800px">
			<div  style="margin:30px auto 0 5px; width:500px; height:220px;border:1px solid;">
				<div class="tabbable"  style="background:white"> <!-- Only required for left/right tabs -->
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab1" data-toggle="tab">Money out</a></li>
						<li><a href="#tab2" data-toggle="tab">Money come</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tab1">
							 <div class="tab-pane" id="tab1">
							
								<form action="outmoney" method="POST">
									<select class="selectpicker">
										<optgroup label="Personal">
										<option>Wallet</option>
										<option>Save</option>
									</select>
									<input type="text" placeholder="Amount" name="amount">
									<select class="selectpicker">
										<option>No categories</option>
										<option>Home</option>
										<option>Food</option>
									</select>
									<input type="text" placeholder="Description" name="descrip"><br>
									<input type="submit" value="Add">
								</form>
								
							</div>
						</div>
						<div class="tab-pane" id="tab2">
							<form action="addmoney" method="POST">
								<select class="selectpicker" name="category">
									<optgroup label="Personal">
									 <!-- <option name="wallet">Wallet</option>
									<option name="save">Save</option>  -->
									
								 <c:forEach items="${cate}" var="cate">
								<option >${cate.name}</option>
								  
									</c:forEach>   
								</select>
								<input type="text" placeholder="Amount1" name="amount">
								<select class="selectpicker" name="type">
									<option name="noCategorie">No categories</option>
									<option name="home">Home</option>
									<option name="food">Food</option>
								</select>
								<input type="text" placeholder="Description" name="descrip"><br>
								<input type="submit"  value="Add">
							</form>
						</div>
					</div>
				</div>
			</div>
			<div style="width:350px;height:200px; border:1px solid;margin:10px;">
				<table border="1">

	<tr>
		<th>id</th>
		<th>email</th>
		<th>email</th>
	</tr>
	<c:forEach   items="${result}" var="cate1">
		<tr>
		 	<td> ${cate1.sum} </td>  
		 	 <td> ${cate1.descrip} </td>
		 	 <td> ${cate1.categorietype.name} </td> 
		 	
		</tr>
	</c:forEach>
	
</table>		
			</div>
		</div>
	</div>
     

 

</body>
</html>