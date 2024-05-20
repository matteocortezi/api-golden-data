package golden.data.api.controller;

import golden.data.api.cadastroConsumidor.DadosListagemConsumidores;
import golden.data.api.pagamento.DadosListagemPagamentos;
import golden.data.api.pagamento.Pagamento;
import golden.data.api.pagamento.PagamentoDTO;
import golden.data.api.pagamento.PagamentoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody PagamentoDTO dados){
        repository.save(new Pagamento(dados));
    }
    @GetMapping
    public List<DadosListagemPagamentos> listar() {
        return repository.findAll().stream().map(DadosListagemPagamentos::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid PagamentoDTO dados){
        var pagamento = repository.getReferenceById(dados.id_pag());
        pagamento.atualizarInformacoes(dados);
    }
}
