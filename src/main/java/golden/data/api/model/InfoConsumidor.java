package golden.data.api.model;

import golden.data.api.dto.infoConsumidorDTO.InfoConsumidorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "INFO_CONSUMIDOR")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InfoConsumidor {
    @Id
    @Column(name = "id_info")
    private Long idInfo;

    @Column(name = "pref_cpm_clie")
    private String prefCmpClie;

    @Column(name = "pref_anc")
    private String prefAnc;

    @Column(name = "marcas_evitadas")
    private String marcasEvitadas;

    @Column(name = "hobbies")
    private String hobbies;

    @Column(name = "anc_evitados")
    private String ancEvitados;

    @Column(name = "cmp_on")
    private String cmpOn;

    @ManyToOne
    @JoinColumn(name = "CADASTRO_CONSUMIDOR_id_cons", nullable = false)
    private CadastroConsumidor consumidor;

    public InfoConsumidor(InfoConsumidorDTO dados) {
        this.prefCmpClie = dados.prefCmpClie();
        this.prefAnc = dados.prefAnc();
        this.marcasEvitadas = dados.marcasEvitadas();
        this.hobbies = dados.hobbies();
        this.ancEvitados = dados.ancEvitados();
        this.cmpOn = dados.cmpOn();
    }


    public void atualizarInformacoes(InfoConsumidorDTO dados) {
        if (dados.prefCmpClie() != null) {
            this.prefCmpClie = dados.prefCmpClie();
        }
        if (dados.prefAnc() != null) {
            this.prefAnc = dados.prefAnc();
        }
        if (dados.marcasEvitadas() != null) {
            this.marcasEvitadas = dados.marcasEvitadas();
        }
        if (dados.hobbies() != null) {
            this.hobbies = dados.hobbies();
        }
        if (dados.ancEvitados() != null) {
            this.ancEvitados = dados.ancEvitados();
        }
        if (dados.cmpOn() != null) {
            this.cmpOn = dados.cmpOn();
        }
    }


}
