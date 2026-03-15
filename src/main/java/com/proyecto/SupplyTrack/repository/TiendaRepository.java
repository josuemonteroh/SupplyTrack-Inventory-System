package com.proyecto.SupplyTrack.repository;

import com.proyecto.SupplyTrack.domain.Tienda;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiendaRepository extends JpaRepository<Tienda, Integer> {
    List<Tienda> findAllByOrderByNombreAsc();
}