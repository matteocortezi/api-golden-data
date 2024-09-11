package golden.data.api.dto.consumidoresDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroConsumidorDTO(
        @NotNull
        Long id_cons,
        @NotBlank
        @Email
        String eml_cons,
        @NotBlank
        String pwd_cons,
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
