package golden.data.api.cadastroConsumidor;

import golden.data.api.model.CadastroConsumidor;

public record DadosListagemConsumidores(
        Long id_cons,
        String eml_cons,
        String pwd_cons,
        String cpf_cons,
        String nm_cons,
        String gen_cons,
        String dt_nasc_cons,
        String est_cons
) {
    public DadosListagemConsumidores(CadastroConsumidor consumidor) {
        this(consumidor.getId_cons(),
                consumidor.getEml_cons(),
                consumidor.getPwd_cons(),
                consumidor.getCpf_cons(),
                consumidor.getNm_cons(),
                consumidor.getGen_cons(),
                consumidor.getDt_nasc_cons(),
                consumidor.getEst_cons());
    }

}
