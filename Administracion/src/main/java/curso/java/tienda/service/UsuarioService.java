package curso.java.tienda.service;

import java.util.ArrayList;
import java.util.List;

import curso.java.tienda.model.Usuario;

public interface UsuarioService {
	
	public Usuario iniciarSesion(String email,String contra);
	public List<Usuario> getAll();
	public String encriptar(String contra);
	public Usuario getById(int id);
	public void guardar(Usuario u);
	public void delete(int parseInt);
}
