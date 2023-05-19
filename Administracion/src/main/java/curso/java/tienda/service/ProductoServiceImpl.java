package curso.java.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Producto;
import curso.java.tienda.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	ProductoRepository repo;
	
	@Override
	public Producto getbyId(Integer id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	@Override
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void editar(Producto p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void save(Producto p) {
		// TODO Auto-generated method stub
		System.out.println("SERVICIO:"+p.toString());
		repo.save(p);
	}

	@Override
	public void delete(int parseInt) {
		// TODO Auto-generated method stub
		repo.deleteById(parseInt);
	}

}
