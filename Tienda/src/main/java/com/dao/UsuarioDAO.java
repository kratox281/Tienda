package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Usuario;

public class UsuarioDAO {
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

	public static int contarUsers() {
		int cont = 0;
		if (!conectado) {
			conectar();
		}
		String query = "SELECT * FROM usuario";
		try {
			ResultSet rs = st.executeQuery(query);
			System.out.println("result set lleno");
			while (rs.next()) {
				cont++;
			}
			System.out.println("Usuario no existente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cont + 1;
	}

	public static ArrayList<Usuario> findAll() {
		
		ArrayList<Usuario> lista = new ArrayList();
		String query = "SELECT * FROM usuario";
		
		if (!conectado) {
			conectar();
		}

		try {
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				lista.add(new Usuario(rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (Exception e) {
		}
		return lista;
	}
	
	
	public static boolean insertar(Usuario u)
			throws SQLException {
		if (!conectado) {
			conectar();
		}
//		if (user.equals("") || psswrd.equals("") || email.equals("") || nombre.equals("") || apellidos.equals("")) {
//			throw new SQLException();
//		}
		PreparedStatement pst = conection.prepareStatement(
				"INSERT INTO `usuario` (`id`, `rol_id`, `email`, `clave`, `nombre`, `apellidos`,`baja`) VALUES ("
						+ contarUsers() + ",?,?,?,?,?,false);");
		pst.setInt(1, 0);
		pst.setString(2, u.getEmail());
		pst.setString(3, u.getClave());
		// pst.setString(4, user);
		pst.setString(4, u.getNombre());
		pst.setString(5, u.getApellidos());
		pst.executeUpdate();
		return true;

	}
}
