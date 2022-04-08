
  
<%@ page import="java.util.List, com.jal.wholesales.model.Empresa" %>
 
<%
	Empresa e = (Empresa)request.getAttribute("empresas");
	
	%>
		<p><a href="/WholeSalesWeb/empresa?action=detail&empresa-id=<%=e.getId()%>"><%=e.getNombre()%></a></p>
	<%	
	
%>
 