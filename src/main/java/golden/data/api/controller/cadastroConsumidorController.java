package golden.data.api.controller;

import golden.data.api.cadastroConsumidor.cadastroConsumidorDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cadastro-consumidor")
public class cadastroConsumidorController {

    @PostMapping
    public void cadastrar(@RequestBody cadastroConsumidorDTO dados){
        System.out.println(dados);

    }
}
