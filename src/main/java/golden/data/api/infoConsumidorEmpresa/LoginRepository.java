package golden.data.api.infoConsumidorEmpresa;

import golden.data.api.model.InfoConsumidorEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository <InfoConsumidorEmpresa, Long> {
}
