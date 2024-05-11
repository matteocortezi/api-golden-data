package golden.data.api.historicoCompra;

import jakarta.validation.constraints.NotBlank;

public record HistoricoCompraDTO(
        @NotBlank
        String dt_compra,
        @NotBlank
        String valor_compra) {
}
