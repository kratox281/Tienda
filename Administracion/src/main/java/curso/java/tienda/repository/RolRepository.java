package curso.java.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import curso.java.tienda.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

}
