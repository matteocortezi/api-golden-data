package golden.data.api.cadastroEmpresa;

import golden.data.api.infoConsumidorEmpresa.InfoConsumidorEmpresa;
import golden.data.api.pagamento.Pagamento;
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
@EqualsAndHashCode(of = "id_emp")
public class CadastroEmpresa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_emp;
    private String cnpj_emp;
    private String eml_emp;
    private String rz_social_emp;
    private String senha_emp;

    @OneToMany(mappedBy = "id_emp")
    private List <Pagamento> pagamentos;

    @OneToMany(mappedBy = "id_emp")
    private List <InfoConsumidorEmpresa> infoConsumidorParaEmpresa;


    public CadastroEmpresa(CadastroEmpresaDto dados) {
       this.cnpj_emp = dados.cnpj_emp();
       this.eml_emp = dados.eml_emp();
       this.rz_social_emp = dados.rz_social_emp();
       this.senha_emp = dados.senha_emp();
    }
}
