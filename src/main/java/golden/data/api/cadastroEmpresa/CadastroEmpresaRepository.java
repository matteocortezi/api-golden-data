package golden.data.api.cadastroEmpresa;

import golden.data.api.model.CadastroEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroEmpresaRepository extends JpaRepository <CadastroEmpresa, Long> {
}
