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
    @Column(name = "id_cons")
    private Long idCons;

    @Column(name = "eml_cons")
    private String emlCons;

    @Column(name = "pwd_cons")
    private String pwdCons;

    @Column(name = "cpf_cons")
    private String cpfCons;

    @Column(name = "nm_cons")
    private String nmCons;

    @Column(name = "gen_cons")
    private String genCons;

    @Column(name = "dt_nasc_cons")
    private String dtNascCons;

    @Column(name = "est_cons")
    private String estCons;


    public CadastroConsumidor(CadastroConsumidorDTO dados) {
        this.idCons = dados.idCons();
        this.emlCons = dados.emlCons();
        this.pwdCons = dados.pwdCons();
        this.cpfCons = dados.cpfCons();
        this.nmCons = dados.nmCons();
        this.genCons = dados.genCons();
        this.dtNascCons = dados.dtNascCons();
        this.estCons = dados.estCons();
    }

    public void atualizarInformacoes(CadastroConsumidorDTO dados) {
        if (dados.idCons() != null) {
            this.idCons = dados.idCons();
        }
        if (dados.emlCons() != null) {
            this.emlCons = dados.emlCons();
        }
        if (dados.pwdCons() != null) {
            this.pwdCons = dados.pwdCons();
        }
        if (dados.cpfCons() != null) {
            this.cpfCons = dados.cpfCons();
        }
        if (dados.nmCons() != null) {
            this.nmCons = dados.nmCons();
        }
        if (dados.genCons() != null) {
            this.genCons = dados.genCons();
        }
        if (dados.dtNascCons() != null) {
            this.dtNascCons = dados.dtNascCons();
        }
        if (dados.estCons() != null) {
            this.estCons = dados.estCons();
        }
    }

}
