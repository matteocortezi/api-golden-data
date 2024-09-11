package golden.data.api.dto.consumidoresDTO;

import golden.data.api.model.CadastroConsumidor;

public record ListagemConsumidoresDTO(
        Long idCons,
        String emlCons,
        String cpfCons,
        String nmCons,
        String genCons,
        String dtNascCons,
        String estCons
) {
    public ListagemConsumidoresDTO(CadastroConsumidor consumidor) {
        this(consumidor.getIdCons(),
                consumidor.getEmlCons(),
                consumidor.getCpfCons(),
                consumidor.getNmCons(),
                consumidor.getGenCons(),
                consumidor.getDtNascCons(),
                consumidor.getEstCons());
    }
}
