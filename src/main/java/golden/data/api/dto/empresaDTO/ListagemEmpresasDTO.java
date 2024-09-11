package golden.data.api.dto.empresaDTO;


import golden.data.api.model.CadastroEmpresa;

public record ListagemEmpresasDTO(
        Long idEmp,
        String cnpjEmp,
        String emlEmp,
        String rzSocialEmp,
        String senhaEmp

) {
    public ListagemEmpresasDTO(CadastroEmpresa empresa) {
        this(empresa.getIdEmp(),
                empresa.getCnpjEmp(),
                empresa.getEmlEmp(),
                empresa.getRzSocialEmp(),
                empresa.getSenhaEmp());
    }
}
