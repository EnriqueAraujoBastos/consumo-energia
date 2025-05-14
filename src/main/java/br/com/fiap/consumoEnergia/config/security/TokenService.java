package br.com.fiap.consumoEnergia.config.security;

import br.com.fiap.consumoEnergia.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("minha.chave.secreta")
    private String palavraSecreta;

    public String gerarToken(Usuario usuario){

        try {
            Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);

            String token = JWT.create()
                    .withIssuer("consumoEnergia")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(gerarDataDeExpiracao())
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException e){
            throw new RuntimeException("Não foi possível gerar o token!");
        }

    }

    private Instant gerarDataDeExpiracao(){
        return LocalDateTime
                .now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }

}