package curso.java.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Rol;
import curso.java.tienda.repository.RolRepository;

@Service
public class RolServiceIml implements RolService{

	@Autowired
	RolRepository repo;

	@Override
	public List<Rol> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
}
