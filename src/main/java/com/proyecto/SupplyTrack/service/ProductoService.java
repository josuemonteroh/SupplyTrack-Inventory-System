package com.proyecto.SupplyTrack.service;

import com.proyecto.SupplyTrack.domain.Categoria;
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
    public List<Producto> listarProductos() {
        return getProductos();
    }

    @Transactional(readOnly = true)
    public Optional<Producto> getProducto(Integer id){
        return productoRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Producto obtenerProductoPorId(Integer idProducto) {
        return getProducto(idProducto).orElse(null);
    }

    @Transactional
    public void guardarProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Transactional
    public void eliminarProducto(Integer idProducto) {
        productoRepository.deleteById(idProducto);
    }

    @Transactional(readOnly = true)
    public List<Producto> getProductosPorEstado(String estado){
        return productoRepository.findByEstado(estado);
    }

    @Transactional(readOnly = true)
    public List<Producto> listarPorEstado(String estado) {
        return getProductosPorEstado(estado);
    }

    @Transactional(readOnly = true)
    public List<Producto> getProductosPorCategoria(Categoria categoria){
        return productoRepository.findByCategoria(categoria);
    }

    @Transactional(readOnly = true)
    public List<Producto> listarPorCategoria(Categoria categoria) {
        return getProductosPorCategoria(categoria);
    }

}
