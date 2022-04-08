package com.jal.wholesales.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.company.wholesales.service.ProductoService;
import com.company.wholesales.service.impl.ProductoServiceImpl;
 
import com.jal.wholesales.model.Producto;
import com.jal.wholesales.service.ProductoCriteria;
 

/**
 * Contrlador (Servlet) para peticiones de producto.
 */
@WebServlet("/producto")
public class ProductoServlet extends HttpServlet {
	private static Logger logger = LogManager.getLogger(ProductoServlet.class);


	private ProductoService productoService = null;

	public ProductoServlet() {
		super();
		productoService= new ProductoServiceImpl();
	}         
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String nombreProducto = request.getParameter(ParameterNames.NOMBRE_PRODUCTO);
//		
//		String target = null;
//		
//		try {
//			List<Producto> productos = productoService.findByNombre(nombreProducto);			
//			if (nombreProducto==null || nombreProducto=="") {
//				request.setAttribute("error", "Introduce datos de busqueda");
//				target = "/html/producto/producto-search.jsp";
//			} else {				
//					request.setAttribute(ParameterNames.PRODUCTO, productos);			
//					target = "/html/producto/producto-search.jsp";
//			}
//
//		 
//			request.getRequestDispatcher(target).forward(request, response);
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		String action = request.getParameter(ParameterNames.ACTION);

		ErrorsList errors = new ErrorsList();
		
		String target = null;
		boolean redirect = false;
		
		if(ActionNames.SEARCH.equalsIgnoreCase(action)){
			String nombre = request.getParameter(ParameterNames.NOMBRE_PRODUCTO);
			String descripcion = request.getParameter(ParameterNames.DESCRIPCION);
			String precio = request.getParameter(ParameterNames.PRECIO);
			String idCategoria = request.getParameter(ParameterNames.ID_CATEGORIA);
			String idSeccion = request.getParameter(ParameterNames.ID_SECCION);
			String idMarca = request.getParameter(ParameterNames.ID_MARCA);
			String idPais = request.getParameter(ParameterNames.ID_PAIS);
			String idEmpresa = request.getParameter(ParameterNames.ID_EMPRESA);
		}
		ProductoCriteria productoCret = new ProductoCriteria();
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}