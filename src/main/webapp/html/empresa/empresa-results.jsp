
 <%@include file="/common/header.jsp"%>
 
<%@ page import="java.util.List, com.jal.wholesales.model.Empresa" %>
<%@page import="com.jal.wholesales.web.controller.*"%>

 
<%
	List<Empresa> e = (List<Empresa>) request.getAttribute(AttributeNames.EMPRESA);
	 if (e!= null && !e.isEmpty()){
		 
		 for( Empresa empresas :e ){
			  
	%>
	
	    					 <div class="empresasDiv">
		                                 <a href="/WholeSalesWeb/empresa?action=detail&empresaId=<%=empresas.getId()%>"><%=empresas.getNombre()%></a>
		                      </div>
		 
	<%
		}		
	}else {
		%>
		<div  style="text-align: center;"  class="deal-of-week">
			<h1>La empresa no existe</h1>
		</div>
	<%	
	}
%>
 <%@include file="/common/footer.jsp"%>