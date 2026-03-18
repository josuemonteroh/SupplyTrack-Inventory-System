package com.proyecto.SupplyTrack.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "recepcion")
public class Recepcion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recepcion")
    private Integer idRecepcion;

    @Column(nullable = false)
    @NotNull
    private LocalDate fecha;

    @Column(name = "estado_validacion", nullable = false, length = 50)
    @NotBlank
    @Size(max = 50)
    private String estadoValidacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario_registrado", nullable = false)
    private Usuario usuarioRegistrado;

    @ManyToOne
    @JoinColumn(name = "id_orden_compra", nullable = false)
    private OrdenCompra ordenCompra;
}
