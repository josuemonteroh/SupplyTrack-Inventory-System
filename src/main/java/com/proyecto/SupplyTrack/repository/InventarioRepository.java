package com.proyecto.SupplyTrack.repository;

import com.proyecto.SupplyTrack.domain.Inventario;
import com.proyecto.SupplyTrack.domain.Producto;
import com.proyecto.SupplyTrack.domain.Tienda;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {

    List<Inventario> findByTienda(Tienda tienda);

    List<Inventario> findByProducto(Producto producto);

    Optional<Inventario> findByProductoAndTienda(Producto producto, Tienda tienda);

    @Query("""
        SELECT i
        FROM Inventario i
        JOIN FETCH i.producto p
        JOIN FETCH i.tienda t
        WHERE (:idTienda IS NULL OR t.idTienda = :idTienda)
        ORDER BY t.nombre ASC, p.nombre ASC
    """)
    List<Inventario> filtrarPorTienda(@Param("idTienda") Integer idTienda);
}