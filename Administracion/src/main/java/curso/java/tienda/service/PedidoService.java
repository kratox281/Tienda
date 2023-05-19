package curso.java.tienda.service;

import java.util.List;
import java.util.Optional;

import curso.java.tienda.model.Pedido;

public interface PedidoService {
	public Pedido getbyId(Integer id);
	public List<Pedido> getAll();
	public void editar(Pedido p);
	public void save(Pedido p);
	public void procesar(int id);
}
