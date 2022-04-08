<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.jal.wholesales.model.Empresa" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Empresa e = (Empresa) request.getAttribute("empresas");
%>
<h3><%=e.getNombre()%></h3>
<p><%=e.getCif() %></p>

</body>
</html>