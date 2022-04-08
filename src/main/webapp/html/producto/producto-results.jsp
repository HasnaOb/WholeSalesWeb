 
  
<%@ page import="java.util.List, com.jal.wholesales.model.Producto" %>
 
<%
	 Producto p = (Producto)request.getAttribute("productos");
	 
	%>
		<p><%=p.getNombre()%> cuesta <%=p.getPrecio()%> </p>
	<%	
 
%>
  