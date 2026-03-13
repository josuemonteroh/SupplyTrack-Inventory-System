package com.proyecto.SupplyTrack.service;

import com.proyecto.SupplyTrack.domain.Inventario;
import com.proyecto.SupplyTrack.domain.Producto;
import com.proyecto.SupplyTrack.domain.Tienda;
import com.proyecto.SupplyTrack.repository.InventarioRepository;
import com.proyecto.SupplyTrack.repository.ProductoRepository;
import com.proyecto.SupplyTrack.repository.TiendaRepository;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ConsultaService {

    private final ProductoRepository productoRepository;
    private final InventarioRepository inventarioRepository;
    private final TiendaRepository tiendaRepository;

    public ConsultaService(ProductoRepository productoRepository,
                           InventarioRepository inventarioRepository,
                           TiendaRepository tiendaRepository) {
        this.productoRepository = productoRepository;
        this.inventarioRepository = inventarioRepository;
        this.tiendaRepository = tiendaRepository;
    }

    public List<Producto> buscarProductos(String termino) {
        String filtro = (termino == null) ? "" : termino.trim();
        return productoRepository.buscarPorNombreOCodigo(filtro);
    }

    public List<Tienda> listarTiendas() {
        return tiendaRepository.findAllByOrderByNombreAsc();
    }

    public List<Inventario> consultarInventarioPorTienda(Integer idTienda) {
        if (idTienda == null) {
            return Collections.emptyList();
        }
        return inventarioRepository.filtrarPorTienda(idTienda);
    }
}