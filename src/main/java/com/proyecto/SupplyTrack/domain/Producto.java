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
@Table(name = "producto", uniqueConstraints = {
    @UniqueConstraint(columnNames = "codigo")
})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(nullable = false, length = 50, unique = true)
    @NotBlank
    @Size(max = 50)
    private String codigo;

    @Column(nullable = false, length = 150)
    @NotBlank
    @Size(max = 150)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @Column(nullable = false, precision = 12, scale = 2)
    @NotNull
    @DecimalMin(value = "0.00", inclusive = true)
    private BigDecimal precio;

    @Column(name = "stock_minimo", nullable = false)
    @NotNull
    @Min(0)
    private Integer stockMinimo = 0;

    @Column(name = "stock_maximo", nullable = false)
    @NotNull
    @Min(0)
    private Integer stockMaximo = 0;

    @Column(nullable = false, length = 50)
    @NotBlank
    @Size(max = 50)
    private String estado;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;
}