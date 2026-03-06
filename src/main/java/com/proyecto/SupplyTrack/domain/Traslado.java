package com.proyecto.SupplyTrack.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "traslados")
public class Traslado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Integer idMovimiento;

    @Column(nullable = false)
    private LocalDateTime fecha = LocalDateTime.now();

    @Column(nullable = false, length = 50)
    @NotBlank
    @Size(max = 50)
    private String tipo;

    @Column(length = 150)
    @Size(max = 150)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_tienda_origen", nullable = false)
    private Tienda tiendaOrigen;

    @ManyToOne
    @JoinColumn(name = "id_tienda_destino", nullable = false)
    private Tienda tiendaDestino;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
