package com.jal.wholesales.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;

import com.company.wholesales.service.EmpresaService;
import com.company.wholesales.service.impl.EmpresaServiceImpl;

import com.jal.wholesales.model.Empresa;
import com.jal.wholesales.web.SessionManager;
import com.jal.wholesales.web.controller.utils.CookieManager;
import com.wholesales.exception.DataException;
import com.wholesales.exception.InstanceNotFoundException;
import com.wholesales.exception.ServiceException;

/**
 * 
 */

/**
 * Contrlador (Servlet) para peticiones de producto.
 */
@WebServlet("/private/empresa")
public class PrivateEmpresaServlet extends HttpServlet {

	private static Logger logger = LogManager.getLogger(PrivateEmpresaServlet.class);

	private EmpresaService empresaService = null;

	public PrivateEmpresaServlet() {
		super();
		empresaService = new EmpresaServiceImpl();
	}

	// CommandManager.getInstance().doAction(request, response);Errors errors = new
	// Errors();
	ErrorsList errors = new ErrorsList();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean forward = true;
		// Cookie[] cookies=request.getCookies();

		String action = request.getParameter(ParameterNames.ACTION);

		String targetView = null;
		boolean redirect = false;
		if (ActionNames.SIGN_OUT.equalsIgnoreCase(action)) {
			CookieManager.setValue(response, AttributeNames.EMPRESA, Strings.EMPTY, 0);
			SessionManager.set(request, AttributeNames.EMPRESA, null);
			targetView = ViewPaths.SIGN_IN;

		} else if (ActionNames.UPDATE.equalsIgnoreCase(action)) {
			Empresa empresa = (Empresa) SessionManager.get(request, AttributeNames.EMPRESA);
			targetView = ViewPaths.EMPRESA_UPDATE;
			Empresa empresaCreate = empresa;

			empresaCreate.setNombre(empresa.getNombre());
			empresaCreate.setNombreUsuario(empresa.getNombreUsuario());
			empresaCreate.setEmail(empresa.getEmail());
			empresaCreate.setContrasena(empresa.getContrasena());
			empresaCreate.setCif(empresa.getCif());
			empresaCreate.setIdTipoEmpresa(empresa.getIdTipoEmpresa());

			if (!errors.hasErrors()) {
				try {
					empresaService.update(empresaCreate);
					SessionManager.set(request, AttributeNames.EMPRESA, empresaCreate);
					targetView = ViewPaths.HOME;
				} catch (InstanceNotFoundException unfe) {
					logger.error("Empresa Update: ", unfe.getMessage(), unfe);
					errors.addCommonError(Errors.ERROR_EMPRESA_NOT_FOUND_EXCEPTION);
				} catch (DataException de) {
					logger.error("Empresa Update: ", de.getMessage(), de);
					errors.addCommonError(Errors.ERROR_DATA);
				} catch (ServiceException e) {
					logger.error("Empresa Update: ", e.getMessage(), e);
					errors.addCommonError(Errors.ERROR_E);

				}
			}

		} else if (ActionNames.DELETE.equalsIgnoreCase(action)) {
			// delete user

			targetView = ViewPaths.SIGN_IN;

			Empresa empresa = (Empresa) SessionManager.get(request, AttributeNames.EMPRESA);

			try {

				empresaService.deleteById(empresa.getId());

				CookieManager.setValue(response, AttributeNames.EMPRESA, Strings.EMPTY, -1);
				SessionManager.set(request, AttributeNames.EMPRESA, null);

			} catch (InstanceNotFoundException unfe) {
				logger.error("UserDelete: ", unfe.getMessage(), unfe);
				errors.addCommonError(Errors.ERROR_DATA);
			} catch (DataException de) {
				logger.error("UserDelete: ", de.getMessage(), de);
				errors.addCommonError(Errors.ERROR_DATA);
			}

		}

		if (redirect) {
			response.sendRedirect(request.getContextPath() + targetView);
		} else {
			request.getRequestDispatcher(targetView).forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}