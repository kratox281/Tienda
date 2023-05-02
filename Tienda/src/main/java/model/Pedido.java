package model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Pedido {
private int id;
private int usuario_id;
private LocalDate fecha;
private String metodoPago;
private int numFactura;
private double total;
}
