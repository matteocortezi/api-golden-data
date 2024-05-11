package golden.data.api.pagamento;

import jakarta.validation.constraints.NotBlank;

public record PagamentoDTO(
        @NotBlank
        Float valor,
        @NotBlank
        String metodo_pagamento,
        @NotBlank
        String status_pagamento) {
}
