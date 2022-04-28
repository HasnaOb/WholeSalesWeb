 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.jal.wholesales.web.controller.*"%>
<%@include file="/common/header.jsp"%>
<body>

<!-- busqueda de productos -->
<div id="producto-search">
	<form action="/WholeSalesWeb<%=ControllerPaths.PRODUCTO%>" method="post">
	<input type="hidden" name="<%=ParameterNames.ACTION %>" value="<%=ActionNames.SEARCH%>"/>
	
	<p><input type="text" name="<%=ParameterNames.NOMBRE_PRODUCTO%>" placeholder="Nombre del producto"/></p>
	<p><input type="text" name="<%=ParameterNames.DESCRIPCION%>" placeholder="Buscar por descripcion"/></p>
	<p><input type="text" name="<%=ParameterNames.MARCA%>" placeholder="Buscar por marca "/></p>
	<p><input type="text" name="<%=ParameterNames.PRECIO%>" placeholder="Buscar por precio "/></p>
	 
	<input type="submit" value="Buscar" name="Buscar"/>
	
		 
	
	
	</form>
</div>

</body> 
<%@include file="/common/footer.jsp"%>	