package model;

import java.io.Serializable;

import lombok.Data;
@Data
public class Producto implements Comparable<Producto>{
	private int id;
	private String nombre;
	private String Descripcion;
	private double precio;
	private int stock;
	public Producto(int id,String nombre, String descripcion, double precio,int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		Descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}
	@Override
	public int compareTo(Producto o) {
		// TODO Auto-generated method stub
		if(o.getId()==this.id) {
			return 0;
		}else {
			return 1;
		}
		
	}

	
}
