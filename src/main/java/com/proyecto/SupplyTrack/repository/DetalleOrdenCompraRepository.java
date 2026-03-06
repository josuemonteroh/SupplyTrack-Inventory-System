package com.proyecto.SupplyTrack.repository;

import com.proyecto.SupplyTrack.domain.DetalleOrdenCompra;
import com.proyecto.SupplyTrack.domain.OrdenCompra;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleOrdenCompraRepository extends JpaRepository<DetalleOrdenCompra, Integer> {

    List<DetalleOrdenCompra> findByOrdenCompra(OrdenCompra ordenCompra);
}
