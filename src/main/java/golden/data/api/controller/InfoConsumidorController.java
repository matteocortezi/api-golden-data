package golden.data.api.controller;

import golden.data.api.cadastroConsumidor.DadosListagemConsumidores;
import golden.data.api.infoConsumidor.DadosListagemInfoConsumidor;
import golden.data.api.infoConsumidor.InfoConsumidor;
import golden.data.api.infoConsumidor.InfoConsumidorDTO;
import golden.data.api.infoConsumidor.InfoConsumidorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("info-consumidor")

public class InfoConsumidorController {

    @Autowired
    InfoConsumidorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody InfoConsumidorDTO dados){
        repository.save(new InfoConsumidor(dados));
    }
    @GetMapping
    public List<DadosListagemInfoConsumidor> listar() {
        return repository.findAll().stream().map(DadosListagemInfoConsumidor::new).toList();
    }

}
