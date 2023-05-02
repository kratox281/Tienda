package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
	static String bd = "tienda_ruben_casas_martinez";
	static String login = "root";
	static String password = "";
	static String host = "127.0.0.1"; //localhost
	
	static String url = "jdbc:mysql://";
	static Connection conexion; //atributo para  guardar el objeto Connection
        
    
	public static Connection getConexion() {
	   //SINGLETON
    	if (conexion == null) {
    		System.out.println("Lo detecta como nulo");
	    	crearConexion();
	    	System.out.println(crearConexion());
	    	System.out.println("En conexion funciona");
	    }else {
	    	System.out.println("no es nulo");
	    }
    	System.out.println("En conexion devuelve");
	    return conexion;
	    
    }
    
    // devuelve true si se ha creado correctamente
    public static boolean crearConexion() {
	    try {
	        //cargo el driver
	    	System.out.println("class for name");
	        Class.forName("com.mysql.cj.jdbc.Driver");
	       // conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso","root","");
	        System.out.println("getconnection");
	        conexion = DriverManager.getConnection(url + host + "/"+ bd, login, password);  
            System.out.println(conexion+"1");
            System.out.println("autoCommit");
            conexion.setAutoCommit(false);
	        
	    } catch (SQLException e) {
	    	return false;
	    }
	    catch (Exception e) {
	    	return false;
	    }
	    return true;
    }

    public static void desconectar(){
    	try {
            conexion.close();
            conexion = null;
            System.out.println("La conexion a la  base de datos " + bd + " ha terminado");
    	
    	} catch (SQLException e) {
    		System.out.println("Error al cerrar la conexion");
        }
    }
   
}
