<%@page import="com.jal.wholesales.web.controller.*"%>
<%@include file="/common/header.jsp"%>
 
<body>

<!-- busqueda de EMPRESAS -->
<div id="empresa-search">
   <form action="/WholeSalesWeb<%=ControllerPaths.EMPRESA%>" method="post">
		<input type="hidden" name="<%=ParameterNames.ACTION %>" value="<%=ActionNames.SEARCH%>"/>

	<p><input type="text" name="<%=ParameterNames.NOMBRE%>" placeholder="Nombre de la empresa"/></p>
	<p>Nombre de usuario<input type="text" name="<%=ParameterNames.NOMBRE_USUARIO%>">0.0 </>  </p>
	<p><input type="email" name="email" placeholder="<%=ParameterNames.EMAIL%>"/></p>
	<p>Password: <input type="password" name="<%=ParameterNames.CONTRASENA%>"></p>
	<input type="submit" value="Buscar" name="Buscar"/>
	 
	
	</form>
</div>

</body> 

<%@include file="/common/footer.jsp"%>	