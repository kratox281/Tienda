package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.Pedido;

public class PedidoDAO {
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
	
	public static ArrayList<Pedido> getAll() {
		ArrayList<Pedido> lista = new ArrayList();
		String query = "SELECT * FROM pedido";
		
		if (!conectado) {
			conectar();
		}

		try {
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				lista.add(new Pedido(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7)));
			}
		} catch (Exception e) {
		}
		return lista;
	}
	
	public static void save(Pedido p) {
		if (!conectado) {
			conectar();
		}
		try {
			System.out.println(p.toString());
			PreparedStatement pst = conection.prepareStatement("INSERT INTO `pedido` (`id`, `usuario_id`, `fecha`, `metodo_pago`, `num_factura`, `total`,`estado`) VALUES (?, ?, ?, ?, ?, ?, ?) ");
			pst.setInt(1, p.getId());
			pst.setInt(2, p.getUsuario_id());
			pst.setDate(3, p.getFecha());
			pst.setString(4, p.getMetodoPago());
			pst.setString(5,p.getNumFactura());
			pst.setDouble(6, p.getTotal());
			pst.setString(7, p.getEstado());
			pst.executeUpdate();
			conection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Pedido findById(int id) {
		if (!conectado) {
			conectar();
		}
		try {
			PreparedStatement pst = conection.prepareStatement("SELECT * FROM `pedido` WHERE `id` = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				return new Pedido(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Pedido> findByUser(int id){
		if (!conectado) {
			conectar();
		}
		PreparedStatement pst;
		ArrayList<Pedido> lista = new ArrayList();
		try {
			pst = conection.prepareStatement("SELECT * FROM `pedido` WHERE `usuario_id` = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				lista.add(new Pedido(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;

	}

}
