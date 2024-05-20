package golden.data.api.cadastroConsumidor;
import golden.data.api.infoConsumidor.InfoConsumidor;
import golden.data.api.infoConsumidorEmpresa.InfoConsumidorEmpresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity (name = "CADASTRO_CONSUMIDOR")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_cons")
public class CadastroConsumidor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cons;
    private String eml_cons;
    private String senha_cons;
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
        this.eml_cons = dados.eml_cons();
        this.senha_cons = dados.senha_cons();
        this.cpf_cons = dados.cpf_cons();
        this.nm_cons = dados.nm_cons();
        this.gen_cons = dados.gen_cons();
        this.dt_nasc_cons = dados.dt_nasc_cons();
        this.est_cons = dados.est_cons();
    }
}
