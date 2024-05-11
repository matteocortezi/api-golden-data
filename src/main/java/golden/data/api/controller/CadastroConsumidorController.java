package golden.data.api.controller;

import golden.data.api.cadastroConsumidor.CadastroConsumidor;
import golden.data.api.cadastroConsumidor.CadastroConsumidorDTO;
import golden.data.api.cadastroConsumidor.CadastroConsumidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cadastro-consumidor")
public class CadastroConsumidorController {

    @Autowired
    private CadastroConsumidorRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody CadastroConsumidorDTO dados){
        repository.save(new CadastroConsumidor(dados));
    }
}
