package curso.java.tienda.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.java.tienda.model.Usuario;
import curso.java.tienda.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repo;



	@Override
	public List<Usuario> getAll() {
		
		return repo.findAll();
	}



	@Override
	public String encriptar(String contra) {
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
	public Usuario iniciarSesion(String email, String contra) {
		for(Usuario u:getAll()) {
			String clave = encriptar(contra);
			if(u.getEmail().equals(email)&& u.getClave().equals(clave)) {
				return u;
			}
		}
		return null;
	}



	@Override
	public Usuario getById(int id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}



	@Override
	public void guardar(Usuario u) {
		// TODO Auto-generated method stub
		repo.save(u);
	}



	@Override
	public void delete(int parseInt) {
		// TODO Auto-generated method stub
		repo.deleteById(parseInt);
	}
}
