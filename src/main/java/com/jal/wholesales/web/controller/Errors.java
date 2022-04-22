package com.jal.wholesales.web.controller;

public interface Errors {
 
		 
	public static final String ERROR_EMAIL_REQUIERED= "El campo de Email es obligatorio ";
	public static final String ERROR_EMAIL_INCORRECTO = "El formato del Email es incorrecto";
	public static final String ERROR_EMAILS_DIFERENTES = "Los emails no son iguales";
	
	public static final String ERROR_PASSWORD_OBLIGATORIA = "Debes rellenar el campo de la contraseña";
	public static final String ERROR_PASSWORD_FORMATO_INCORRECTO = "El formato de la constraseña es incorrecto";
	public static final String ERROR_PASSWORDS_DIFERENTES = "Las contraseñas no son iguales";
	
	public static final String ERROR_NOMBRE_PERFIL_OBLIGATORIO= "Debes rellenar el campo del Nombre del perfil";
	public static final String ERROR_NOMBRE_PERFIL_FORMATO_INCORRECTO= "El formato del Nombre de perfil es incorrecto";
	
	public static final String ERROR_DNI_OBLIGATORIO = "Debes rellenar el campo del D.N.I.";
	public static final String ERROR_DNI_FORMATO_INCORRECTO = "El formato del DNI es incorrecto";
	
	public static final String ERROR_NOMBRE_OBLIGATORIO = "Debes rellenar el campo del nombre";	
	public static final String ERROR_NOMBRE_FORMATO_INCORRECTO= "El formato del Nombre es incorrecto";
	
	  
 
 
	public static final String ERROR_ID_USUARIO_OBLIGATORIO= "Se necesita un Id de Usuario";
	
	public static final String ERROR_ID_TIPO_USUARIO_OBLIGATORIO= "Se necesita un Id de tipo de Usuario";	
	public static final String ERROR_ID_TIPO_USUARIO_FORMATO_INCORRECTO= "El formato del idTipoDeUsuario es incorrecto";	
	
	 
	public static final String ERROR_EMAIL="Ha ocurrido un problema a la hora de enviar el email. Por favor inténtelo de nuevo más tarde";
	
	public static final String ERROR_USER_ALREADY_EXISTS="El usuario ya existe";
	
	public static final String ERROR_USUARIO_PASSWORD_INVALID="El usuario y/o la contraseña no son correctos...";
	
	public static final String ERROR_DATA="Ha un ocurrido un problema al consultar sus datos, inténtelo de nuevo más tarde.";
	
	public static final String ERROR_E="Se ha producido un error. Por favor inténtelo de nuevo más tarde.";
	
	public static final String ERROR_SERVICE="Se ha producido un error en el servicio. Por favor inténtelo de nuevo más tarde.";
	
	public static final String ERROR_KEEP_AUTHENTICATED_FORMATO_INCORRECTO="El formato del keep authenticated es incorrecto";
	public static final String ERROR_ID_PRODUCTO_OBLIGATORIO = "El ID del producto es obligatorio";
	public static final String ERROR_DESCRIPCION_FORMATO_INCORRECTO = "Error en la discripción del producto";
	public static final String ERROR_PRECIO = "El precio es un dato obligatorio";
	public static final String ERROR_CATEGORIA = "La categoria es un dato obligatorio";
	public static final String ERROR_SECCION = "La seccion es un dato obligatorio";
	public static final String ERROR_MARCA = "La marca es un dato obliagtorio";
	public static final String ERROR_PAIS = "El pais es un dato obliagtorio";
	
}