package golden.data.api.cadastroEmpresa;

import golden.data.api.cadastroConsumidor.CadastroConsumidorDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "CADASTRO_EMPRESA")
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

    public CadastroEmpresa(CadastroEmpresaDto dados) {
       this.cnpj_empresa = dados.cnpj_empresa();
       this.email_empresa = dados.email_empresa();
       this.razao_social = dados.razao_social();
       this.senha_empresa = dados.senha_empresa();
    }
}
