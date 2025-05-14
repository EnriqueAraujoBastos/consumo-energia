package br.com.fiap.consumoEnergia.controller;

import br.com.fiap.consumoEnergia.dto.ConsumoEnergiaCadastroDTO;
import br.com.fiap.consumoEnergia.dto.ConsumoEnergiaExibicaoDTO;
import br.com.fiap.consumoEnergia.service.ConsumoEnergiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ConsumoEnergiaController {

    @Autowired
    private ConsumoEnergiaService consumoEnergiaService;

    @PostMapping("/consumoEnergia")
    @ResponseStatus(HttpStatus.CREATED)
    public ConsumoEnergiaExibicaoDTO salvar(
            @RequestBody ConsumoEnergiaCadastroDTO consumoEnergia){
        return consumoEnergiaService.salvarConsumoEnergia(consumoEnergia);
    }

    @GetMapping("/consumoEnergia")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsumoEnergiaExibicaoDTO> listarTodos(){
        return consumoEnergiaService.listarTodos();
    }


    @GetMapping("/consumoEnergia/{consumoEnergiaId}")
    public ResponseEntity<ConsumoEnergiaExibicaoDTO> buscarPorId(
            @PathVariable Long consumoEnergiaId){
        try {
            return ResponseEntity
                    .ok(consumoEnergiaService.buscarPorId(consumoEnergiaId));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/consumoEnergia/{consumoEnergiaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long consumoEnergiaId){
        consumoEnergiaService.excluir(consumoEnergiaId);
    }

    @PutMapping("/consumoEnergia")
    public ResponseEntity<ConsumoEnergiaExibicaoDTO> atualizar(
            @RequestBody ConsumoEnergiaCadastroDTO alimentoDTO){
        try {
            ConsumoEnergiaExibicaoDTO consumoEnergiaExibicaoDTO =
                    consumoEnergiaService.atualizar(alimentoDTO);
            return ResponseEntity.ok(consumoEnergiaExibicaoDTO);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/consumoEnergia", params = "nome")
    public ResponseEntity<ConsumoEnergiaExibicaoDTO> buscarPornome(
            @RequestParam String nome){
        try {
            return ResponseEntity
                    .ok(consumoEnergiaService.buscarPorNome(nome));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
