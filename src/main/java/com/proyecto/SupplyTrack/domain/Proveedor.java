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
@Table(name = "proveedor")
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private EmpresaProveedora empresa;

    @Column(nullable = false, length = 150)
    @NotBlank
    @Size(max = 150)
    private String nombre;

    @Column(length = 150)
    @Email
    @Size(max = 150)
    private String correo;

    @Column(length = 50)
    @Size(max = 50)
    private String telefono;
}
