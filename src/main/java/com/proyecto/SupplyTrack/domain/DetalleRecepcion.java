package com.proyecto.SupplyTrack.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "detalle_recepcion")
public class DetalleRecepcion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_rec")
    private Integer idDetalleRec;

    @ManyToOne
    @JoinColumn(name = "id_recepcion", nullable = false)
    private Recepcion recepcion;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_tienda", nullable = false)
    private Tienda tienda;

    @Column(name = "cantidad_recibida", nullable = false)
    @NotNull
    @Min(0)
    private Integer cantidadRecibida;

    @Column(length = 50)
    @Size(max = 50)
    private String tipo;
}
