package com.jal.wholesales.web.controller.utils;

import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class Validator {

	private static final String PASSWORD_REGEX = 
			//"[a-zA-Z0-9.,]{6,10}";
			"[[a-z]+[A-Z]+[0-9]+[\\p{Punct}]+]{6,10}";
	
	private static final Pattern PASSWORD_PATTERN = 
			Pattern.compile(PASSWORD_REGEX);
	

	
	public static final boolean validatePassword(String password) {
		Matcher m = PASSWORD_PATTERN.matcher(password);
		return m.matches();
	}
	
	/**
	 * Convierte un string a un double.
	 * @param s
	 * @return El valor double o null si no cumple el formato de n�mero double.
	 */
	public static Double parseDouble(String s)  {		
		Double v = null;
		if (s!=null) s = s.trim();		
		try {
			v = Double.parseDouble(s);
		} catch (NumberFormatException nfe) {
			// nfe.printStackTrace();
		}
		return v;
	}
	
	
	public static Double validate(String s, double from, double to)  {
		Double v = parseDouble(s);
		if ((v==null) || (v<from) || (v>to)) {
			v = null;
		}
		return v;
	}
	
	public static Date parseDate(String s) {
		Date v = null;
		
		try {
			v = DateUtils.INPUT_DATE_FORMAT.parse(s);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		return v;
		
	}
//	validacion categorias
	
	 
	public static Integer validaInteger(String integerStr) {
		
		Integer i = null;
		
		if (!StringUtils.isBlank(integerStr)) {		
			
			integerStr = integerStr.trim();
			
			try {
				i = Integer.parseInt(integerStr);
				
			} catch (NumberFormatException nfe) {
				// No hace falta tracear
			}
		}
		return i;
	}
	public static Long validaLong(String longStr) {

		Long l = null;

		if (!StringUtils.isBlank(longStr)) {

			longStr = longStr.trim();

			try{
				l = Long.parseLong(longStr);

			} catch (NumberFormatException nfe) {
				// No hace falta tracear
			}
		}
		return l;
	}
	
	
	public static String validaString(String stringStr) {
		
		String s = null;
		
		if (!StringUtils.isBlank(stringStr)) {
			stringStr = stringStr.trim();
			//TODO por ahora solo le valido la capacidad del varchar de bbdd, validar %65,.?¿!  tambien?
			if(stringStr.length()<0 || stringStr.length()>80) {
				s=null;
			}else {
				s = stringStr;
			}
		}
		return s;
	}
	
	public static Double validaDouble(String doubleStr) {

		Double d = null;
		
		if (!StringUtils.isBlank(doubleStr)) {
		
			doubleStr = doubleStr.trim();
			
			try {
				d = Double.parseDouble(doubleStr);
	
			} catch (NumberFormatException nfe) {
				// No hace falta tracear
			}
		}
		return d;
	}


}
