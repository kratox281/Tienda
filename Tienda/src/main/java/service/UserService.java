package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

import com.dao.Conexion;
import com.dao.UsuarioDAO;

import model.Usuario;

public class UserService {
	private static Connection conection;
	private static Statement st;
	private static boolean conectado = false;
	private static String usuario;
	private static String contraseña;

	public static Usuario comprobarUser(String user, String contra) {

		for(Usuario u:listaCompleta()) {
			if(u.getEmail().equals(user)&&u.getClave().equals(contra)) {
				System.out.println(u.toString());
				return u;
			}
		}
		return null;
	}



	public static String encriptar(String password) {

		String encryptedpassword = null;
		try {
			/* MessageDigest instance for MD5. */
			MessageDigest m = MessageDigest.getInstance("MD5");

			/* Add plain-text password bytes to digest using MD5 update() method. */
			m.update(password.getBytes());

			/* Convert the hash value into bytes */
			byte[] bytes = m.digest();

			/*
			 * The bytes array has bytes in decimal form. Converting it into hexadecimal
			 * format.
			 */
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			/* Complete hashed password in hexadecimal format */
			encryptedpassword = s.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encryptedpassword;
	}


	public static Boolean existe(String mail) {
		for(Usuario u:listaCompleta()) {
			if(u.getEmail().equalsIgnoreCase(mail))return true;
		}
		return false;
	}
	public static String insertar(Usuario u) {
		if (!existe(u.getEmail())) {
			try {
				UsuarioDAO.insertar(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Insertado con exito";
		} else {
			return "El mail ya está en uso";
		}
	}
	
	
	public static boolean comprobarContrasenias(String psw,String psw2) {
		return(psw.equals(psw2));
	}
	public static ArrayList<Usuario> listaCompleta(){
		return UsuarioDAO.findAll();
	}
	
	
	public static void modificar(Usuario u) throws Exception  {
		u.setClave(encriptar(u.getClave()));
		//System.out.println("Ha encriptado la clave");
		UsuarioDAO.modificar(u);
	}
}
