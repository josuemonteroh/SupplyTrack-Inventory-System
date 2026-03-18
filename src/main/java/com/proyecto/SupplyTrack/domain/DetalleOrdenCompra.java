package com.proyecto.SupplyTrack.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "detalle_orden_compra")
public class DetalleOrdenCompra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_orden_compra", nullable = false)
    private OrdenCompra ordenCompra;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    @NotNull
    @Min(1)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false, precision = 12, scale = 2)
    @NotNull
    @DecimalMin(value = "0.01", inclusive = true)
    private BigDecimal precioUnitario;

    // Columna generada: cantidad * precio_unitario (solo lectura)
    @Column(precision = 14, scale = 2, insertable = false, updatable = false)
    private BigDecimal subtotal;
}
