package curso.java.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import curso.java.tienda.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
