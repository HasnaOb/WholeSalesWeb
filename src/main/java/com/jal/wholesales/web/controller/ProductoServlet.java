package com.jal.wholesales.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.company.wholesales.service.ProductoService;
import com.company.wholesales.service.impl.ProductoServiceImpl;
import com.jal.wholesales.model.Empresa;
import com.jal.wholesales.model.Producto;
import com.jal.wholesales.model.ProductoDTO;
import com.jal.wholesales.service.ProductoCriteria;
import com.jal.wholesales.web.SessionManager;
import com.jal.wholesales.web.controller.utils.Validator;
import com.wholesales.exception.DataException;
import com.wholesales.exception.ServiceException;
 

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
//		 
		
		String action = request.getParameter(ParameterNames.ACTION);

		ErrorsList errors = new ErrorsList();
		request.setAttribute(AttributeNames.ERROR, errors);
		
		String targetView = null;
		boolean forward = true;
		
		if(ActionNames.SEARCH.equalsIgnoreCase(action)){
			
//			targetView = request.getContextPath()+ViewPaths.HOME;
			
			
			String nombreStr = request.getParameter(ParameterNames.NOMBRE_PRODUCTO);
//			String descripcionStr = request.getParameter(ParameterNames.DESCRIPCION);
//			String precioStr = request.getParameter(ParameterNames.PRECIO);
//			String idCategoriaStr = request.getParameter(ParameterNames.ID_CATEGORIA);
//			String idSeccionStr = request.getParameter(ParameterNames.ID_SECCION);
//			String idMarcaStr = request.getParameter(ParameterNames.ID_MARCA);
//			String idPaisStr = request.getParameter(ParameterNames.ID_PAIS);
//			String idEmpresaStr = request.getParameter(ParameterNames.ID_EMPRESA);
//			
			
			Integer nombre=null;
			if (!StringUtils.isBlank(nombreStr)) {
				nombre=Validator.validaInteger(nombreStr);
			}
//			Integer descripcion=null;
//			if (!StringUtils.isBlank(descripcionStr)) {
//				descripcion=Validator.valInteger(descripcionStr);
//			}
//			Integer precio=null;
//			if (!StringUtils.isBlank(precioStr)) {
//				precio=Validator.valInteger(precioStr);
//			}
//			Integer idCategoria=null;
//			if (!StringUtils.isBlank(idCategoriaStr)) {
//				idCategoria=Validator.valInteger(idCategoriaStr);
//			}
//			Integer idSeccion=null;
//			if (!StringUtils.isBlank(idSeccionStr)) {
//				idSeccion=Validator.valInteger(idSeccionStr);
//			}
//			Integer idMarca=null;
//			if (!StringUtils.isBlank(idMarcaStr)) {
//				idMarca=Validator.valInteger(idMarcaStr);
//			}
//			Integer idPais=null;
//			if (!StringUtils.isBlank(idPaisStr)) {
//				idPais=Validator.valInteger(idPaisStr);
//			}
//			Integer idEmpresa=null;
//			if (!StringUtils.isBlank(idEmpresaStr)) {
//				idEmpresa	=Validator.valInteger(idEmpresaStr);
//			}
//			
//			
			
			
		
		ProductoCriteria pc = new ProductoCriteria();
		pc.setNombre(nombreStr);
//		pc.setDescripcion(null);
//		// HAY Q CORRIGIR ESTO 
//		pc.setPrecio(null);
//		pc.setIdCategoria(null);
//		pc.setIdSeccion(null);
//		pc.setIdMarca(null);
//		pc.setIdEmpresa(null);
//		
//		
		
		if(!errors.hasErrors()) {
			try {

				List<Producto> productos = productoService.findByCriteria(pc);
				 
				request.setAttribute(AttributeNames.PRODUCTO, productos);

				//Dirigir a...
				targetView = ViewPaths.PRODUCTO_RESULTS;

			}catch (DataException de) {
				logger.error(de.getMessage(), de);
				errors.addCommonError(Errors.ERROR_DATA);

			}catch (ServiceException se) {
				logger.error(se.getMessage(), se);
				errors.addCommonError(Errors.ERROR_SERVICE);

			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				errors.addCommonError(Errors.ERROR_E);
			}
		}

	}else if (ActionNames.DETAIL.equalsIgnoreCase(action)) {
		targetView = request.getContextPath()+ViewPaths.HOME;
		// recoger los datos de la JSP 
		String idProductoStr = request.getParameter(ParameterNames.ID_PRODUCTO);
		//validacion y conversión de los datos   
		
		Long idProducto = null;
		if  (StringUtils.isBlank(idProductoStr)) {
			logger.error("Dato incorrecto"+idProductoStr);
			errors.addParameterError(ParameterNames.ID_PRODUCTO, Errors.ERROR_ID_PRODUCTO_OBLIGATORIO);	
		} else {
			idProducto = Validator.validaLong(idProductoStr);
		}
		
		logger.info("Id del producto: "+idProducto);
		//Accedemos a la capa de negocio si todo esta OK
		if(!errors.hasErrors()) {
			try {

				Producto p = productoService.findById(idProducto);

				request.setAttribute(AttributeNames.PRODUCTO, p);

				//Dirigir a producto-details
				targetView = ViewPaths.PRODUCTO_DETAILS;

			}catch (DataException de) {
				logger.error(de.getMessage(), de);
				errors.addCommonError(Errors.ERROR_DATA);

			}catch (ServiceException se) {
				logger.error(se.getMessage(), se);
				errors.addCommonError(Errors.ERROR_SERVICE);

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				errors.addCommonError(Errors.ERROR_E);
			}
		}
	} else if (ActionNames.CREATE.equalsIgnoreCase(action)){
 
		Empresa empresa = (Empresa) SessionManager.get(request, AttributeNames.EMPRESA);
		
		String nombreStr = request.getParameter(ParameterNames.NOMBRE_PRODUCTO);
		String descripcionStr = request.getParameter(ParameterNames.DESCRIPCION);
		String precioStr = request.getParameter(ParameterNames.PRECIO);
		String idCategoriaStr = request.getParameter(ParameterNames.ID_CATEGORIA);
		String idSeccionStr = request.getParameter(ParameterNames.ID_SECCION);
		String idMarcaStr = request.getParameter(ParameterNames.ID_MARCA);
		String idPaisStr = request.getParameter(ParameterNames.ID_PAIS);
		String idEmpresaStr = request.getParameter(ParameterNames.EMPRESA_ID);
//		
		Producto producto = new Producto();
		
		if (!StringUtils.isBlank(nombreStr)) {
			nombreStr = Validator.validaString(nombreStr);
			if (nombreStr!=null) {
				producto.setNombre(nombreStr);;
			} else {
				logger.debug("Dato incorrecto titulo: "+nombreStr);
				errors.addParameterError(ParameterNames.NOMBRE_PRODUCTO, Errors.ERROR_NOMBRE_FORMATO_INCORRECTO);
			}
		} else {
			logger.debug("El nombre es un dato obigatorio: "+nombreStr);
			errors.addParameterError(ParameterNames.NOMBRE_PRODUCTO, Errors.ERROR_NOMBRE_FORMATO_INCORRECTO);
		}

		
		
		
		if (!StringUtils.isBlank(descripcionStr)) {
			descripcionStr = Validator.validaString(descripcionStr);
			if (descripcionStr!=null) {
				producto.setDescripcion(descripcionStr);;
			} else {
				logger.debug("Dato incorrecto descripcion: "+descripcionStr);
				errors.addParameterError(ParameterNames.DESCRIPCION, Errors.ERROR_DESCRIPCION_FORMATO_INCORRECTO);
			}
		} else {
			logger.debug("La discripción  es un dato obigatorio: "+descripcionStr);
			errors.addParameterError(ParameterNames.DESCRIPCION, Errors.ERROR_DESCRIPCION_FORMATO_INCORRECTO);
		}
		
		
		Integer precio=null;
		if (!StringUtils.isBlank(precioStr)) {
			precio = Validator.validaInteger(precioStr);
			if (precio!=null) {
				producto.setPrecio(precio);
			} else {
				logger.debug("Dato incorrecto precio: "+precioStr);
				errors.addParameterError(ParameterNames.PRECIO, Errors.ERROR_PRECIO);
			}
		}
		
		Integer idCategoria=null;
		if (!StringUtils.isBlank(idCategoriaStr)) {
			idCategoria = Validator.validaInteger(idCategoriaStr);
			if (idCategoria!=null) {
				producto.setIdCategoria(idCategoria);
			} else {
				logger.debug("Dato incorrecto categoria: "+idCategoriaStr);
				errors.addParameterError(ParameterNames.CATEGORIA, Errors.ERROR_CATEGORIA);
			}
		}

		Integer idSeccion=null;
		if (!StringUtils.isBlank(idSeccionStr)) {
			idSeccion = Validator.validaInteger(idSeccionStr);
			if (idCategoria!=null) {
				producto.setIdSeccion(idSeccion);
			} else {
				logger.debug("Dato incorrecto seccion: "+idSeccionStr);
				errors.addParameterError(ParameterNames.SECCION, Errors.ERROR_SECCION);
			}
		}
		
		Integer idMarca=null;
		if (!StringUtils.isBlank(idMarcaStr)) {
			idMarca = Validator.validaInteger(idMarcaStr);
			if (idMarca!=null) {
				producto.setIdMarca(idMarca);
			} else {
				logger.debug("Dato incorrecto marca: "+idMarcaStr);
				errors.addParameterError(ParameterNames.MARCA, Errors.ERROR_MARCA);
			}
		}
		Integer idPais=null;
		if (!StringUtils.isBlank(idPaisStr)) {
			idPais = Validator.validaInteger(idPaisStr);
			if (idPais!=null) {
				producto.setIdPais(idMarca);
			} else {
				logger.debug("Dato incorrecto pais: "+idPaisStr);
				errors.addParameterError(ParameterNames.PAIS, Errors.ERROR_PAIS);
			}
		}
		
		Integer idEmpresa=null;
		if (!StringUtils.isBlank(idEmpresaStr)) {
			idEmpresa = Validator.validaInteger(idEmpresaStr);
			if (idEmpresa!=null) {
				producto.setIdEmpresa(idMarca);
			} else {
				logger.debug("Dato incorrecto empresa: "+idEmpresaStr);
				errors.addParameterError(ParameterNames.EMPRESA_ID, Errors.ERROR_PAIS);
			}
		}
		
		
	
		
		if(!errors.hasErrors()) {
			try {

				productoService.create(producto);
				logger.info("producto Creado: "+producto);

				request.setAttribute("", producto);

				// Dirigir a..
				targetView =ViewPaths.HOME;

			}catch (DataException de) {
				logger.error(de.getMessage(), de);
				errors.addCommonError(Errors.ERROR_DATA);

			}catch (ServiceException se) {
				logger.error(se.getMessage(), se);
				errors.addCommonError(Errors.ERROR_SERVICE);

			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				errors.addCommonError(Errors.ERROR_E);
			}
		}
		
	}
		
		logger.info(forward?"Forwarding to ":"Redirecting to ", targetView);

		if (forward) {
			request.getRequestDispatcher(targetView).forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath()+targetView);
		}
	
		
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}