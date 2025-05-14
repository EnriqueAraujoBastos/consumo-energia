package br.com.fiap.consumoEnergia.service;

import br.com.fiap.consumoEnergia.dto.ConsumoEnergiaCadastroDTO;
import br.com.fiap.consumoEnergia.dto.ConsumoEnergiaExibicaoDTO;
import br.com.fiap.consumoEnergia.model.ConsumoEnergia;
import br.com.fiap.consumoEnergia.repository.ConsumoEnergiaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ConsumoEnergiaService {

    @Autowired
    private ConsumoEnergiaRepository consumoEnergiaRepository;

    public ConsumoEnergiaExibicaoDTO salvarConsumoEnergia(ConsumoEnergiaCadastroDTO consumoEnergiaDTO){

        ConsumoEnergia consumoEnergia = new ConsumoEnergia();
        BeanUtils.copyProperties(consumoEnergiaDTO, consumoEnergia);

        consumoEnergia.setConsumoEnergia(
                calcularConsumoEnergia(
                        consumoEnergia.getTempoUsoMinutos(),
                        consumoEnergia.getConsumoHora()
                )
        );

        ConsumoEnergia consumoEnergiaSalvo = consumoEnergiaRepository.save(consumoEnergia);
        return new ConsumoEnergiaExibicaoDTO(consumoEnergiaSalvo);

    }

    public ConsumoEnergiaExibicaoDTO buscarPorId(Long id){
        Optional<ConsumoEnergia> consumoEnergiaOptional =
                consumoEnergiaRepository.findById(id);

        if (consumoEnergiaOptional.isPresent()){
            return new ConsumoEnergiaExibicaoDTO(consumoEnergiaOptional.get());
        } else {
            throw new RuntimeException("Este consumo não existe!");
        }
    }

    public List<ConsumoEnergiaExibicaoDTO> listarTodos(){
        return consumoEnergiaRepository
                .findAll()
                .stream()
                .map(ConsumoEnergiaExibicaoDTO::new)
                .toList();
    }
    public void excluir(Long id){
        Optional<ConsumoEnergia> consumoEnergiaOptional =
                consumoEnergiaRepository.findById(id);

        if (consumoEnergiaOptional.isPresent()){
            consumoEnergiaRepository.delete(consumoEnergiaOptional.get());
        } else {
            throw new RuntimeException("Este consumo não foi encontrado!");
        }
    }

    public ConsumoEnergiaExibicaoDTO atualizar(ConsumoEnergiaCadastroDTO consumoEnergiaDTO){
        Optional<ConsumoEnergia> consumoEnergiaOptional =
                consumoEnergiaRepository.findById(consumoEnergiaDTO.consumoEnergiaId());

        if (consumoEnergiaOptional.isPresent()){
            ConsumoEnergia consumoEnergia = new ConsumoEnergia();
            BeanUtils.copyProperties(consumoEnergiaDTO, consumoEnergia);

            consumoEnergia.setConsumoEnergia(
                    calcularConsumoEnergia(
                            consumoEnergia.getTempoUsoMinutos(),
                            consumoEnergia.getConsumoHora()
                                        )
            );

            return new ConsumoEnergiaExibicaoDTO(consumoEnergiaRepository.save(consumoEnergia));
        } else {
            throw new RuntimeException("Este consumo de energia não foi encontrado");
        }
    }

    public Double calcularConsumoEnergia(Integer tempoUsoMinutos, Double consumoHora){
        Double consumoEnergia = consumoHora * (tempoUsoMinutos / 60.0);
        return consumoEnergia;
    }

    public ConsumoEnergiaExibicaoDTO buscarPorNome(String nome){
        Optional<ConsumoEnergia> consumoEnergiaOptional =
                consumoEnergiaRepository.buscarPorNome(nome);

        if (consumoEnergiaOptional.isPresent()){
            return new ConsumoEnergiaExibicaoDTO(consumoEnergiaOptional.get());
        } else {
            throw new RuntimeException("Este consumo não existe");
        }
    }
}