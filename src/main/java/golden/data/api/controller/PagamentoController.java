package golden.data.api.controller;

import golden.data.api.pagamento.pagamentoDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {
    @PostMapping
    public void cadastrar(@RequestBody pagamentoDTO dados){
        System.out.println(dados);
    }
}
