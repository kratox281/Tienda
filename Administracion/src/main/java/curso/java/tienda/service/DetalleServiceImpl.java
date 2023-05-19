package curso.java.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Detalle;
import curso.java.tienda.repository.DetalleRepository;

@Service
public class DetalleServiceImpl implements DetalleService{
	
	@Autowired
	DetalleRepository repo;

	@Override
	public Optional<Detalle> getbyId(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Detalle> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(Detalle p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Detalle p) {
		// TODO Auto-generated method stub
		
	}
}
