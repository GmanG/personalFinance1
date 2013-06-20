<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">

<tr>
<th>id</th>
<th>email</th>
</tr><%-- <sql:query var="q" dataSource="ModelJPA" sql="select * from User"></sql:query> --%>
<c:forEach   items="${cate}" var="cate">
<tr>
 	<td> ${cate.id} </td>
 	<td> ${cate.name} </td>
 	
</tr>
</c:forEach>
</table>
<a href="finance.jsp">sss</a>
</body>
</html>