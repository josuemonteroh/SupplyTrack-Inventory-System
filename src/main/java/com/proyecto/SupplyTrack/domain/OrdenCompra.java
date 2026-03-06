package com.proyecto.SupplyTrack.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "orden_compra")
public class OrdenCompra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden_compra")
    private Integer idOrdenCompra;

    @Column(nullable = false)
    @NotNull
    private LocalDate fecha;

    @Column(nullable = false, length = 50)
    @NotBlank
    @Size(max = 50)
    private String estado;

    @Column(nullable = false, precision = 14, scale = 2)
    @NotNull
    @DecimalMin(value = "0.00", inclusive = true)
    private BigDecimal total = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "id_tienda", nullable = false)
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;
}
