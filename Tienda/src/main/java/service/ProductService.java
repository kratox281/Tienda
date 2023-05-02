package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.Conexion;
import com.dao.ProductoDAO;

import model.Producto;

public class ProductService {
	
	public static void insertar(Producto prod) throws SQLException {
		ProductoDAO.insertar(prod);
	}
	
	public static ArrayList<Producto> getAll(){
		
		return ProductoDAO.getAll();
	}
	
	public static Producto findByName(String nombre) {
		System.out.println("nombre:"+nombre);
		for(Producto p:getAll()) {
			if(p.getNombre().equals(nombre)) {
				p.toString();
				return p;
			}
		}
		return null;
	}
	
	public static void actualizarStock(String nombre,int cantidad) {
		Producto p = findByName(nombre);
		p.setStock(p.getStock()-cantidad);
		ProductoDAO.update(p);
		
	}
}
