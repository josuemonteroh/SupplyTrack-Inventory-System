package com.proyecto.SupplyTrack.repository;

import com.proyecto.SupplyTrack.domain.EmpresaProveedora;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaProveedoraRepository extends JpaRepository<EmpresaProveedora, Integer> {

    Optional<EmpresaProveedora> findByCedulaJuridica(String cedulaJuridica);
}
