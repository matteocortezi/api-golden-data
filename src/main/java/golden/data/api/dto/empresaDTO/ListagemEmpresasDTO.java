package golden.data.api.dto.empresaDTO;


import golden.data.api.model.CadastroEmpresa;

public record ListagemEmpresasDTO(
        Long id_emp,
        String cnpj_emp,
        String eml_emp,
        String rz_social_emp,
        String senha_emp
) {
    public ListagemEmpresasDTO(CadastroEmpresa empresa) {
        this(empresa.getId_emp(),
                empresa.getCnpj_emp(),
                empresa.getEml_emp(),
                empresa.getRz_social_emp(),
                empresa.getSenha_emp());
    }
}