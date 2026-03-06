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
@Table(name = "tienda")
public class Tienda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tienda")
    private Integer idTienda;

    @Column(nullable = false, length = 150)
    @NotBlank
    @Size(max = 150)
    private String nombre;

    @Column(nullable = false, length = 255)
    @NotBlank
    @Size(max = 255)
    private String ubicacion;
}
