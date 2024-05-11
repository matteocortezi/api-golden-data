package golden.data.api.historicoCompra;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "HISTORICO_COMPRA")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_compra")
public class HistoricoCompra {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_compra;
    private String dt_compra;
    private String valor_compra;

    @Column(name= "id_pagamento")
    private Long id_pagamento;



    public HistoricoCompra(HistoricoCompraDTO dados) {
        this.dt_compra = dados.dt_compra();
        this.valor_compra = dados.valor_compra();
    }
}
