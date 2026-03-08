package com.proyecto.SupplyTrack.repository;

import com.proyecto.SupplyTrack.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByEstado(String estado);

    List<Producto> findByCategoria(String categoria);
}
