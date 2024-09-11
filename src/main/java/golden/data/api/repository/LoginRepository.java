package golden.data.api.repository;

import golden.data.api.model.InfoConsumidorEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository <InfoConsumidorEmpresa, Long> {
}
