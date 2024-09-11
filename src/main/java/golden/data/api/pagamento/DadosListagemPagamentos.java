package golden.data.api.pagamento;

import golden.data.api.model.Pagamento;

public record DadosListagemPagamentos(
        Float vlrPag,
        String mtdPag,
        String stsPag) {

    public DadosListagemPagamentos(Pagamento pagamento) {
        this(pagamento.getVlrPag(),
                pagamento.getMtdPag(),
                pagamento.getStsPag());
    }
}


