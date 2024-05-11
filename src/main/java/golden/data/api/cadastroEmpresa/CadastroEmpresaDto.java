package golden.data.api.cadastroEmpresa;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CadastroEmpresaDto(
        @NotBlank
        String cnpj_empresa,
        @NotBlank
        @Email
        String email_empresa,
        @NotBlank
        String razao_social,
        @NotBlank
        String senha_empresa) {
}
