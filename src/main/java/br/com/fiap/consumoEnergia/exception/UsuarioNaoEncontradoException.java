package br.com.fiap.consumoEnergia.exception;
public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

}