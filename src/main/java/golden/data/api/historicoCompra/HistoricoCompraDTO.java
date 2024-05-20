package golden.data.api.historicoCompra;

import jakarta.validation.constraints.NotBlank;

public record HistoricoCompraDTO(
        @NotBlank
        String dt_cmp,
        @NotBlank
        String vlr_cmp) {
}
