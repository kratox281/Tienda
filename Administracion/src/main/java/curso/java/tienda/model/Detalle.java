package curso.java.tienda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int pedido_id;
	private int producto_id;
	private String nombreProducto;
	private int unidades;
	private double preciounidad;
	private double impuesto;
	private double total;

}
