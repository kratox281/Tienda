package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Producto;

public class ProductoDAO {
	private static Connection conection;
	private static Statement st;
	private static boolean conectado = false;
	private static void conectar() {
		try {
			conection = Conexion.getConexion();
			System.out.println(conection);
			if(conection !=null) {
	          st = conection.createStatement();
	          System.out.println("statement creada");
			}
			conectado = true;
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void insertar(Producto prod) throws SQLException {
		if(!conectado) {
			conectar();
		}
		
			PreparedStatement pst = conection.prepareStatement("INSERT INTO `clients` ( `Usuario`, `Contraseña`) VALUES (  ? ,  ?  );");
	}
	
	public static void update(Producto prod) {
		if(!conectado) {
			conectar();
		}
		try {
			PreparedStatement pst = conection.prepareStatement("UPDATE `producto` SET  `stock` = ? WHERE `producto`.`id` = ?;");
			pst.setInt(1, prod.getStock());
			pst.setInt(2, prod.getId());
			System.out.println(pst);
			pst.execute();
			conection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static ArrayList<Producto> getAll(){
		if(!conectado) {
			conectar();
		}
		 String query = "SELECT * FROM producto";
		 ArrayList<Producto> productos = new ArrayList<>();
		try {	
		 ResultSet rs = st.executeQuery(query);
		 while(rs.next()) {
			 System.out.println("Stock:"+rs.getInt(5));
			 productos.add(new Producto(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getDouble(4),rs.getInt(6)));
		 }
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		 return productos;
	}

}
