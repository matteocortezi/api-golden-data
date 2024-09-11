package golden.data.api.dto.infoConsumidorDTO;

import golden.data.api.model.InfoConsumidor;

public record ListagemInfoConsumidorDTO(
        String prefCmpClie,
        String prefAnc,
        String marcasEvitadas,
        String hobbies,
        String ancEvitados,
        String cmpOn) {

    public ListagemInfoConsumidorDTO(InfoConsumidor infoConsumidor) {
        this(
                infoConsumidor.getPrefCmpClie(),
                infoConsumidor.getPrefAnc(),
                infoConsumidor.getMarcasEvitadas(),
                infoConsumidor.getHobbies(),
                infoConsumidor.getAncEvitados(),
                infoConsumidor.getCmpOn()
        );
    }
}

