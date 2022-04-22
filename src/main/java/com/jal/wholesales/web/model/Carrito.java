package com.jal.wholesales.web.model;

 
import java.util.HashMap;
 
import java.util.Map;
 
 
 

public class Carrito {
  private Map<Long, LineaCarrito> lineasCarritoMap;
	
	public Carrito() {
		lineasCarritoMap = new HashMap<Long, LineaCarrito>();
	}
	
	public Map<Long, LineaCarrito> getLineasCarritoMap() {
		return lineasCarritoMap;
	}
	
	public void setLineasCarritoMap(Map<Long, LineaCarrito> lineasCarritoMap) {
		this.lineasCarritoMap = lineasCarritoMap;
	}

	public void addMap(Long idProducto, LineaCarrito lineaCarrito) {
		lineasCarritoMap.put(idProducto, lineaCarrito);
	}
	 
}
