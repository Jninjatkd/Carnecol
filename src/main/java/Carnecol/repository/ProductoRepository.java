package Carnecol.repository;

import Carnecol.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio para gestionar los productos de Carnecol
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
