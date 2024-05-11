package golden.data.api.cadastroEmpresa;

import golden.data.api.cadastroConsumidor.CadastroConsumidorDTO;
import golden.data.api.login.Login;
import golden.data.api.pagamento.Pagamento;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "CADASTRO-EMPRESA")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_empresa")
public class CadastroEmpresa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empresa;
    private String cnpj_empresa;
    private String email_empresa;
    private String razao_social;
    private String senha_empresa;

    @ManyToOne
    @JoinColumn(name = "id_login_empresa", referencedColumnName = "id_login", nullable = true)
    private Login login;

    @OneToMany(mappedBy = "cadastroEmpresa")
    private List<Pagamento> pagamentos;

    public CadastroEmpresa(CadastroEmpresaDto dados) {
       this.cnpj_empresa = dados.cnpj_empresa();
       this.email_empresa = dados.email_empresa();
       this.razao_social = dados.razao_social();
       this.senha_empresa = dados.senha_empresa();
    }
}
