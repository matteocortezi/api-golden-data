package golden.data.api.controller;

import golden.data.api.infoConsumidor.InfoConsumidor;
import golden.data.api.infoConsumidor.InfoConsumidorDTO;
import golden.data.api.infoConsumidor.InfoConsumidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("info-consumidor")

public class InfoConsumidorController {

    @Autowired
    InfoConsumidorRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody InfoConsumidorDTO dados){
        repository.save(new InfoConsumidor(dados));
    }

}
