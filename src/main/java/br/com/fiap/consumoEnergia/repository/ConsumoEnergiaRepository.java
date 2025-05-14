package br.com.fiap.consumoEnergia.repository;

import br.com.fiap.consumoEnergia.model.ConsumoEnergia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ConsumoEnergiaRepository extends JpaRepository<ConsumoEnergia, Long> {

    @Query("SELECT a FROM ConsumoEnergia a WHERE a.nome = :nome")
    Optional<ConsumoEnergia> buscarPorNome(@Param("nome")String nome);
}