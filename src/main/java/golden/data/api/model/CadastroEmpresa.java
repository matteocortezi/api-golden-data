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
    @Id
    @Column(name = "id_emp")
    private Long idEmp;

    @Column(name = "cnpj_emp")
    private String cnpjEmp;

    @Column(name = "eml_emp")
    private String emlEmp;

    @Column(name = "rz_social_emp")
    private String rzSocialEmp;

    @Column(name = "senha_emp")
    private String senhaEmp;

    @OneToMany(mappedBy = "empresa")
    private List <Pagamento> pagamentos;

    @OneToMany(mappedBy = "empresa")
    private List <InfoConsumidorEmpresa> infoConsumidorParaEmpresa;


    public CadastroEmpresa(CadastroEmpresaDto dados) {
        this.idEmp = dados.idEmp();
        this.cnpjEmp = dados.cnpjEmp();
        this.emlEmp = dados.emlEmp();
        this.rzSocialEmp = dados.rzSocialEmp();
        this.senhaEmp = dados.senhaEmp();
    }


    public void atualizarInformacoes(CadastroEmpresaDto dados) {
        if (dados.idEmp() != null) {
            this.idEmp = dados.idEmp();
        }
        if (dados.cnpjEmp() != null) {
            this.cnpjEmp = dados.cnpjEmp();
        }
        if (dados.emlEmp() != null) {
            this.emlEmp = dados.emlEmp();
        }
        if (dados.rzSocialEmp() != null) {
            this.rzSocialEmp = dados.rzSocialEmp();
        }
        if (dados.senhaEmp() != null) {
            this.senhaEmp = dados.senhaEmp();
        }
    }


}
