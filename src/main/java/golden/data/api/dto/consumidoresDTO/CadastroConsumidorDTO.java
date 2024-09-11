package golden.data.api.dto.consumidoresDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroConsumidorDTO(
        @NotNull
        Long idCons,
        @NotBlank
        @Email
        String emlCons,
        @NotBlank
        String pwdCons,
        @NotBlank
        String cpfCons,
        @NotBlank
        String nmCons,
        @NotBlank
        String genCons,
        @NotBlank
        String dtNascCons,
        @NotBlank
        String estCons) {
}
