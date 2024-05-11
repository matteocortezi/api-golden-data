package golden.data.api.controller;

import golden.data.api.historicoCompra.HistoricoCompraDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("historico-compra")
public class historicoCompraController {
    @PostMapping
    public void cadastrar(@RequestBody HistoricoCompraDTO dados){
        System.out.println(dados);
    }
}
