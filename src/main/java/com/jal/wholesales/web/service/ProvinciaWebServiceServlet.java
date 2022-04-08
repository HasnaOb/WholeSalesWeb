package com.jal.wholesales.web.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.company.wholesales.service.ProvinciaService;
import com.company.wholesales.service.impl.ProvinciaServiceImpl;
import com.google.gson.Gson;
import com.jal.wholesales.model.Provincia;

@WebServlet("/ProvinciaWebService")
public class ProvinciaWebServiceServlet extends HttpServlet {
	
	private static Logger logger = LogManager.getLogger(ProvinciaWebServiceServlet.class);
	
    private ProvinciaService provinciaService = null;
    private Gson gson = null; 
	
    public ProvinciaWebServiceServlet() {
        super();
        provinciaService = new ProvinciaServiceImpl();
        gson = new Gson();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodStr = request.getParameter("method");
		
		// TODO rest style
		if ("search".equals(methodStr)) {
				// id de provincia 	
				String paisIdStr = request.getParameter("paisId");
				
				
				// validcion: no se validan aquí , se validan en provinciaService
				Long paisId = Long.valueOf(paisIdStr);
				
				
				try {
					List<Provincia> provincia = provinciaService.findByPais(paisId);
					
					String json = gson.toJson(provincia);

					response.setContentType("application/json");
					//para los caracteres como la ñ 
					response.setCharacterEncoding("ISO-8859-1");
					
					ServletOutputStream sos = response.getOutputStream();
					// TODO mimetype para saber el tipo de fichero
					sos.write(json.getBytes());
					
					// TODO se indica el final del Json y que se envien los datos 
					sos.flush();
				} catch (Exception e) {
					// se retorna un error de Json
					
					logger.error("paisId: "+paisIdStr, e);
				}								
				
				
		} // else 
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
