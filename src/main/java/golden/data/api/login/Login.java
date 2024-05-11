package golden.data.api.login;

import golden.data.api.cadastroConsumidor.CadastroConsumidor;
import golden.data.api.cadastroEmpresa.CadastroEmpresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany(mappedBy = "login")
    private List<CadastroConsumidor> cadastrosDeConsumidores;

    @OneToMany(mappedBy = "login")
    private List<CadastroEmpresa> cadastrosDeEmpresas;

    public Login(LoginDTO dados) {
        this.email_usuario = dados.email_usuario();
        this.senha_usuario = dados.senha_usuario();
    }
}
