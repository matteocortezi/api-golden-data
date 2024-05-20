package golden.data.api.pagamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PagamentoDTO(
        @NotNull
        Long id_pag,
        @NotBlank
        Float vlr_pag,
        @NotBlank
        String mtd_pag,
        @NotBlank
        String sts_pag) {
}
