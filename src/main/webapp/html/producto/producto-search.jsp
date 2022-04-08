 
<%@ page import="com.jal.wholesales.model.*, com.company.wholesales.service.*,  java.util.*" %>

            <% 
            String nombreProducto = request.getParameter("nombre");
            if(nombreProducto==null) {nombreProducto="";}
            %>
        <h3>Busqueda de productos</h3>
        <form action="/WholeSalesWeb/ProductoServlet" method="post">
            <input type="text" name="nombre" placeholder="Nombre del producto"> <br>
            <input type="submit" value="submit">
        </form>
        <ul>
         	<% 	if (nombreProducto!=null && nombreProducto!=""){
                		List<Producto> productos = (List<Producto>)request.getAttribute("productos");
                        for (Producto e: productos){
                            %><li><a href="/WholeSalesWeb/html/producto/producto-details.jsp?" id=<%=e.getId()%>"><%=e.getNombre()%></a></li><%
                        }
                }
         	else{
         		%><p><%=request.getAttribute("error")%></p><%
         	}
      		%>
            </ul>
 