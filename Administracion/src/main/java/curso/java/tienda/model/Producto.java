package curso.java.tienda.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// 1
	private String nombre;// 2
	private String descripcion;// 3
	private double precio;// 4
	private int stock;// 6
	private String url;// 8
	private int categoria;// 9

	public Producto(int id, String nombre, String descripcion, double precio, int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}

	

}
