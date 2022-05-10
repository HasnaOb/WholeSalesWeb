<%@include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.jal.wholesales.model.Producto" %>
<%@page import="com.jal.wholesales.web.controller.*"%>
 
 <body>
<%
	Producto p = (Producto) request.getAttribute(AttributeNames.PRODUCTO);
%>

  							    <div class="col-lg-4 col-sm-6">
		                                <div class="product-item">
		                                    <div class="pi-pic productos">
		                                        <img src="Imagenes/products.jpg" alt="">
		                                        <div class="icon">
		                                            <i class="icon_heart_alt"></i>
		                                        </div>
		                                        <ul>
		                                            <li class="w-icon active"><a href="product_Info.jsp"><i class="icon_bag_alt"></i></a></li>
		                                            <li class="quick-view"><a href="product_Info.jsp">+ Quick View</a></li>
		                                            <li class="w-icon"><a href="product_Info.jsp"><i class="fa fa-random"></i></a></li>
		                                        </ul>
		                                    </div>
		                                    <div class="pi-text">
		                                       
		                                        <a href="product_Info.jsp">
		                                            <h5><%=p.getNombre()%></h5>
		                                        </a>
		                                        <div class="product-price">
		                                        $<%=p.getPrecio() %>
		                                            <span>$330</span>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
 

</body>
   
<%@include file="/common/footer.jsp"%>