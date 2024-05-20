package golden.data.api.cadastroConsumidor;
import golden.data.api.infoConsumidor.InfoConsumidor;
import golden.data.api.infoConsumidorEmpresa.InfoConsumidorEmpresa;
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
    //Devido a um problema com o BANCO não está sendo possível usar o ID autoincrementável.
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
