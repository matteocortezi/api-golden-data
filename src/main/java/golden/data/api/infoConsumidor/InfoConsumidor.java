package golden.data.api.infoConsumidor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String pref_compra_clie;
    private String pref_anuncio;
    private String marcas_evitadas;
    private String hobbies;
    private String anuncios_evitados;
    private String compra_online;

    public InfoConsumidor(InfoConsumidorDTO dados) {
        this.pref_compra_clie = dados.pref_compra_clie();
        this.pref_anuncio = dados.pref_anuncio();
        this.marcas_evitadas = dados.marcas_evitadas();
        this.hobbies = dados.hobbies();
        this.anuncios_evitados = dados.anuncios_evitados();
        this.compra_online = dados.compra_online();
    }
}
