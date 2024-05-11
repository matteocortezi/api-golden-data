package golden.data.api.cadastroConsumidor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroConsumidorDTO(

        @NotBlank
        @Email
        String email_consumidor,
        @NotBlank
        String senha_consumidor,
        @NotBlank
        String cpf_consumidor,
        @NotBlank
        String nm_consumidor,
        @NotBlank
        String genero_consumidor,
        @NotBlank
        String dt_nasc_cons,
        @NotBlank
        String estado_consumidor) {
}
