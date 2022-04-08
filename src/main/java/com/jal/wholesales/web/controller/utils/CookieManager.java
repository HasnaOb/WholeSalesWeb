package com.jal.wholesales.web.controller.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {
	
	
	public static final String getValue(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies!=null) {
			for (Cookie c: cookies) {
				if (c.getName().equalsIgnoreCase(name)) {
					return c.getValue();
				}
			}
		}
		return null;
	}
	
	public static final void setValue(HttpServletResponse response, String name, String value, int ttl) {
		Cookie cookie = new Cookie(name, value); 
		cookie.setMaxAge(ttl);
		response.addCookie(cookie);
	}
//
//	/**
//	 * Busca una cookie por su nombre (case insensitive). 
//	 * @return null si no la encuentra.
//	 */
//	public static final Cookie getCookie(HttpServletRequest request, String name) {
//		Cookie[] cookies = request.getCookies();		
//		if (cookies!=null) {
//			for (Cookie c: cookies) {
//				if (c.getName().equalsIgnoreCase(name)) {
//			 		return c;
//				}
//			}
//		}
//		return null;    
//	}
//
//	/**
//	 * Añade una cookie a la response.
//	 */
//    public static final void addCookie(HttpServletResponse response, String name, String value, String path, int timeToLive) {		
//		Cookie c = new Cookie(name, value);		
//		c.setMaxAge(timeToLive);
//		c.setPath(path);
//		response.addCookie(c);	
//    }
//
//    /**
//     *   "eliminar" una cookie.
//     */
//    public static final void removeCookie(HttpServletResponse response, String name, String path) {
//    	addCookie(response, name, null, path, 0);
//    }
//
//	public static void setValue(HttpServletResponse response, String string, String emailStr, int i) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public static String getValue(HttpServletRequest httpRequest, String empresa) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
