package golden.data.api.dto.empresaDTO;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroEmpresaDto(

        @NotNull
        Long id_emp,
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
