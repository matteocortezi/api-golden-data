package golden.data.api.controller;

import golden.data.api.model.CadastroConsumidor;
import golden.data.api.dto.consumidoresDTO.CadastroConsumidorDTO;
import golden.data.api.repository.CadastroConsumidorRepository;
import golden.data.api.dto.consumidoresDTO.ListagemConsumidoresDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Operation(description = "Busca os consumidores cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna os consumidores cadastrados em páginas"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou página de dados inexistente")

    })
    @GetMapping
    public Page<ListagemConsumidoresDTO> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(ListagemConsumidoresDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid CadastroConsumidorDTO dados){
        var consumidor = repository.getReferenceById(dados.idCons());
        consumidor.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

}
