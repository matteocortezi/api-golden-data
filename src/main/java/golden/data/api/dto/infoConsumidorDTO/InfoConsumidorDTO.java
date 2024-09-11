package golden.data.api.dto.infoConsumidorDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InfoConsumidorDTO(
        @NotNull
        Long id_info,
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



