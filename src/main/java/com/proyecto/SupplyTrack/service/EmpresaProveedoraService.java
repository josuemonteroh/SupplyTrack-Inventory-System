package com.proyecto.SupplyTrack.service;

import com.proyecto.SupplyTrack.domain.EmpresaProveedora;
import com.proyecto.SupplyTrack.repository.EmpresaProveedoraRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaProveedoraService {

    private final EmpresaProveedoraRepository empresaProveedoraRepository;

    public EmpresaProveedoraService(EmpresaProveedoraRepository empresaProveedoraRepository) {
        this.empresaProveedoraRepository = empresaProveedoraRepository;
    }

    @Transactional(readOnly = true)
    public List<EmpresaProveedora> getEmpresas() {
        return empresaProveedoraRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<EmpresaProveedora> getEmpresa(Integer id) {
        return empresaProveedoraRepository.findById(id);
    }

    @Transactional
    public void save(EmpresaProveedora empresa) {
        empresaProveedoraRepository.save(empresa);
    }

    @Transactional
    public void delete(Integer id) {
        if (!empresaProveedoraRepository.existsById(id)) {
            throw new IllegalArgumentException("La empresa con ID " + id + " no existe.");
        }
        try {
            empresaProveedoraRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("No se puede eliminar la empresa. Tiene proveedores asociados.", e);
        }
    }
}
