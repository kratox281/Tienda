package curso.java.tienda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int rol_id;
	private String email;
	private String clave;
	private String nombre;
	private String apellidos;
	
	public Empleado(int rol_id, String email, String clave, String nombre, String apellidos) {
		super();
		this.rol_id = rol_id;
		this.email = email;
		this.clave = clave;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
 
	
}
