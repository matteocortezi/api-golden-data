package golden.data.api.pagamento;

import jakarta.validation.constraints.NotBlank;

public record PagamentoDTO(
        @NotBlank
        Float vlr_pag,
        @NotBlank
        String mtd_pag,
        @NotBlank
        String sts_pag) {
}
