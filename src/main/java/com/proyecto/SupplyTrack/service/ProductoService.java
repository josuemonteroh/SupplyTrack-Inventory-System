package com.proyecto.SupplyTrack.service;

import com.proyecto.SupplyTrack.domain.Producto;
import java.util.List;

public interface ProductoService {

    public List<Producto> listarProductos();

    public Producto obtenerProductoPorId(Integer idProducto);

    public void guardarProducto(Producto producto);

    public void eliminarProducto(Integer idProducto);

    public List<Producto> listarPorEstado(String estado);

    public List<Producto> listarPorCategoria(String categoria);
}