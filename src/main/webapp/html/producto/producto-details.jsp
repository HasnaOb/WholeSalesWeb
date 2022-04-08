<%@include file="/common/header.jsp"%>
<%@ page import=" com.jal.wholesales.model.*, com.company.wholesales.service.*, com.company.wholesales.service.impl.*, java.util.*" %>
	<div>
        <%    
        Long n = Long.valueOf(request.getParameter("id"));
        
        ProductoService productoService = new ProductoServiceImpl();
        Producto e = productoService.findById(1L); %>
            <h3><%=e.getNombre()%></h3><br>
            <p><strong>ID:&nbsp;</strong><%=e.getId()%></p><br>
            <p><strong>CategoriaID:&nbsp;</strong><%=e.getIdCategoria()%></p><br>
             
     </div>       
<%@include file="/common/footer.jsp"%>