package curso.java.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Categoria;
import curso.java.tienda.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	CategoriaRepository repo;

	@Override
	public Categoria getbyId(Integer id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}
	
	@Override
	public List<Categoria> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void editar(Categoria p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void save(Categoria p) {
		// TODO Auto-generated method stub
		repo.save(p);
	}

	@Override
	public void delete(int n) {
		// TODO Auto-generated method stub
		repo.deleteById(n);
	}

	
}
