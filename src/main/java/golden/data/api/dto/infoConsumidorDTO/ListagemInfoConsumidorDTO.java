package golden.data.api.dto.infoConsumidorDTO;

import golden.data.api.model.InfoConsumidor;

public record ListagemInfoConsumidorDTO(String pref_cpm_clie,
                                        String pref_anc,
                                        String marcas_evitadas,
                                        String hobbies,
                                        String anc_evitados,
                                        String cmp_on) {

    public ListagemInfoConsumidorDTO(InfoConsumidor infoConsumidor) {
        this(infoConsumidor.getPref_cpm_clie(),
                infoConsumidor.getPref_anc(),
                infoConsumidor.getMarcas_evitadas(),
                infoConsumidor.getHobbies(),
                infoConsumidor.getAnc_evitados(),
                infoConsumidor.getCmp_on());
    }
}
