<%@page import="com.company.wholesales.service.impl.Results"%>
<%@include file="/common/header.jsp"%>
<%@ page import="java.util.List, java.util.Map, java.util.HashMap, com.jal.wholesales.web.controller.utils.ParameterUtils, com.jal.wholesales.model.Producto"%>
<%@page import="com.jal.wholesales.web.controller.*"%>

<%
	 Results<Producto> p = (Results<Producto>)request.getAttribute(AttributeNames.PRODUCTO);
	 
	 if (p!= null && !p.getData().isEmpty()){
		 %> 
	<div class="d-flex justify-content-center flex-wrap mt-5 mb-5">
<%
		 for( Producto producto :p.getData() ){
			 
		  
	 
	%>
<div class="col-lg-4 col-sm-6 mt-5 pb-13">
	<div class="product-item">
		<div class="pi-pic productos">
			<img src="Imagenes/icoRopa/<%=producto.getId() %>.jpg" alt="">
			<div class="icon">
				<i class="icon_heart_alt"></i>
			</div>
			<ul>
				<li class="w-icon active"><a href="product_Info.jsp"><i
						class="icon_bag_alt"></i></a></li>
				<li class="quick-view"><a href="/WholeSalesWeb/producto?action=detail&productoId=<%=producto.getId()%>">+ Quick
						View</a></li>
				<li class="w-icon"><a href="product_Info.jsp"><i
						class="fa fa-random"></i></a></li>
			</ul>
		</div>
		<div class="pi-text">

			<a href="#">
				<h5><%=producto.getNombre()%></h5>
			</a>
			<div class="product-price">
				$<%=producto.getPrecio() %>
				<span>$330</span>
			</div>
		</div>
	</div>
</div>






			
<%	
		}
%>
</div>
<div class="d-flex justify-content-center pb-5">
	 <div class="pagination">
		<!--  Paginador -->
		<%
									Integer currentPage = (Integer) request.getAttribute(AttributeNames.CURRENT_PAGE);
								
									Integer pagingFrom = (Integer) request.getAttribute(AttributeNames.PAGING_FROM);
									Integer pagingTo = (Integer) request.getAttribute(AttributeNames.PAGING_TO);
									
									Integer totalPages = (Integer) request.getAttribute(AttributeNames.TOTAL_PAGES);
									
									Map<String,String[]> parameters = new HashMap<String, String[]>(request.getParameterMap());								
									parameters.remove(ParameterNames.PAGE); // para que no arrastre el valor anterior
									
									// Ya viene terminada en &
									String baseURL = ParameterUtils.getURLPaginacion(request.getContextPath()+ControllerPaths.PRODUCTO, parameters);
	
									
									// Primera
									if (currentPage>1) {
										%>
		<!--<li>-->
		<a href="<%=baseURL%>">Primera</a>
		<!--</li>-->
		<%
									}
	
									
									// Anterior
									if (currentPage>1) {
										%>
		<!-- <li>-->
		<a
			href="<%=baseURL+ParameterNames.PAGE+"="+(currentPage-1)%>">Anterior</a></li>
		<%
									}
									
									// Paginas antes de la actual
									for (int i = pagingFrom; i<currentPage; i++) {
											%>
		<!-- <li>-->
		&nbsp;<a href="<%=baseURL+ParameterNames.PAGE+"="+i%>"><%=i%></a>&nbsp;
		<!-- </li>-->
		<% 
									}	
									
									// La actual
									%>&nbsp;
		<a class="active" href="#"><%=currentPage%></a>&nbsp;<%
									
									// Despues de la actual
									for (int i = currentPage+1; i<=pagingTo; i++) {
											%>
		<!-- <li>-->
		&nbsp;<a href="<%=baseURL+ParameterNames.PAGE+"="+i%>"><%=i%></a>&nbsp;
		<!-- </li>-->
		<% 
									}
									
									// Siguiente
									if (currentPage<totalPages) {
										%>
		<!--<li>-->
		<a
			href="<%=baseURL+ParameterNames.PAGE+"="+(currentPage+1)%>">Siguiente</a></li>
		<%
									}
									
									
									// Última
									if (currentPage<totalPages) {
										%>
		<!--<li>-->
		<a href="<%=baseURL+ParameterNames.PAGE+"="+(totalPages)%>">Última</a></li>
		<%
								}
									
									%>
	</div>
</div>
</div>		
 <% 
		 
	}else {
		%>
<div style="text-align: center;" class="deal-of-week">
	<h1>El producto no existe</h1>
	<h3>
		<a href="/WholeSalesWeb<%=ViewPaths.PRODUCTO_SEARCH %>"> Volver al
			buscador</a>
	</h3>
</div>
<%	
	}
%>

<%@include file="/common/footer.jsp"%>

