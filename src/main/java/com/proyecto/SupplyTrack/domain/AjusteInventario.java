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
@Table(name = "ajuste_inventario")
public class AjusteInventario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ajuste")
    private Integer idAjuste;

    @ManyToOne
    @JoinColumn(name = "id_inventario", nullable = false)
    private Inventario inventario;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    // Valores permitidos: 'IN' o 'OUT'
    @Column(name = "tipo_inout", nullable = false, length = 10)
    @NotBlank
    @Pattern(regexp = "^(IN|OUT)$", message = "El tipo debe ser IN o OUT")
    private String tipoInout;

    @Column(nullable = false, length = 255)
    @NotBlank
    @Size(max = 255)
    private String motivo;

    @Column(nullable = false)
    private LocalDateTime fecha = LocalDateTime.now();

    @Column(name = "cantidad_ajustada", nullable = false)
    @NotNull
    private Integer cantidadAjustada;
}
