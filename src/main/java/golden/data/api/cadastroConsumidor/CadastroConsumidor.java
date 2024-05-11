package golden.data.api.cadastroConsumidor;

import golden.data.api.login.Login;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity (name = "CADASTRO_CONSUMIDOR")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_consumidor")
public class CadastroConsumidor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_consumidor;
    private String email_consumidor;
    private String senha_consumidor;
    private String cpf_consumidor;
    private String nm_consumidor;
    private String genero_consumidor;
    private String dt_nasc_cons;
    private String estado_consumidor;

    @ManyToOne
    @JoinColumn(name = "id_login_consumidor", referencedColumnName = "id_login", nullable = false)
    private Login login;

    public CadastroConsumidor(CadastroConsumidorDTO dados) {
        this.email_consumidor = dados.email_consumidor();
        this.senha_consumidor = dados.senha_consumidor();
        this.cpf_consumidor = dados.cpf_consumidor();
        this.nm_consumidor = dados.nm_consumidor();
        this.genero_consumidor = dados.genero_consumidor();
        this.dt_nasc_cons = dados.dt_nasc_cons();
        this.estado_consumidor = dados.estado_consumidor();
    }
}
