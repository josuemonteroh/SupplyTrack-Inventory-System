package com.proyecto.SupplyTrack.repository;

import com.proyecto.SupplyTrack.domain.Inventario;
import com.proyecto.SupplyTrack.domain.Producto;
import com.proyecto.SupplyTrack.domain.Tienda;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {

    List<Inventario> findByTienda(Tienda tienda);

    List<Inventario> findByProducto(Producto producto);

    Optional<Inventario> findByProductoAndTienda(Producto producto, Tienda tienda);
}
