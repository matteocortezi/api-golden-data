package golden.data.api.controller;

import golden.data.api.dto.infoConsumidorDTO.ListagemInfoConsumidorDTO;
import golden.data.api.model.InfoConsumidor;
import golden.data.api.dto.infoConsumidorDTO.InfoConsumidorDTO;
import golden.data.api.repository.InfoConsumidorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<ListagemInfoConsumidorDTO> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(ListagemInfoConsumidorDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid InfoConsumidorDTO dados){
        var infoConsumidor = repository.getReferenceById(dados.idInfo());
        infoConsumidor.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

}
