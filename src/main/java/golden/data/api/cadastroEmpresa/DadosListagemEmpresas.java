package golden.data.api.cadastroEmpresa;



public record DadosListagemEmpresas(
        Long id_emp,
        String cnpj_emp,
        String eml_emp,
        String rz_social_emp,
        String senha_emp
) {
    public DadosListagemEmpresas(CadastroEmpresa empresa) {
        this(empresa.getId_emp(),
                empresa.getCnpj_emp(),
                empresa.getEml_emp(),
                empresa.getRz_social_emp(),
                empresa.getSenha_emp());
    }
}
