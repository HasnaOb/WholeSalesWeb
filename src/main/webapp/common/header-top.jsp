  <!-- Header Section Begin -->
 
 
  <%@page import="java.util.List, com.jal.wholesales.model.*, com.jal.wholesales.web.controller.*"%>   
  
  
  
    <header class="header-section header_back">
        <div class="header-top">
            <div class="container">
                <div class="ht-left">
                    <div class="mail-service">	
                        <i class=" fa fa-envelope"></i>
                   <small> Atención al cliente: hasna.1310.ub@gmail.com</small>
                    </div>
                    <div class="phone-service">
                        <i class=" fa fa-phone"></i>
                        +34 11.145.868
                    </div>
                    
                     
                </div>
                <div class="ht-right">
              
			           <%
			          	Empresa empresa = (Empresa) session.getAttribute(AttributeNames.EMPRESA);          	
			          	if (empresa==null) {
			          %>          
			          	<a href="/WholeSalesWeb/user/login.jsp" class="login-panel"><i class="fa fa-user"> Iniciar Sesión </i></a>
                    	 
			          <% } else { %>
 
			          	<div class="icon user-profile">
			            	<a href="/WholeSalesWeb/index.jsp" class="login-panel"> Mi perfil (<%=empresa.getNombre()%>) </a>
			            	<a href="/WholeSalesWeb/<%=ViewPaths.EMPRESA_UPDATE %>" ><i class="fa fa-recycle" aria-hidden="true" style="color: black"></i></a>
 
			            	<a href="/WholeSalesWeb/<%=ControllerPaths.EMPRESA%>?<%=ParameterNames.ACTION%>=<%=ActionNames.SIGN_OUT%>" class="login-panel"><i class="fa fa-user"> Cerrar Sesión </i>  </a>
			            	
			            		<a href="/WholeSalesWeb/<%=ControllerPaths.EMPRESA%>?<%=ParameterNames.ACTION%>=<%=ActionNames.DELETE%>" class="login-panel"><i class="fa fa-user"> Darse de baja </i>  </a>
			          	</div>
			          	
			          	
			          	
			          	
			          	
			          	
		 
			          <% } %>
				 
               
                </div>
            </div>
        </div>
        <div class="container">
            <div class="inner-header">
                <div class="row">
                    <div class="col-lg-2 col-md-2">
                        <div class="logo">
                            <a href="index.jsp">
                                <img  src="/WholeSalesWeb/Imagenes/wholsales (1).png" alt="">
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-7 col-md-7">
                        <div class="advanced-search">
                        
             		 <form action="/WholeSalesWeb<%=ControllerPaths.PRODUCTO%>" method="post">
                         
                            	
                            <div class="input-group">
                             <input type="hidden" name="<%=ParameterNames.ACTION %>" value="<%=ActionNames.SEARCH%>"/>
                                <input type="text" placeholder="What do you need?" name="<%=ParameterNames.NOMBRE_PRODUCTO%>">
                                <button type="submit"><i class="ti-search"></i></button>
                                
                                <a href="/WholeSalesWeb/<%=ControllerPaths.PRODUCTO %>?action=<%=ActionNames.ADVANCED_SEARCH%>" ><p style="text-align: center; color:black">Buscador Avanzado</p></a>
                            </div>
                          </form>
                        </div>	
                    </div>
                    <div class="col-lg-3 text-right col-md-3">
                        <ul class="nav-right">
                            <li class="heart-icon">
                                <a href="#">
                                    <i class="icon_heart_alt"></i>
                                    <span>1</span>
                                </a>
                            </li>
                            <li class="cart-icon">
                                <a href="#">
                                    <i class="icon_bag_alt"></i>
                                    <span>3</span>
                                </a>
                                <div class="cart-hover">
                                    <div class="select-items">
                                        <table>
                                            <tbody>
                                                <tr>
                                                    <td class="si-pic"><img src="img/select-product-1.jpg" alt=""></td>
                                                    <td class="si-text">
                                                        <div class="product-selected">
                                                            <p>$60.00 x 1</p>
                                                            <h6>Kabino Bedside Table</h6>
                                                        </div>
                                                    </td>
                                                    <td class="si-close">
                                                        <i class="ti-close"></i>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="si-pic"><img src="img/select-product-2.jpg" alt=""></td>
                                                    <td class="si-text">
                                                        <div class="product-selected">
                                                            <p>$60.00 x 1</p>
                                                            <h6>Kabino Bedside Table</h6>
                                                        </div>
                                                    </td>
                                                    <td class="si-close">
                                                        <i class="ti-close"></i>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="select-total">
                                        <span>total:</span>
                                        <h5>$120.00</h5>
                                    </div>
                                    <div class="select-button">
                                        <a href="#" class="primary-btn view-card">VIEW CARD</a>
                                        <a href="#" class="primary-btn checkout-btn">CHECK OUT</a>
                                    </div>
                                </div>
                            </li>
                            <li class="cart-price">$150.00</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
       
    </header>
    <!-- Header End -->	