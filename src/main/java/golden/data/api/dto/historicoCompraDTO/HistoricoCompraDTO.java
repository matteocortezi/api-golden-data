package golden.data.api.dto.historicoCompraDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HistoricoCompraDTO(
        @NotNull
        Long idCmp,
        @NotBlank
        String dtCmp,
        @NotBlank
        String vlrCmp) {
}

