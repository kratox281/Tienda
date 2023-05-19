package curso.java.tienda.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Empleado;
import curso.java.tienda.model.Usuario;
import curso.java.tienda.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	@Autowired
	EmpleadoRepository repo;

	@Override
	public Empleado iniciarSesion(String email, String contra) {
		// TODO Auto-generated method stub
		for(Empleado e:getAll()) {
			String clave = encriptar(contra);
			if(e.getEmail().equals(email)&& e.getClave().equals(clave)) {
				return e;
			}
		}
		return null;
	}

	@Override
	public List<Empleado> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public String encriptar(String contra) {
		// TODO Auto-generated method stub
		String encryptedpassword = null;
		try {
			/* MessageDigest instance for MD5. */
			MessageDigest m = MessageDigest.getInstance("MD5");

			/* Add plain-text password bytes to digest using MD5 update() method. */
			m.update(contra.getBytes());

			/* Convert the hash value into bytes */
			byte[] bytes = m.digest();

			/*
			 * The bytes array has bytes in decimal form. Converting it into hexadecimal
			 * format.
			 */
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			/* Complete hashed password in hexadecimal format */
			encryptedpassword = s.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encryptedpassword;
	}

	@Override
	public Empleado getById(int n) {
		// TODO Auto-generated method stub
		return repo.getById(n);
	}

	@Override
	public void guardar(Empleado user) {
		// TODO Auto-generated method stub
		repo.save(user);
		
	}

	@Override
	public void delete(int parseInt) {
		// TODO Auto-generated method stub
		repo.deleteById(parseInt);
	}
}
