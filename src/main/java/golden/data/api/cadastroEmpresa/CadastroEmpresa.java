package golden.data.api.cadastroEmpresa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "CADASTRO_EMPRESA")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_empresa")
public class CadastroEmpresa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empresa;
    private String cnpj_empresa;
    private String email_empresa;
    private String razao_social;
    private String senha_empresa;
}
