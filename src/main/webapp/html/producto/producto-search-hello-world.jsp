<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- busqueda de productos -->
<div id="producto-search">
	<form action="/WholeSalesWeb/producto" method="post">
	<input type="hidden" name="action" value="search"/>
	<p><input type="text" name="nombre" placeholder=" "/></p>
	<p>Precio desde:<input type="text" name="precio-desde">0.0 </>  </p>
	<p>Password: <input type="password" name="contrasena"></p>
	<input type="submit" value="Buscar" name="Buscar"/>
	
		<select name="pais">
			<option value="1">España</option>
			<option value="2">Alemaña</option>
			<option value="3">Francia</option>
			<option value="4">Belgica</option>
		</select>
	
	
	</form>
</div>

</body> 
</html>