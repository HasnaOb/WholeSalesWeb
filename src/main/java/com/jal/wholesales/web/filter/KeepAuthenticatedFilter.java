package com.jal.wholesales.web.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.company.wholesales.service.EmpresaService;
import com.company.wholesales.service.impl.EmpresaServiceImpl;
import com.jal.wholesales.model.Empresa;
import com.jal.wholesales.web.SessionManager;
import com.jal.wholesales.web.controller.AttributeNames;
import com.jal.wholesales.web.controller.ViewPaths;
import com.jal.wholesales.web.controller.utils.CookieManager;
import com.wholesales.exception.InvalidUserOrPasswordException;
import com.wholesales.exception.ServiceException;

/**
 * Servlet Filter implementation class ReuqestLogFilter
 */
//@WebFilter("/*")
public class KeepAuthenticatedFilter extends HttpFilter implements Filter {
	
	private static Logger logger = LogManager.getLogger(KeepAuthenticatedFilter.class); 
	private EmpresaService empresaService = null;

    public KeepAuthenticatedFilter() {
        super();
        empresaService = new EmpresaServiceImpl();
    }



	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;	
		
		Empresa empresa = (Empresa) SessionManager.get(httpRequest, AttributeNames.EMPRESA);
		
		String email=CookieManager.getValue(httpRequest,AttributeNames.EMPRESA);
		if(email!=null) {
			try {
				empresa= empresaService.findByEmail(email);
				SessionManager.set(httpRequest, AttributeNames.EMPRESA, empresa);
				 
				if (logger.isInfoEnabled()) {
					logger.info("User "+email+" authenticated form cookie");
				}
			} catch (ServiceException se) {
				logger.error("Trying to login by cookie: "+email, se);
			}
				
		}
		
	
//		HttpServletResponse httpResponse = (HttpServletResponse) response;

//		logger.debug("Request from "+httpRequest.getRemoteAddr()+"("+httpRequest.getRemoteHost()+"): "+httpRequest.getRequestURL());
//		
//		Map<String, String[]> params = httpRequest.getParameterMap();
//		for (String pname: params.keySet()) {
//			logger.debug("parameter: "+pname+": "+Arrays.toString(params.get(pname)));
//		}
//		
		
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}

}