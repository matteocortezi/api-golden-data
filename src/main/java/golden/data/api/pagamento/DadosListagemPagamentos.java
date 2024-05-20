package golden.data.api.pagamento;

public record DadosListagemPagamentos(Float vlr_pag,
                                      String mtd_pag,
                                      String sts_pag) {

    public DadosListagemPagamentos(Pagamento pagamento) {
        this(pagamento.getVlr_pag(),
                pagamento.getMtd_pag(),
                pagamento.getSts_pag());
    }
}

