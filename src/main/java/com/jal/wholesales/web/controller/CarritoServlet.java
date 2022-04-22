package com.jal.wholesales.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jal.wholesales.model.*;
import com.jal.wholesales.web.SessionManager;
import com.jal.wholesales.web.model.Carrito;
import com.jal.wholesales.web.model.LineaCarrito;
import com.wholesales.exception.DataException;
import com.company.wholesales.service.EmpresaService;
import com.company.wholesales.service.LineaPedidoService;
import com.company.wholesales.service.PedidoService;
import com.company.wholesales.service.ProductoService;
import com.company.wholesales.service.impl.EmpresaServiceImpl;
import com.company.wholesales.service.impl.LineaPedidoServiceImpl;
import com.company.wholesales.service.impl.PedidoServiceImpl;
import com.company.wholesales.service.impl.ProductoServiceImpl;

 

 

 

// @WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(CarritoServlet.class);
	private ProductoService productoService;
	private LineaPedidoService lineaPedidoService;
	private PedidoService pedidoService;
	private EmpresaService empresaService;
	
	
    public CarritoServlet() {
        productoService = new ProductoServiceImpl();
        lineaPedidoService= new LineaPedidoServiceImpl();
        pedidoService = new PedidoServiceImpl();
        empresaService = new EmpresaServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(logger.isDebugEnabled()) {
//			logger.debug(ParameterUtils.print(request.getParameterMap()));
		}
		String action = request.getParameter(ParameterNames.ACTION);
		Carrito carrito = (Carrito)SessionManager.get(request, AttributeNames.CARRITO);
		String target = null;
		ErrorsList errors = new ErrorsList();
		
		boolean redirect = false;
		if (ActionNames.ADD.equalsIgnoreCase(action)) {
			String id= request.getParameter(ParameterNames.ID_PRODUCTO);
			String unidades = request.getParameter(ParameterNames.UNIDADES);
			
			LineaCarrito lineaCarrito = new LineaCarrito(null, 0);
			lineaCarrito.setProducto(null);
			lineaCarrito.setUnidades(Integer.valueOf(unidades));
			Producto producto = null;
			
			// hacemos un booleano para comprovar q el producto ya se añadido anteriormente , 
			//si es el caso hay q sumar las unidades , sino crearlas
			boolean repeticion = false; 
			
			if (repeticion == false ) {
				//Entry almacena la clave y el valor juntos en una clase, los obtenemos en una sola operación
				for(Map.Entry<Long, LineaCarrito> lp: carrito.getLineasCarritoMap().entrySet()){
					
					if(lp.getValue().getProducto()==lineaCarrito.getProducto()) {
					}
				}
			} if(!repeticion) {
				//carrito.addMap( lineaCarrito.getProducto(), lineaCarrito);
			}
			
		}
		SessionManager.set(request, AttributeNames.CARRITO, carrito);

	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
