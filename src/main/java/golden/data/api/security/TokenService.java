package golden.data.api.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import golden.data.api.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${JWT_SECRET:12345678}")
    private String secret;

    public String gerarToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return  JWT.create()
                    .withIssuer("API Golden Data")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token", exception);
            // Invalid Signing configuration / Couldn't convert Claims.
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
    @Value("${JWT_SECRET:12345678}")
    private String senhaToken;

    public String getSubject(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(senhaToken);
            return JWT.require(algorithm)
                    .withIssuer("FIAP").
                    build().
                    verify(token).
                    getSubject();
        } catch (JWTVerificationException e){
            throw new RuntimeException("Não foi possível validar o TokenJWT");
        }
    }
}
