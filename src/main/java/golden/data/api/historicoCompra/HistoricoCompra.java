package golden.data.api.historicoCompra;

import golden.data.api.pagamento.Pagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "HISTORICO_COMPRA")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_cmp")
public class HistoricoCompra {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cmp;
    private String dt_cmp;
    private String vlr_cmp;

    @OneToOne
    private Pagamento pagamento;


    public HistoricoCompra(HistoricoCompraDTO dados) {
        this.dt_cmp = dados.dt_cmp();
        this.vlr_cmp = dados.vlr_cmp();
    }

    public void atualizarInformacoes(HistoricoCompraDTO dados) {
        if (dados.dt_cmp() != null) {
            this.dt_cmp = dados.dt_cmp();
        }
        if (dados.vlr_cmp() != null) {
            this.vlr_cmp = dados.vlr_cmp();
        }
    }
}
