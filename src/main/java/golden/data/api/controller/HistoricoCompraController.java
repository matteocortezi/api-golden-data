package golden.data.api.controller;

import golden.data.api.historicoCompra.HistoricoCompra;
import golden.data.api.historicoCompra.HistoricoCompraDTO;
import golden.data.api.historicoCompra.HistoricoCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("historico-compra")
public class HistoricoCompraController {

    @Autowired
    private HistoricoCompraRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody HistoricoCompraDTO dados){
        repository.save(new HistoricoCompra(dados));
    }
}
