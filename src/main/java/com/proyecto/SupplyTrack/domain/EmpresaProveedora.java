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
@Table(name = "empresa_proveedora")
public class EmpresaProveedora implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Integer idEmpresa;

    @Column(nullable = false, length = 150)
    @NotBlank
    @Size(max = 150)
    private String nombre;

    @Column(name = "cedula_juridica", nullable = false, unique = true, length = 50)
    @NotBlank
    @Size(max = 50)
    private String cedulaJuridica;

    @Column(length = 50)
    @Size(max = 50)
    private String telefono;

    @Column(length = 255)
    @Size(max = 255)
    private String direccion;
}
