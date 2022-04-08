<%@page import="com.jal.wholesales.web.controller.*"%>
<%@include file="/common/header.jsp"%>
 
<body>

<!-- busqueda de productos -->
<div id="empresa-search">
   <form action="/WholeSalesWeb<%=ControllerPaths.EMPRESA%>" method="post">
		<input type="hidden" name="<%=ParameterNames.ACTION %>" value="<%=ActionNames.SEARCH%>"/>

	<p><input type="text" name="<%=ParameterNames.NOMBRE%>" placeholder="Nombre de la empresa"/></p>
	<p>Nombre de usuario<input type="text" name="nombre-usuario">0.0 </>  </p>
	<p><input type="email" name="email" placeholder="Email"/></p>
	<p>Password: <input type="password" name="contrasena"></p>
	<input type="submit" value="Buscar" name="Buscar"/>
	 
	
	</form>
</div>

</body> 

<%@include file="/common/footer.jsp"%>	