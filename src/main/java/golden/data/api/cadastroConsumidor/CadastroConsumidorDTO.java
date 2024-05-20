package golden.data.api.cadastroConsumidor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CadastroConsumidorDTO(

        @NotBlank
        @Email
        String eml_cons,
        @NotBlank
        String senha_cons,
        @NotBlank
        String cpf_cons,
        @NotBlank
        String nm_cons,
        @NotBlank
        String gen_cons,
        @NotBlank
        String dt_nasc_cons,
        @NotBlank
        String est_cons) {
}
