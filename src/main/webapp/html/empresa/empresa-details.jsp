<%@include file="/common/header.jsp"%>
 
<%@ page import="java.util.List, com.jal.wholesales.model.Empresa" %>
<%@ page import="java.util.List, com.jal.wholesales.model.Producto" %>
<%@page import="com.jal.wholesales.web.controller.*"%>
 
 
 
<body>
<%
	Empresa e = (Empresa) request.getAttribute(AttributeNames.EMPRESA);
 
%>
		<div class="ImgEmpresa">
		
			<img src="Imagenes/empresa.jpg">
		</div>
		<div class="EmpresaDetails">
			<h2><%=e.getNombre()%></h2>
			<h4><%=e.getCif() %></h4>
			
			 
			<p><%=e.getEmail() %></p>
		 
		</div>

</body><br><br>

<%@include file="/common/footer.jsp"%>
 
