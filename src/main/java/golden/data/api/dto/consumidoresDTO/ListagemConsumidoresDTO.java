package golden.data.api.dto.consumidoresDTO;

import golden.data.api.model.CadastroConsumidor;

public record ListagemConsumidoresDTO(
        Long id_cons,
        String eml_cons,
        String cpf_cons,
        String nm_cons,
        String gen_cons,
        String dt_nasc_cons,
        String est_cons
) {
    public ListagemConsumidoresDTO(CadastroConsumidor consumidor) {
        this(consumidor.getId_cons(),
                consumidor.getEml_cons(),
                consumidor.getCpf_cons(),
                consumidor.getNm_cons(),
                consumidor.getGen_cons(),
                consumidor.getDt_nasc_cons(),
                consumidor.getEst_cons());
    }

}
