package curso.java.tienda.service;

import java.util.List;
import java.util.Optional;

import curso.java.tienda.model.Categoria;

public interface CategoriaService {

	
	public List<Categoria> getAll();
	public void editar(Categoria p);
	public void save(Categoria p);
	public Categoria getbyId(Integer id);
	public void delete(int parseInt);
}
