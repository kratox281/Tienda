package curso.java.tienda.service;

import java.util.List;
import java.util.Optional;

import curso.java.tienda.model.Detalle;

public interface DetalleService {
	public Optional<Detalle> getbyId(Integer id);
	public List<Detalle> getAll();
	public void editar(Detalle p);
	public void save(Detalle p);
}
