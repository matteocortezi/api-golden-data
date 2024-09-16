package golden.data.api.model;

import golden.data.api.dto.historicoCompraDTO.HistoricoCompraDTO;
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

    @Column(name = "id_cmp")
    private Long idCmp;

    @Column(name = "dt_cmp")
    private String dtCmp;

    @Column(name = "vlr_cmp")
    private String vlrCmp;




    public HistoricoCompra(HistoricoCompraDTO dados) {
        this.dtCmp = dados.dtCmp();
        this.vlrCmp = dados.vlrCmp();
    }

    public void atualizarInformacoes(HistoricoCompraDTO dados) {
        if (dados.dtCmp() != null) {
            this.dtCmp = dados.dtCmp();
        }
        if (dados.vlrCmp() != null) {
            this.vlrCmp = dados.vlrCmp();
        }
    }
}
