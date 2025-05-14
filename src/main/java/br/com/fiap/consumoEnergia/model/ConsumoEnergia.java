package br.com.fiap.consumoEnergia.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_consumo_energia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ConsumoEnergia {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CONSUMO_ENERGIA"
    )
    @SequenceGenerator(
            name = "SEQ_CONSUMO_ENERGIA",
            sequenceName = "SEQ_CONSUMO_ENERGIA",
            allocationSize = 1
    )
    @Column(name = "CONSUMO_ENERGIA_ID")
    private Long consumoEnergiaId;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "CONSUMO_HORA")
    private Double consumoHora;
    @Column(name = "TEMPO_USO_MINUTOS")
    private Integer tempoUsoMinutos;
    @Column (name = "CONSUMO_ENERGIA")
    private Double consumoEnergia;
    @Column(name = "DATA")
    private LocalDate data;
}
