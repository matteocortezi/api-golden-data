package golden.data.api.infoConsumidor;

import jakarta.validation.constraints.NotBlank;

public record InfoConsumidorDTO(
        @NotBlank
        String pref_compra_clie,
        @NotBlank
        String pref_anuncio,
        @NotBlank
        String marcas_evitadas,
        @NotBlank
        String hobbies,
        @NotBlank
        String anuncios_evitados,
        @NotBlank
        String compra_online) {
}
