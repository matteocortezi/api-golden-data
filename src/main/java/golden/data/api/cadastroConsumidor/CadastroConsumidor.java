package golden.data.api.cadastroConsumidor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity (name = "CADASTRO_CONSUMIDOR")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_consumidor")
public class CadastroConsumidor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_consumidor;
    private String email_consumidor;
    private String senha_consumidor;
    private String cpf_consumidor;
    private String nm_consumidor;
    private String genero_consumidor;
    private String dt_nasc_cons;
    private String estado_consumidor;
}