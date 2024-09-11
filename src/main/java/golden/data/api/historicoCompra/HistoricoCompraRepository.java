package golden.data.api.historicoCompra;

import golden.data.api.model.HistoricoCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoCompraRepository extends JpaRepository<HistoricoCompra, Long> {
}
