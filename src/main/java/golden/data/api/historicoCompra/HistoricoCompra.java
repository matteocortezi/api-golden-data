package golden.data.api.historicoCompra;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
