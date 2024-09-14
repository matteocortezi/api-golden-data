package golden.data.api.dto.empresaDTO;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroEmpresaDTO(

        @NotNull
        Long idEmp,

        @NotBlank
        String cnpjEmp,

        @NotBlank
        @Email
        String emlEmp,

        @NotBlank
        String rzSocialEmp,

        @NotBlank
        String senhaEmp

) {
}
