package golden.data.api.login;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank
        String email_usuario,
        @NotBlank
        String senha_usuario) {
}
