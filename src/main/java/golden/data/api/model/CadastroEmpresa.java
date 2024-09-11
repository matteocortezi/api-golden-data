package golden.data.api.model;
import golden.data.api.dto.empresaDTO.CadastroEmpresaDto;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Entity(name = "CADASTRO_EMPRESA")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CadastroEmpresa {
    //Devido a um problema com o BANCO não está sendo possível usar o ID autoincrementável.
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id_emp;
    private String cnpj_emp;
    private String eml_emp;
    private String rz_social_emp;
    private String senha_emp;

    @OneToMany(mappedBy = "empresa")
    private List <Pagamento> pagamentos;

    @OneToMany(mappedBy = "empresa")
    private List <InfoConsumidorEmpresa> infoConsumidorParaEmpresa;


    public CadastroEmpresa(CadastroEmpresaDto dados) {
        this.id_emp = dados.id_emp();
        this.cnpj_emp = dados.cnpj_emp();
        this.eml_emp = dados.eml_emp();
        this.rz_social_emp = dados.rz_social_emp();
        this.senha_emp = dados.senha_emp();
    }

    public void atualizarInformacoes(CadastroEmpresaDto dados) {
        if (dados.id_emp() != null) {
            this.id_emp = dados.id_emp();
        }
        if (dados.cnpj_emp() != null) {
            this.cnpj_emp = dados.cnpj_emp();
        }
        if (dados.eml_emp() != null) {
            this.eml_emp = dados.eml_emp();
        }
        if (dados.rz_social_emp() != null) {
            this.rz_social_emp = dados.rz_social_emp();
        }
        if (dados.senha_emp() != null) {
            this.senha_emp = dados.senha_emp();
        }
    }

}
