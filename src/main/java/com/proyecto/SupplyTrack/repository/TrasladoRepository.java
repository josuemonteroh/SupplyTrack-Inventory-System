package com.proyecto.SupplyTrack.repository;

import com.proyecto.SupplyTrack.domain.Tienda;
import com.proyecto.SupplyTrack.domain.Traslado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrasladoRepository extends JpaRepository<Traslado, Integer> {

    List<Traslado> findByTiendaOrigen(Tienda tiendaOrigen);

    List<Traslado> findByTiendaDestino(Tienda tiendaDestino);
}
