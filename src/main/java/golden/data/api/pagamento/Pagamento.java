package golden.data.api.pagamento;

import golden.data.api.cadastroEmpresa.CadastroEmpresa;
import golden.data.api.historicoCompra.HistoricoCompra;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name = "PAGAMENTO")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_pag")
public class Pagamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pag;
    private Float vlr_pag;
    private String mtd_pag;
    private String sts_pag;

    @ManyToOne
    @JoinColumn(name = "CADASTRO_EMPRESA_id_emp", nullable = false)
    private CadastroEmpresa empresa;

    @OneToOne(mappedBy = "pagamento")
    private HistoricoCompra historicoCompra;

    public Pagamento(PagamentoDTO dados) {
        this.vlr_pag = dados.vlr_pag();
        this.mtd_pag = dados.mtd_pag();
        this.sts_pag = dados.sts_pag();
    }
}
