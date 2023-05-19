package curso.java.tienda.service;

import java.util.List;
import java.util.Optional;

import curso.java.tienda.model.Pedido;
import curso.java.tienda.model.Producto;

public interface ProductoService {
	public Producto getbyId(Integer id);
	public List<Producto> getAll();
	public void editar(Producto p);
	public void save(Producto p);
	public void delete(int parseInt);
}
