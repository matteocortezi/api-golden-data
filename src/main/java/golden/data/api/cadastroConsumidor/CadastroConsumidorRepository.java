package golden.data.api.cadastroConsumidor;

import golden.data.api.model.CadastroConsumidor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroConsumidorRepository extends JpaRepository<CadastroConsumidor, Long> {
}
