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
@Table(name = "factura")
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Integer idFactura;

    @Column(name = "num_factura", nullable = false, unique = true, length = 50)
    @NotBlank
    @Size(max = 50)
    private String numFactura;

    @Column(nullable = false)
    @NotNull
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_recepcion", nullable = false)
    private Recepcion recepcion;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private EmpresaProveedora empresa;
}
