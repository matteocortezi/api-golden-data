package golden.data.api.controller;

import golden.data.api.cadastroConsumidor.DadosListagemConsumidores;
import golden.data.api.historicoCompra.DadosListagemHistoricoCompra;
import golden.data.api.historicoCompra.HistoricoCompra;
import golden.data.api.historicoCompra.HistoricoCompraDTO;
import golden.data.api.historicoCompra.HistoricoCompraRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("historico-compra")
public class HistoricoCompraController {

    @Autowired
    private HistoricoCompraRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody HistoricoCompraDTO dados){
        repository.save(new HistoricoCompra(dados));
    }
    @GetMapping
    public List<DadosListagemHistoricoCompra> listar() {
        return repository.findAll().stream().map(DadosListagemHistoricoCompra::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid HistoricoCompraDTO dados){
        var historicoCompra = repository.getReferenceById(dados.id_cmp());
        historicoCompra.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
