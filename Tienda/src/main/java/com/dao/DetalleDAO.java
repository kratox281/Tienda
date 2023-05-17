package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Detalle;

public class DetalleDAO {
	private static Connection conection;
	private static Statement st;
	private static boolean conectado = false;
	
	private static void conectar() {
		try {
			conection = Conexion.getConexion();
			System.out.println(conection);
			if (conection != null) {
				st = conection.createStatement();
				System.out.println("statement creada");
			}
			conectado = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void save(Detalle d) {
		if (!conectado) {
			conectar();
		}
		try {
			PreparedStatement pst = conection.prepareStatement("INSERT INTO `detalle` (`id`, `pedido_id`, `producto_id`,`nombre_Producto`, `unidades`, `preciounidad`, `impuesto`, `total`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
			pst.setInt(1, d.getId());
			pst.setInt(2, d.getPedido_id());
			pst.setInt(3, d.getProducto_id());
			pst.setString(4,d.getNombreProducto());
			pst.setInt(5, d.getUnidades());
			pst.setDouble(6, d.getPreciounidad());
			pst.setDouble(7, d.getImpuesto());
			pst.setDouble(8, d.getTotal());
			
			pst.executeUpdate();
			conection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Detalle> getDetallePedido(int id) {
		if (!conectado) {
			conectar();
		}
		ArrayList<Detalle>details = new ArrayList<>();
		try {
			PreparedStatement pst = conection.prepareStatement("SELECT * FROM `detalle` WHERE `pedido_id` = ? ");
			pst.setInt(1, id);
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				details.add(new Detalle(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return details;
	}
	
	public static ArrayList<Detalle>getAll(){
		if (!conectado) {
			conectar();
		}
		ArrayList<Detalle>details = new ArrayList<>();
		try {
			PreparedStatement pst = conection.prepareStatement("SELECT * FROM `detalle`");
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				details.add(new Detalle(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return details;
	}
}
