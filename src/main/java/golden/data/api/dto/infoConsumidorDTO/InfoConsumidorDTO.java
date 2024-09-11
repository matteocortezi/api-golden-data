package golden.data.api.dto.infoConsumidorDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InfoConsumidorDTO(
        @NotNull
        Long idInfo,
        @NotBlank
        String prefCmpClie,
        @NotBlank
        String prefAnc,
        @NotBlank
        String marcasEvitadas,
        @NotBlank
        String hobbies,
        @NotBlank
        String ancEvitados,
        @NotBlank
        String cmpOn) {
}





