package com.proyecto.SupplyTrack.service.impl;

import com.proyecto.SupplyTrack.domain.Producto;
import com.proyecto.SupplyTrack.repository.ProductoRepository;
import com.proyecto.SupplyTrack.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerProductoPorId(Integer idProducto) {
        return productoRepository.findById(idProducto).orElse(null);
    }

    @Override
    public void guardarProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
        productoRepository.deleteById(idProducto);
    }

    @Override
    public List<Producto> listarPorEstado(String estado) {
        return productoRepository.findByEstado(estado);
    }

    @Override
    public List<Producto> listarPorCategoria(String categoria) {
        return productoRepository.findByCategoria(categoria);
    }
}