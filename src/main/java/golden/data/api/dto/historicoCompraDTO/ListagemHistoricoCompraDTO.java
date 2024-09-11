package golden.data.api.dto.historicoCompraDTO;

import golden.data.api.model.HistoricoCompra;

public record ListagemHistoricoCompraDTO(String dt_cmp, String vlr_cmp) {
    public ListagemHistoricoCompraDTO(HistoricoCompra compras) {
        this(compras.getDt_cmp(), compras.getVlr_cmp());
    }
}
