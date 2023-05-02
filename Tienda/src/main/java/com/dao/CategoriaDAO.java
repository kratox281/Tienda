package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Categoria;
import model.Usuario;

public class CategoriaDAO {
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

	public static ArrayList<Categoria> getAll() {
		ArrayList<Categoria> lista = new ArrayList();
		String query = "SELECT * FROM categoria";
		
		if (!conectado) {
			conectar();
		}

		try {
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				lista.add(new Categoria(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
		}
		return lista;
	}
}
