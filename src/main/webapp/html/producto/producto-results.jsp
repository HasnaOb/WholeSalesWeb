<%@include file="/common/header.jsp"%> 
  
<%@ page import="java.util.List, com.jal.wholesales.model.Producto" %>
<%@page import="com.jal.wholesales.web.controller.*"%>
 
<%
	 List<Producto> p = (List<Producto>)request.getAttribute(AttributeNames.PRODUCTO);
	 
	 if (p!= null && !p.isEmpty()){
		 
		 for( Producto producto :p ){
			 
		  
	 
	%>
		<p><a href="/WholeSalesWeb/producto?action=detail&productoId=<%=producto.getId()%>"><%=producto.getNombre()%></a></p>
	<%	
		}		
	}else {
		%>
		<p>El producto no existe</p>
	<%	
	}
%>

<%@include file="/common/footer.jsp"%>	
 
  