<%@page import="com.jal.wholesales.web.controller.*"%>


<%@include file="/common/header.jsp"%>	
	
	
	<div class="register-login-section spad">
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-6 offset-lg-3">
	                    <div class="register-form">
	                        <h2>Register</h2>
	                           <form action="/WholeSalesWeb<%=ControllerPaths.EMPRESA%>" method="post">
	                           	<input type="hidden" name="action" value="<%=ActionNames.SIGN_UP %>"/>
	
	
	
	                            <div class="group-input">
	                                <label for="name">Nombre *</label>
	                                <input type="text"  name="<%=ParameterNames.NOMBRE%>" id="name">
	                            </div>
	
	                            <div class="group-input">
	                                <label for="username">Nombre del Usuario *</label>
	                                <input type="text"  name="<%=ParameterNames.NOMBRE_USUARIO %>" id="username">
	                            </div>
	
	                            <div class="group-input">
	                                <label for="email">Email *</label>
	                                <input type="email"  name="<%=ParameterNames.EMAIL%>" id="email">
	                            </div>
	
	                            <div class="group-input">
	                                <label for="pass">Contaseña *</label>
	                                <input type="text"   name="<%=ParameterNames.CONTRASENA %>" id="contrasena">
	                            </div>
	                            <div class="group-input">
	                                <label for="tipoEmpresa">Tipo Empresa *
	                                    <select name= name="<%=ParameterNames.ID_TIPO_EMPRESA %>">
	
	                                        <option value="1">Tienda</option>
	                                        
	                                        <option value="2">Empresa</option>
	 
	                                    </select>
	                              </label>
	                            </div>
	                            <div class="group-input">
	                                <label for="cif">CIF *</label>
	                                <input type="text"  name="<%=ParameterNames.CIF %>" id="cif">
	                            </div>
	                            <button type="submit" class="site-btn register-btn">REGISTER</button>
	                        </form>
	                        <div class="switch-login">
	                            <a href="./login.html" class="or-login">Or Login</a>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    
<%@include file="/common/footer.jsp"%>