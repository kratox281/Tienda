package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Detalle {
private int id;
private int pedido_id;
private int producto_id;
private int unidades;
private double preciounidad;
private double impuesto;
private double total;


}
