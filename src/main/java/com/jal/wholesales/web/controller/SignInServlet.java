package com.jal.wholesales.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.wholesales.service.EmpresaService;
import com.company.wholesales.service.impl.EmpresaServiceImpl;
import com.jal.wholesales.model.Empresa;
import com.jal.wholesales.web.SessionManager;
import com.jal.wholesales.web.controller.utils.CookieManager;

import util.PasswordEncryptionUtil;

@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {    

	private EmpresaService empresaService = null;
	
	public SignInServlet() {
		super();
		empresaService= new EmpresaServiceImpl();
	}         
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter(ParameterNames.EMPRESA);
		String contrasena = request.getParameter(ParameterNames.CONTRASENA);

		String targetView = null;
		boolean redirect = false;
		
		
		
		try {
			Empresa empresa = empresaService.findById(0);

			if (nombre==null) {
				request.setAttribute(AttributeNames.ERROR, AttributeNames.USER_NOT_FOUND_ERROR);
				targetView = ViewPaths.SIGN_IN;
			
			}else {				
				if (!PasswordEncryptionUtil.checkPassword(contrasena,empresa.getContrasena())) {
					request.setAttribute(AttributeNames.ERROR, "Contraseña incorrecta");			
					targetView = ViewPaths.SIGN_IN;
				} else {
					SessionManager.set(request, AttributeNames.EMPRESA, empresa);
					CookieManager.setValue(response, "login", empresa.getEmail(), 7*24*60*60);
					targetView = ViewPaths.HOME;
				 
					redirect = true;
				}
			}
			
	} catch (Exception e) {
		 
		request.setAttribute(AttributeNames.ERROR, e.getMessage());
		targetView = ViewPaths.SIGN_IN;
	}
}
	
}