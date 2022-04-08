package com.jal.wholesales.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jal.wholesales.model.Empresa;
import com.jal.wholesales.web.SessionManager;
import com.jal.wholesales.web.controller.AttributeNames;
import com.jal.wholesales.web.controller.ViewPaths;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Filtro de autenticación.
 */
// @WebFilter("/*") //<-- No os lo recomiendo porque no sabríamos el orden respecdto a otros filtros
public class AuthenticationFilter extends HttpFilter implements Filter {

	private static Logger logger = LogManager.getLogger(AuthenticationFilter.class); 

    public AuthenticationFilter() {
        super();
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		//uri :  universal resource identify , es lo mismo q la url pero con parametros 
		
		String url = httpRequest.getRequestURL().toString();
		if (!url.contains("/public/")) {
  
			Empresa empresa = (Empresa) SessionManager.get(httpRequest, AttributeNames.EMPRESA);
			if (empresa==null) {
				 if (logger.isInfoEnabled()) {
				 	logger.info(httpRequest.getRemoteAddr()+": Unathenticated");
				 }
				
				httpRequest.getRequestDispatcher(ViewPaths.SIGN_IN).forward(httpRequest, httpResponse);
			} else {
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
	}



	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	
	public void destroy() {
	}


}
