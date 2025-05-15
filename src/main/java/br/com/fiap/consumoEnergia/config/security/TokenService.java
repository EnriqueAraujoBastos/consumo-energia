package br.com.fiap.consumoEnergia.config.security;
import br.com.fiap.consumoEnergia.model.UsuarioRole;
import br.com.fiap.consumoEnergia.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String palavraSecreta;

    public String gerarToken(Usuario usuario){

        try {
            Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);

            String token = JWT.create()
                    .withIssuer("consumoEnergia")
                    .withSubject(usuario.getEmail())
                    .withClaim("role", usuario.getRole().toString())
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

    public UsernamePasswordAuthenticationToken  validarToken(String token){

        try {
            Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);
             DecodedJWT decodedJWT = JWT.require(algorithm)
                     .withIssuer("consumoEnergia")
                     .build()
                     .verify(token);
             String email = decodedJWT.getSubject();
             String role = decodedJWT.getClaim("role").asString();

             List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + role));
             return new UsernamePasswordAuthenticationToken(email, null, authorities);
        }catch (JWTVerificationException e){
            return null;
        }
    }

}