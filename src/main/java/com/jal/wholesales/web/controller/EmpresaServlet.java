package com.jal.wholesales.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;

import com.company.wholesales.service.EmpresaService;
import com.company.wholesales.service.impl.EmpresaServiceImpl;
import com.google.gson.Gson;
import com.jal.wholesales.model.Empresa;
import com.jal.wholesales.service.EmpresaCriteria;
import com.jal.wholesales.web.SessionManager;
import com.jal.wholesales.web.controller.utils.CookieManager;
import com.wholesales.exception.DataException;
import com.wholesales.exception.InvalidUserOrPasswordException;

import util.PasswordEncryptionUtil;
/**
 * 
 */



/**
 * Contrlador (Servlet) para peticiones de producto.
 */
//@WebServlet("/empresa")
public class EmpresaServlet extends HttpServlet {

	private static Logger logger = LogManager.getLogger(EmpresaServlet.class);

	private EmpresaService empresaService = null;
 
	public EmpresaServlet() {
		super();
		empresaService= new EmpresaServiceImpl();
	}         
	//CommandManager.getInstance().doAction(request, response);Errors errors = new Errors();
	ErrorsList errors = new ErrorsList();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 

		boolean forward = true;
		//	Cookie[] cookies=request.getCookies();


		String action = request.getParameter(ParameterNames.ACTION);


		String targetView = null;
		boolean redirect = false;

		if (ActionNames.SIGN_IN.equalsIgnoreCase(action)) {
			//LOGIN
			String emailStr = request.getParameter(ParameterNames.EMAIL);
			String contrasenaStr = request.getParameter(ParameterNames.CONTRASENA);
			String keepAuthenticated = request.getParameter("keep-authenticated");
			

			if (StringUtils.isBlank(emailStr)) {
				// tratarlo como error
				
			}
			try {
				
				 
				Empresa empresa = empresaService.login(emailStr, contrasenaStr);
				if (empresa!=null) {
					SessionManager.set(request, AttributeNames.EMPRESA, empresa);

					if (keepAuthenticated!=null) {
						CookieManager.setValue(response, "empresa", emailStr, 30*24*60*60); // Agujero!
					} else {
						CookieManager.setValue(response, "empresa", emailStr, 0); 
					}

					targetView = ViewPaths.HOME;
					forward = false;	
				} else {
					errors.addCommonError("Email o contrase�a incorrecto");
				}
				

			} catch (DataException de) {
				logger.error("Login: "+emailStr,de.getMessage(), de);
				errors.addCommonError("Ha ocurrido un problema al consultar sus datos. Por favor int�ntelo mas tarde.");
			} catch (Exception e) {
				logger.error("Login: ",e.getMessage(),e);
				errors.addCommonError("Se ha producido un problema al autenticarse. Por favor intentelo de nuevo mas tarde.");
			}
			} else if (ActionNames.SIGN_OUT.equalsIgnoreCase(action)) {
				CookieManager.setValue(response, AttributeNames.EMPRESA, Strings.EMPTY,0);
				SessionManager.set(request, AttributeNames.EMPRESA, null);
				targetView = ViewPaths.SIGN_IN;


			}
			
			 

		//BUSQUEDA CRITERIA

		else if (ActionNames.SEARCH.equalsIgnoreCase(action)) {	
			String nombreStr=request.getParameter(ParameterNames.NOMBRE);
			String nombreUsuarioStr=request.getParameter(ParameterNames.NOMBRE_USUARIO);
			String emailStr=request.getParameter(ParameterNames.EMAIL);
			String contrasenaStr=request.getParameter(ParameterNames.CONTRASENA);
			String cifStr=request.getParameter(ParameterNames.CIF);
			String idTipoEmpresaStr=request.getParameter(ParameterNames.ID_TIPO_EMPRESA);




			EmpresaCriteria e =new EmpresaCriteria();
			e.setNombre(nombreUsuarioStr);
			e.setIdTipoEmpresa(null);

			try {
				List<Empresa> empresa = empresaService.findByCriteria(e);
				request.setAttribute(AttributeNames.EMPRESA, empresa);
				targetView=ViewPaths.EMPRESA_RESULTS;


			} catch (Exception ex) {
				ex.printStackTrace();
			}


		}else if (ActionNames.DETAIL.equalsIgnoreCase(action)) {

			//VISTA EN DETALLE

			String empresaIdStr=request.getParameter(ParameterNames.EMPRESA_ID);
			System.out.println("empresaIdStr= "+empresaIdStr);

			try {

				Empresa e = empresaService.findById(Long.valueOf(empresaIdStr));
				System.out.println("empresa id= " + empresaIdStr+": "+e);

				// TODO if empresa!=null 
				request.setAttribute(AttributeNames.EMPRESA, e);
				targetView=ViewPaths.EMPRESA_DETAIL;

			}catch (Exception ex) {
				ex.printStackTrace();
			}




//					} else if (ActionNames.SIGN_IN.equalsIgnoreCase(action)) {
//			//			System.out.println(request.getRemoteAddr()+" pulsou");
//			//			response.sendRedirect("http://www.lavozdegalicia.com");
//			//		
//						String emailStr = request.getParameter(ParameterNames.EMAIL);
//						String contrasenaStr = request.getParameter(ParameterNames.CONTRASENA);
//						try {
//							System.out.println("Autenticando a "+emailStr+"...");
//							Empresa empresa = empresaService.login(emailStr, contrasenaStr);
//							System.out.println(emailStr+": Empresa = "+empresa);
//			
//			                SessionManager.set(request, AttributeNames.EMPRESA, empresa);
//			                request.setAttribute(action, action);
//			
//							targetView = ViewPaths.HOME;
//						} catch (Exception e) {
//							// TODO
//							e.printStackTrace();
//							//llevaria a una vista rollo error
//							targetView = ViewPaths.SIGN_IN;
//						}		
		}else if (ActionNames.SIGN_UP.equalsIgnoreCase(action)) {

			targetView=ViewPaths.SIGN_IN;
			//SINGUP
			String  nombreStr = request.getParameter(ParameterNames.NOMBRE);
			String emailStr = request.getParameter(ParameterNames.EMAIL);
			String contrasenaStr = request.getParameter(ParameterNames.CONTRASENA);
			String idTipoEmpresaStr=request.getParameter(ParameterNames.ID_TIPO_EMPRESA);
			String nombreUsuarioStr=request.getParameter(ParameterNames.NOMBRE_USUARIO);
			String cifStr=request.getParameter(ParameterNames.CIF);

			try {

				Empresa empresa=new Empresa();
				empresa.setNombre(nombreStr);
				empresa.setEmail(emailStr);
				empresa.setNombreUsuario(nombreUsuarioStr);
				empresa.setCif(cifStr);
				empresa.setContrasena(contrasenaStr);
				empresa.setIdTipoEmpresa(1L);



				empresaService.signUp(empresa);
				request.setAttribute("", empresa);

				targetView = ViewPaths.HOME;


			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (redirect) {
			response.sendRedirect(request.getContextPath()+targetView);
		} else {
			request.getRequestDispatcher(targetView).forward(request, response);
		}

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}