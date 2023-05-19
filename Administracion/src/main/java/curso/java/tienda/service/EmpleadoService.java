package curso.java.tienda.service;

import java.util.List;

import curso.java.tienda.model.Empleado;


public interface EmpleadoService {

	public Empleado iniciarSesion(String email,String contra);
	public List<Empleado> getAll();
	public String encriptar(String contra);
	public Empleado getById(int parseInt);
	public void guardar(Empleado user);
	public void delete(int parseInt);
}
