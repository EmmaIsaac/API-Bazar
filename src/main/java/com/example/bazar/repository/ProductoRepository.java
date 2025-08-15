
package com.example.bazar.repository;

import com.example.bazar.model.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    @Query("SELECT p FROM Producto p WHERE p.cantidad_disponible < :cantidad")
    List<Producto> findProductosConStockMenorA(@Param("cantidad") Double cantidad_disponible);
    
}
