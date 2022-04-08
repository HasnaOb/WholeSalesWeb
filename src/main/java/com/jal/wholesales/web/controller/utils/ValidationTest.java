package com.jal.wholesales.web.controller.utils;

import java.text.DateFormat;
 
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class ValidationTest {

	public static void main(String args[]) {
		String userName = "";
		if (StringUtils.isBlank(userName)) {
			// tratarlo como error en el parametro
		}
		
		
		// Validacion del parametro precio desde
		String precioDesdeStr = "10a";
		Double precioDesde = null;
		
		if (StringUtils.isBlank(precioDesdeStr)) {
			precioDesde = 0.0d;
			// tratarlo como error en el parametro
		} else {
			precioDesde = Validator.validate(precioDesdeStr, 0.0d, 1000.0d);
			if (precioDesde==null) {
				// tratarlo como error
			}
		}
		
		// Validacion del parametro precio hasta		
		// System.out.println("Precio desde: "+precioDesde);
		
		String fechaNacimientoStr = "2022-12-22";
		Date fechaNacimiento = Validator.parseDate(fechaNacimientoStr);
		
		// System.out.println(fechaNacimiento);
		Locale locale = new Locale("en", "US");
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, locale);
		
		// System.out.println(df.format(fechaNacimiento));
		
		String passowordStr = "A1aA1aA1a"; 
		if (!Validator.validatePassword(passowordStr)) {
			System.out.println("NO VALE: La password ha de tener ....");
		} else {
			System.out.println("Seguiria en el controller ");
		}
	}
		
}
