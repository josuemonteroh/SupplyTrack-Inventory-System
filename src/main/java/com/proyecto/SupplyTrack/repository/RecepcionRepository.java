package com.proyecto.SupplyTrack.repository;

import com.proyecto.SupplyTrack.domain.OrdenCompra;
import com.proyecto.SupplyTrack.domain.Recepcion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecepcionRepository extends JpaRepository<Recepcion, Integer> {

    List<Recepcion> findByEstadoValidacion(String estadoValidacion);

    List<Recepcion> findByOrdenCompra(OrdenCompra ordenCompra);
}
