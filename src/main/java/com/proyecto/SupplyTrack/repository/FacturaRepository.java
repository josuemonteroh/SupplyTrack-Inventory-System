package com.proyecto.SupplyTrack.repository;

import com.proyecto.SupplyTrack.domain.Factura;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {

    Optional<Factura> findByNumFactura(String numFactura);
}
