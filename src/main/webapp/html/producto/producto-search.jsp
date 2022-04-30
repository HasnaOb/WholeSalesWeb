
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.jal.wholesales.model.Marca, com.jal.wholesales.model.Seccion, com.jal.wholesales.web.controller.*"%>
<%@include file="/common/header.jsp"%>

<%
List<Marca> marcas = (List<Marca>) request.getAttribute(AttributeNames.MARCA);
List<Seccion> secciones = (List<Seccion>) request.getAttribute(AttributeNames.SECCION);
%>

<div class="register-login-section spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 offset-lg-3">
				<div class="register-form">
					<h2>Buscador Avanazado</h2>
					<form action="/WholeSalesWeb<%=ControllerPaths.PRODUCTO%>"
						method="post">
						<input type="hidden" name="action"
							value="<%=ActionNames.SEARCH %>" />



						<div class="group-input">
							<label for="name">Nombre del producto </label> <input type="text"
								name="<%=ParameterNames.NOMBRE_PRODUCTO%>" id="name">
						</div>

						<div class="group-input">
							<label for="descripcion">Descripción del producto</label> <input
								type="text" name="<%=ParameterNames.DESCRIPCION %>"
								id="descripcion">
						</div>

						<div class="group-input">
							<label for="precio">Precio Mínimo</label> <input type="number"
								min="0" max="10000" name="<%=ParameterNames.PRECIO_MIN %>"
								id="precio">
						</div>
						<div class="group-input">
							<label for="precio">Precio Máximo</label> <input type="number"
								min="0" max="10000" name="<%=ParameterNames.PRECIO_MAX%>"
								id="precio">
						</div>

						<div class="group-input">
							<label for="marca">Marca</label> <select
								name="<%=ParameterNames.ID_MARCA %>" id="marca">
								<option value=""></option>
								<%
	                                
	                                for(Marca m:marcas){
	                                	%>
								<option value="<%=m.getId() %>"><%=m.getNombre() %></option>
								<%
	                                }

	                                
	                                %>

							</select>
						</div>

						<div class="group-input">
							<label for="seccion">Seccion</label> <select
								name="<%=ParameterNames.ID_SECCION %>" id="seccion">
								<option value=""></option>
								<%
	                                
	                                for(Seccion s:secciones){
	                                	%>
								<option value="<%=s.getId() %>"><%=s.getNombre() %></option>
								<%
	                                }

	                                
	                                %>

							</select>
						</div>



						<button type="submit" class="site-btn register-btn">Buscar</button>
					</form>

				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="/common/footer.jsp"%>
