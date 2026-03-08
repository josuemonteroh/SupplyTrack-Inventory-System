package com.proyecto.SupplyTrack.repository;

import com.proyecto.SupplyTrack.domain.AjusteInventario;
import com.proyecto.SupplyTrack.domain.Inventario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AjusteInventarioRepository extends JpaRepository<AjusteInventario, Integer> {

    List<AjusteInventario> findByInventario(Inventario inventario);

    List<AjusteInventario> findByTipoInout(String tipoInout);
}
