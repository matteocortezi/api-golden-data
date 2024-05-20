package golden.data.api.historicoCompra;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HistoricoCompraDTO(
        @NotNull
        Long id_cmp,
        @NotBlank
        String dt_cmp,
        @NotBlank
        String vlr_cmp) {
}
