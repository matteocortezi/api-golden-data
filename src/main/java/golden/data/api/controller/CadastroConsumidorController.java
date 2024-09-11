package golden.data.api.controller;

import golden.data.api.model.CadastroConsumidor;
import golden.data.api.cadastroConsumidor.CadastroConsumidorDTO;
import golden.data.api.cadastroConsumidor.CadastroConsumidorRepository;
import golden.data.api.cadastroConsumidor.DadosListagemConsumidores;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cadastro-consumidor")
public class CadastroConsumidorController {

    @Autowired
    private CadastroConsumidorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody CadastroConsumidorDTO dados){
        repository.save(new CadastroConsumidor(dados));
    }

    @GetMapping
    public List<DadosListagemConsumidores> listar() {
        return repository.findAll().stream().map(DadosListagemConsumidores::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid CadastroConsumidorDTO dados){
        var consumidor = repository.getReferenceById(dados.id_cons());
        consumidor.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

}
