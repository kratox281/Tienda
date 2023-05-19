package curso.java.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Pedido;
import curso.java.tienda.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	PedidoRepository repo;

	@Override
	public Pedido getbyId(Integer id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	@Override
	public List<Pedido> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void editar(Pedido p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void save(Pedido p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void procesar(int id) {
		// TODO Auto-generated method stub
		Pedido p = getbyId(id);
		p.setEstado("E");
		repo.save(p);
		
	}
}
