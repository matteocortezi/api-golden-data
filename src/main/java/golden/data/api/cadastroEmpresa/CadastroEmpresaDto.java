package golden.data.api.cadastroEmpresa;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CadastroEmpresaDto(
        @NotBlank
        String cnpj_emp,
        @NotBlank
        @Email
        String eml_emp,
        @NotBlank
        String rz_social_emp,
        @NotBlank
        String senha_emp) {
}
