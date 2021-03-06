
<%@page import="com.jal.wholesales.web.SessionManager"%>
<%@include file="/common/header.jsp"%>	


<%@page import="com.jal.wholesales.web.controller.*"%>


	
	
	<div class="register-login-section spad">
	        <div class="container">	
	            <div class="row">
	                <div class="col-lg-6 offset-lg-3">
	                    <div class="register-form">
	                        <h2>Alta de productos</h2>
	                           <form action="/WholeSalesWeb<%=ControllerPaths.PRIVATE_PRODUCTO%>" method="post">
	                           	<input type="hidden" name="action" value="<%=ActionNames.CREATE %>"/>
	
	
	
	                            <div class="group-input">
	                                <label for="name">Nombre del Producto *</label>
	                                <input type="text"  name="<%=ParameterNames.NOMBRE_PRODUCTO%>" id="name">
	                            </div>
	
	                            <div class="group-input">
	                                <label for="descripcion">Descripcion *</label>
	                                <input type="text"  name="<%=ParameterNames.DESCRIPCION %>" id="username">
	                            </div>
	
	                            <div class="group-input">
	                                <label for="precio">Precio *</label>
	                                <input type="number" min="0" max="10000"   name="<%=ParameterNames.PRECIO%>" id="email">
	                            </div>
	
	      
	                            <div class="group-input">
	                                <label for="categoria">Categorķas *
	                                    <select name= name="<%=ParameterNames.CATEGORIA %>">
	
	                                        <option value="1">Zapatos</option>
	                                        <option value="2">Bolsos</option>
	                                        <option value="3">Perfumes</option>
	                                        <option value="4">Relojes</option>
	 	
	                                    </select>
	                              </label>
	                            </div>
	                             <div class="group-input">
	                                <label for="seccion">Seccion *
	                                    <select name= name="<%=ParameterNames.SECCION %>">
	                                        <option value="1">Hombre</option>
	                                        <option value="2">Mujer</option>
	                                        <option value="3">Nińo</option>
	                                        <option value="4">Nińa</option>
	                                    </select>
	                              </label>
	                            </div>
	                             <div class="group-input">
	                                <label for="pais">Paķs *
	                                    <select name= name="<%=ParameterNames.PAIS %>">
	
	                                        <option value="1">Espańa</option>
	                                        <option value="2">Alemania</option>
	                                        <option value="3">Francia</option>
	                                        <option value="4">Belgica</option>
	 	
	                                    </select>
	                              </label>
	                            </div>

	                            
	                            <input type="file" name="fotos" id="fotos" multiple/><br><br>
	                            <button type="submit" class="site-btn register-btn">Dar Alta</button>
	                        </form>
	                      
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    
<%@include file="/common/footer.jsp"%>