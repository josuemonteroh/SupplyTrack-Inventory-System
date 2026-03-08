package com.proyecto.SupplyTrack.repository;

import com.proyecto.SupplyTrack.domain.OrdenCompra;
import com.proyecto.SupplyTrack.domain.Proveedor;
import com.proyecto.SupplyTrack.domain.Tienda;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer> {

    List<OrdenCompra> findByEstado(String estado);

    List<OrdenCompra> findByTienda(Tienda tienda);

    List<OrdenCompra> findByProveedor(Proveedor proveedor);
}
