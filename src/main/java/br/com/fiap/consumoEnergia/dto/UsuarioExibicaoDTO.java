package br.com.fiap.consumoEnergia.dto;

import br.com.fiap.consumoEnergia.model.Usuario;
import br.com.fiap.consumoEnergia.model.UsuarioRole;

public record UsuarioExibicaoDTO(
        Long usuarioId,
        String nome,
        String email
) {

    public UsuarioExibicaoDTO(Usuario usuario) {
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail());
    }
}
