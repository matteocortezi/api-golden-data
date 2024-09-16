package golden.data.api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Entity(name = "INFO_CONSUMIDOR_EMPRESA")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InfoConsumidorEmpresa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_info_cons_emp")
    private Long idInfoConsEmp;


}
