package com.proyecto.SupplyTrack.repository;

import com.proyecto.SupplyTrack.domain.DetalleRecepcion;
import com.proyecto.SupplyTrack.domain.Recepcion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleRecepcionRepository extends JpaRepository<DetalleRecepcion, Integer> {

    List<DetalleRecepcion> findByRecepcion(Recepcion recepcion);
}
