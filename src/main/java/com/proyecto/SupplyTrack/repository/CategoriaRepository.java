package com.proyecto.SupplyTrack.repository;

import com.proyecto.SupplyTrack.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
