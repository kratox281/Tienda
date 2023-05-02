package model;

import java.io.Serializable;

import lombok.Data;
@Data
public class Producto implements Comparable<Producto>{
	private int id;//1
	private String nombre;//2
	private String descripcion;//3
	private double precio;//4
	private int stock;//6
	private String url;//8
	private int categoria;//9
	public Producto(int id,String nombre, String descripcion, double precio,int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}
	public Producto(int id,String nombre, String descripcion, double precio,int stock,String url,int categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.url = url;
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
