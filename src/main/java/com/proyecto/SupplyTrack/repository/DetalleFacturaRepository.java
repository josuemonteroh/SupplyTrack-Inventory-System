package com.proyecto.SupplyTrack.repository;

import com.proyecto.SupplyTrack.domain.DetalleFactura;
import com.proyecto.SupplyTrack.domain.Factura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {

    List<DetalleFactura> findByFactura(Factura factura);
}
