package golden.data.api.pagamento;

import jakarta.validation.constraints.NotBlank;


public record PagamentoDTO(
        @NotBlank
        Float vlrPag,
        @NotBlank
        String mtdPag,
        @NotBlank
        String stsPag) {
}

