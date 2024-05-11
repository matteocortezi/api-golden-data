package golden.data.api.controller;

import golden.data.api.infoConsumidor.InfoConsumidorDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("info-consumidor")

public class infoConsumidorController {
    @PostMapping
    public void cadastrar(@RequestBody InfoConsumidorDTO dados){
        System.out.println(dados);
    }

}