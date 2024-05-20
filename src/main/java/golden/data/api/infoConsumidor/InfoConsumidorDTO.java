package golden.data.api.infoConsumidor;

import jakarta.validation.constraints.NotBlank;

public record InfoConsumidorDTO(
        @NotBlank
        String pref_cpm_clie,
        @NotBlank
        String pref_anc,
        @NotBlank
        String marcas_evitadas,
        @NotBlank
        String hobbies,
        @NotBlank
        String anc_evitados,
        @NotBlank
        String cmp_on) {
}
