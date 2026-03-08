package com.proyecto.SupplyTrack.repository;

import com.proyecto.SupplyTrack.domain.EmpresaProveedora;
import com.proyecto.SupplyTrack.domain.Proveedor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    List<Proveedor> findByEmpresa(EmpresaProveedora empresa);
}
