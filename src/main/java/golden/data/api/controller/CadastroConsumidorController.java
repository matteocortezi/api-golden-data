package golden.data.api.controller;

import golden.data.api.model.CadastroConsumidor;
import golden.data.api.dto.consumidoresDTO.CadastroConsumidorDTO;
import golden.data.api.repository.CadastroConsumidorRepository;
import golden.data.api.dto.consumidoresDTO.ListagemConsumidoresDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("cadastro-consumidor")
@Tag(name = "Cadastro de Consumidores", description = "Operações relacionadas ao cadastro de consumidores")
public class CadastroConsumidorController {

    @Autowired
    private CadastroConsumidorRepository repository;

    @Operation(summary = "Cadastrar novo consumidor", description = "Registra um novo consumidor no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Consumidor cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(
            @RequestBody @Valid @Parameter(description = "Dados do novo consumidor", required = true) CadastroConsumidorDTO dados) {
        repository.save(new CadastroConsumidor(dados));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Listar consumidores", description = "Retorna uma lista paginada dos consumidores cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de consumidores cadastrados"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @GetMapping
    public Page<ListagemConsumidoresDTO> listar(
            @Parameter(description = "Parâmetros de paginação", example = "page=0&size=10&sort=nome,asc") Pageable paginacao) {
        return repository.findAll(paginacao).map(ListagemConsumidoresDTO::new);
    }

    @Operation(summary = "Atualizar informações de um consumidor", description = "Atualiza os dados de um consumidor já existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informações do consumidor atualizadas com sucesso"),
            @ApiResponse(responseCode = "404", description = "Consumidor não encontrado")
    })
    @PutMapping
    @Transactional
    public ResponseEntity<Void> atualizar(
            @RequestBody @Valid @Parameter(description = "Dados atualizados do consumidor", required = true) CadastroConsumidorDTO dados) {
        var consumidor = repository.getReferenceById(dados.idCons());
        consumidor.atualizarInformacoes(dados);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Excluir um consumidor", description = "Remove um consumidor do sistema com base no ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Consumidor excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Consumidor não encontrado")
    })
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(
            @Parameter(description = "ID do consumidor a ser excluído", required = true, example = "1") @PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
