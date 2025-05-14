package br.com.fiap.consumoEnergia.dto;


public record ConsumoEnergiaCadastroDTO (
    Long consumoEnergiaId,
    String nome,
    Double consumoHora,
    Integer TempoUsoMinutos
){

}
