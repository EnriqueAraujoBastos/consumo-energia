package br.com.fiap.consumoEnergia.dto;

import br.com.fiap.consumoEnergia.model.ConsumoEnergia;


public record ConsumoEnergiaExibicaoDTO (
        Long consumoEnergiaId,
        String nome,
        Double consumoHora,
        Integer tempoUsoMinutos,
        Double consumoEnergia
){

    public ConsumoEnergiaExibicaoDTO (ConsumoEnergia consumoEnergia) {
        this(
                consumoEnergia.getConsumoEnergiaId(),
                consumoEnergia.getNome(),
                consumoEnergia.getConsumoHora(),
                consumoEnergia.getTempoUsoMinutos(),
                consumoEnergia.getConsumoEnergia()
        );
    }

}
