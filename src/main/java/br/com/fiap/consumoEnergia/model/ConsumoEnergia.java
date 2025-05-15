package br.com.fiap.consumoEnergia.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_consumo_energia")
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

    public Long getConsumoEnergiaId() {
        return consumoEnergiaId;
    }

    public void setConsumoEnergiaId(Long consumoEnergiaId) {
        this.consumoEnergiaId = consumoEnergiaId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getConsumoEnergia() {
        return consumoEnergia;
    }

    public void setConsumoEnergia(Double consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    public Integer getTempoUsoMinutos() {
        return tempoUsoMinutos;
    }

    public void setTempoUsoMinutos(Integer tempoUsoMinutos) {
        this.tempoUsoMinutos = tempoUsoMinutos;
    }

    public Double getConsumoHora() {
        return consumoHora;
    }

    public void setConsumoHora(Double consumoHora) {
        this.consumoHora = consumoHora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
