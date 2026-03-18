package com.proyecto.SupplyTrack.repository;

import com.proyecto.SupplyTrack.domain.Categoria;
import com.proyecto.SupplyTrack.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByEstado(String estado);

    List<Producto> findByCategoria(Categoria categoria);

    boolean existsByCodigoIgnoreCase(String codigo);

    @Query("""
        SELECT p
        FROM Producto p
        LEFT JOIN FETCH p.proveedor pr
        LEFT JOIN FETCH p.categoria c
        ORDER BY p.nombre ASC
    """)
    List<Producto> findAllWithProveedor();

    @Query("""
        SELECT p
        FROM Producto p
        LEFT JOIN FETCH p.proveedor pr
        LEFT JOIN FETCH p.categoria c
        WHERE (:termino IS NULL OR :termino = ''
            OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :termino, '%'))
            OR LOWER(p.codigo) LIKE LOWER(CONCAT('%', :termino, '%')))
        ORDER BY p.nombre ASC
    """)
    List<Producto> buscarPorNombreOCodigo(@Param("termino") String termino);

    @Override
    @Query("""
        SELECT p
        FROM Producto p
        LEFT JOIN FETCH p.proveedor pr
        LEFT JOIN FETCH p.categoria c
    """)
    List<Producto> findAll();
}