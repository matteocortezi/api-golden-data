package golden.data.api.model;

import golden.data.api.pagamento.PagamentoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name = "PAGAMENTO")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_pag")
    private Long idPag;

    @Column(name = "vlr_pag")
    private Float vlrPag;

    @Column(name = "mtd_pag")
    private String mtdPag;

    @Column(name = "sts_pag")
    private String stsPag;


    public Pagamento(PagamentoDTO dados) {
        this.vlrPag = dados.vlrPag();
        this.mtdPag = dados.mtdPag();
        this.stsPag = dados.stsPag();
    }


    public void atualizarInformacoes(PagamentoDTO dados) {
        if (dados.vlrPag() != null) {
            this.vlrPag = dados.vlrPag();
        }
        if (dados.mtdPag() != null) {
            this.mtdPag = dados.mtdPag();
        }
        if (dados.stsPag() != null) {
            this.stsPag = dados.stsPag();
        }
    }


}
