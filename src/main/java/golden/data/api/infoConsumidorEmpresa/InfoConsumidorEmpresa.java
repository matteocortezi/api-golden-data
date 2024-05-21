package golden.data.api.infoConsumidorEmpresa;


import golden.data.api.cadastroConsumidor.CadastroConsumidor;
import golden.data.api.cadastroEmpresa.CadastroEmpresa;
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
    private Long id_info_cons_emp;

    @ManyToOne
    @JoinColumn(name = "CADASTRO_EMPRESA_id_emp")
    private CadastroEmpresa empresa;

    @ManyToOne
    @JoinColumn(name = "CADASTRO_CONSUMIDOR_id_cons")
    private CadastroConsumidor consumidor;


}
