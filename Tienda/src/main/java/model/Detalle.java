package model;

import lombok.Data;

@Data
public class Detalle {
private int id;
private int pedido_id;
private int unidades;
private double preciounidad;
private double impuesto;
private double total;


}
