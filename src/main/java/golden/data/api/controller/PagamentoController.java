package golden.data.api.controller;

import golden.data.api.pagamento.Pagamento;
import golden.data.api.pagamento.PagamentoDTO;
import golden.data.api.pagamento.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoRepository repository;
    @PostMapping
    public void cadastrar(@RequestBody PagamentoDTO dados){
        repository.save(new Pagamento(dados));
    }
}
