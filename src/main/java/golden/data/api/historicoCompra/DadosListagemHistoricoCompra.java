package golden.data.api.historicoCompra;

import golden.data.api.model.HistoricoCompra;

public record DadosListagemHistoricoCompra (String dt_cmp, String vlr_cmp) {
    public DadosListagemHistoricoCompra(HistoricoCompra compras) {
        this(compras.getDt_cmp(), compras.getVlr_cmp());
    }
}
