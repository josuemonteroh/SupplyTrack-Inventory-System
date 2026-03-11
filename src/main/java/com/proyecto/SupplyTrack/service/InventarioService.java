package com.proyecto.SupplyTrack.service;

import com.proyecto.SupplyTrack.domain.Inventario;
import com.proyecto.SupplyTrack.domain.Producto;
import com.proyecto.SupplyTrack.domain.Tienda;

import com.proyecto.SupplyTrack.repository.InventarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

    //Creo el servicio al repositorio y lo inicializo en el constructor cargado.
    private final InventarioRepository inventarioRepository;

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }


    @Transactional(readOnly = true) // como para tener una lista completa de inventarios, voy a generar primero el traer todos
    public List<Inventario> getInventarios(){
        return inventarioRepository.findAll();
    }

    //ahora para filtrar ahora para buscar por el id del inventario, por si se ocupa editar o algo.
    @Transactional(readOnly = true)
    public Optional<Inventario> getInventario(Integer id){
        return inventarioRepository.findById(id);
    }

    //Ahora si, traer el inventario por tienda y luiego por producto, y luego en combinacion con las dos.\

    @Transactional(readOnly = true)
    public List<Inventario> getInventariosByTienda(Tienda tienda){
        return inventarioRepository.findByTienda(tienda);
    }

    @Transactional(readOnly = true)
    public List<Inventario> getInventariosByProducto(Producto producto){
        return inventarioRepository.findByProducto(producto);
    }

    //Lo pongo como optional para evitar errores que puedan generarse.
    @Transactional(readOnly = true)
    public Optional<Inventario> getInventariosByProductoAndTienda(Producto producto, Tienda tienda){
        return inventarioRepository.findByProductoAndTienda(producto, tienda);
    }



}
