package service;

import java.util.ArrayList;

import com.dao.DetalleDAO;

import model.Detalle;
import model.Pedido;

public class DetalleService {
	
	
	public static void save(Detalle d) {
		DetalleDAO.save(d);;
	}
	
public static ArrayList<Detalle> obtenerPedido(int id) {
		return DetalleDAO.getDetallePedido(id);
	}

 public static ArrayList<Detalle> obtenerPedido(Pedido p) {
 return DetalleDAO.getDetallePedido(p.getId());	
 }
 
 public static int count() {
	 return DetalleDAO.getAll().size();
 }
}
