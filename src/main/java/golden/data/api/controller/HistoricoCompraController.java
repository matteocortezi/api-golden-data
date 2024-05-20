package golden.data.api.controller;

import golden.data.api.cadastroConsumidor.DadosListagemConsumidores;
import golden.data.api.historicoCompra.DadosListagemHistoricoCompra;
import golden.data.api.historicoCompra.HistoricoCompra;
import golden.data.api.historicoCompra.HistoricoCompraDTO;
import golden.data.api.historicoCompra.HistoricoCompraRepository;
import jakarta.transaction.Transactional;
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
}
