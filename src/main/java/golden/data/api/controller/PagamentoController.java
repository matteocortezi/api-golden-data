package golden.data.api.controller;

import golden.data.api.pagamento.DadosListagemPagamentos;
import golden.data.api.model.Pagamento;
import golden.data.api.pagamento.PagamentoDTO;
import golden.data.api.repository.PagamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<DadosListagemPagamentos> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemPagamentos::new);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
