package com.proyecto.SupplyTrack.service;

import com.proyecto.SupplyTrack.domain.Tienda;
import com.proyecto.SupplyTrack.repository.TiendaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TiendaService {

    private final TiendaRepository tiendaRepository;

    public TiendaService(TiendaRepository tiendaRepository) {
        this.tiendaRepository = tiendaRepository;
    }

    @Transactional(readOnly = true)
    public List<Tienda> getTiendas(){
        return tiendaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Tienda> getTienda(Integer id){
        return tiendaRepository.findById(id);
    }

}
