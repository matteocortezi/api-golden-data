package golden.data.api.dto.historicoCompraDTO;

import golden.data.api.model.HistoricoCompra;

public record ListagemHistoricoCompraDTO(String dtCmp, String vlrCmp) {
    public ListagemHistoricoCompraDTO(HistoricoCompra compras) {
        this(compras.getDtCmp(), compras.getVlrCmp());
    }
}

