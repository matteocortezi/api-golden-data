package golden.data.api.model;
import golden.data.api.dto.consumidoresDTO.CadastroConsumidorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity (name = "CADASTRO_CONSUMIDOR")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CadastroConsumidor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id_cons;
    private String eml_cons;
    private String pwd_cons;
    private String cpf_cons;
    private String nm_cons;
    private String gen_cons;
    private String dt_nasc_cons;
    private String est_cons;

    @OneToMany(mappedBy = "consumidor")
    private List<InfoConsumidorEmpresa> infoDoConsParaEmpresa;

    @OneToMany(mappedBy = "consumidor")
    private List<InfoConsumidor> infoDoConsumidor;


    public CadastroConsumidor(CadastroConsumidorDTO dados) {
        this.id_cons = dados.id_cons();
        this.eml_cons = dados.eml_cons();
        this.pwd_cons = dados.pwd_cons();
        this.cpf_cons = dados.cpf_cons();
        this.nm_cons = dados.nm_cons();
        this.gen_cons = dados.gen_cons();
        this.dt_nasc_cons = dados.dt_nasc_cons();
        this.est_cons = dados.est_cons();
    }

    public void atualizarInformacoes(CadastroConsumidorDTO dados) {
        if (dados.id_cons() != null) {
            this.id_cons = dados.id_cons();
        }
        if (dados.eml_cons() != null) {
            this.eml_cons = dados.eml_cons();
        }
        if (dados.pwd_cons() != null) {
            this.pwd_cons = dados.pwd_cons();
        }
        if (dados.cpf_cons() != null) {
            this.cpf_cons = dados.cpf_cons();
        }
        if (dados.nm_cons() != null) {
            this.nm_cons = dados.nm_cons();
        }
        if (dados.gen_cons() != null) {
            this.gen_cons = dados.gen_cons();
        }
        if (dados.dt_nasc_cons() != null) {
            this.dt_nasc_cons = dados.dt_nasc_cons();
        }
        if (dados.est_cons() != null) {
            this.est_cons = dados.est_cons();
        }
    }

}
