package golden.data.api.login;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "LOGIN")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_login")
public class Login {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_login;
    String email_usuario;
    String senha_usuario;
}
