package com.jal.wholesales.web.model;

import com.jal.wholesales.model.Producto;

public class LineaCarrito {
	private Producto producto = null;
	private int unidades = 0;
	 
	public LineaCarrito(Producto producto, int unidades ) {
		setProducto(producto);
		setUnidades(unidades);
	}

	public Producto getProducto() {
		return producto;
	}
 
	public void setProducto(Producto product) {
		this.producto = product;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int units) {
		this.unidades = units;
	}
}
