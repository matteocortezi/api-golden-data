package golden.data.api.controller;

import golden.data.api.dto.infoConsumidorDTO.ListagemInfoConsumidorDTO;
import golden.data.api.model.InfoConsumidor;
import golden.data.api.dto.infoConsumidorDTO.InfoConsumidorDTO;
import golden.data.api.repository.InfoConsumidorRepository;
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

import java.util.List;

@RestController
@RequestMapping("info-consumidor")
@Tag(name = "Informações do Consumidor", description = "Operações relacionadas às informações dos consumidores")
public class InfoConsumidorController {

    @Autowired
    InfoConsumidorRepository repository;

    @Operation(summary = "Cadastrar informações do consumidor", description = "Registra as informações de um novo consumidor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Informações do consumidor cadastradas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(
            @RequestBody @Valid @Parameter(description = "Dados do consumidor", required = true) InfoConsumidorDTO dados) {
        repository.save(new InfoConsumidor(dados));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Listar informações dos consumidores", description = "Retorna uma lista paginada com as informações dos consumidores cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de informações dos consumidores retornada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou página de dados inexistente")
    })
    @GetMapping
    public Page<ListagemInfoConsumidorDTO> listar(
            @Parameter(description = "Parâmetros de paginação", example = "page=0&size=10&sort=nome,asc") Pageable paginacao) {
        return repository.findAll(paginacao).map(ListagemInfoConsumidorDTO::new);
    }

    @Operation(summary = "Atualizar informações do consumidor", description = "Atualiza as informações de um consumidor existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informações do consumidor atualizadas com sucesso"),
            @ApiResponse(responseCode = "404", description = "Informações do consumidor não encontradas")
    })
    @PutMapping
    @Transactional
    public ResponseEntity<Void> atualizar(
            @RequestBody @Valid @Parameter(description = "Dados atualizados do consumidor", required = true) InfoConsumidorDTO dados) {
        var infoConsumidor = repository.getReferenceById(dados.idInfo());
        infoConsumidor.atualizarInformacoes(dados);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Excluir informações do consumidor", description = "Remove as informações de um consumidor com base no ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Informações do consumidor excluídas com sucesso"),
            @ApiResponse(responseCode = "404", description = "Informações do consumidor não encontradas")
    })
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(
            @Parameter(description = "ID do consumidor cujas informações serão excluídas", required = true, example = "1") @PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

