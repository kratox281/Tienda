package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Usuario {
	private int id;
	private int rol_id;
	private String email;
	private String clave;
	private String nombre;
	private String apellidos;
	
	
	
	public Usuario(String email, String clave, String nombre, String apellidos) {
		super();
		this.email = email;
		this.clave = clave;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	
	
}
