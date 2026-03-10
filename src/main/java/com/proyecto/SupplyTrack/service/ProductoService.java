package com.proyecto.SupplyTrack.service;

import com.proyecto.SupplyTrack.domain.Producto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import com.proyecto.SupplyTrack.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Transactional(readOnly = true)
    public List<Producto> getProductos(){
        return productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Producto> getProducto(Integer id){
        return productoRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Producto> getProductosPorEstado(String estado){
        return productoRepository.findByEstado(estado);
    }

    @Transactional(readOnly = true)
    public List<Producto> getProductosPorCategoria(String categoria){
        return productoRepository.findByCategoria(categoria);
    }

}
