package golden.data.api.infoConsumidor;

import golden.data.api.cadastroConsumidor.CadastroConsumidor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "INFO_CONSUMIDOR")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_info")
public class InfoConsumidor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_info;
    private String pref_cpm_clie;
    private String pref_anc;
    private String marcas_evitadas;
    private String hobbies;
    private String anc_evitados;
    private String cmp_on;

    @ManyToOne
    @JoinColumn(name = "CADASTRO_CONSUMIDOR_id_cons", nullable = false)
    private CadastroConsumidor consumidor;

    public InfoConsumidor(InfoConsumidorDTO dados) {
        this.pref_cpm_clie = dados.pref_cpm_clie();
        this.pref_anc = dados.pref_anc();
        this.marcas_evitadas = dados.marcas_evitadas();
        this.hobbies = dados.hobbies();
        this.anc_evitados = dados.anc_evitados();
        this.cmp_on = dados.cmp_on();
    }
}
