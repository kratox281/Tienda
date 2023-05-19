package curso.java.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import curso.java.tienda.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

}
