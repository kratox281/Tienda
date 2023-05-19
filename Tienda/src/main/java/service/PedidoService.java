package service;

import java.util.ArrayList;

import com.dao.PedidoDAO;

import model.Pedido;
import model.Usuario;

public class PedidoService {

	
	public static ArrayList<Pedido> getAll(){
		return PedidoDAO.getAll();
	}
	
	
	public static void save(Pedido p) {
		PedidoDAO.save(p);
	}
	
	public static Pedido findById(int id) {
		return PedidoDAO.findById(id);
	}
	
	public static ArrayList<Pedido> getByUser(Usuario u){
		for(Pedido p:PedidoDAO.findByUser(u.getId())) {
			System.out.println(p.toString());
		}
		return PedidoDAO.findByUser(u.getId());
	}
	

	public static ArrayList<Pedido> getByUser(int id){
		return PedidoDAO.findByUser(id);
	}
	
	public static int countAll() {
		int cont = 0;
		for(Pedido p:getAll()) {
			cont++;
		}
		return cont;
	}
	
	
	
	public static void cancelar(int id) {
		PedidoDAO.cancelar(id);
	}
	
}
