package golden.data.api.pagamento;

import golden.data.api.cadastroEmpresa.CadastroEmpresa;
import golden.data.api.historicoCompra.HistoricoCompra;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "PAGAMENTO")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_pagamento")
public class Pagamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pagamento;
    private Float valor;
    private String metodo_pagamento;
    private String status_pagamento;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id_empresa", name = "pagamento_empresa", nullable = false)
    private List<CadastroEmpresa> empresa;

    @OneToOne
    @JoinColumn(name = "historico_compra_empresa", referencedColumnName = "id_pagamento")
    private HistoricoCompra historico;

    public Pagamento(PagamentoDTO dados) {
        this.valor = dados.valor();
        this.metodo_pagamento = dados.metodo_pagamento();
        this.status_pagamento = dados.status_pagamento();
    }
}
