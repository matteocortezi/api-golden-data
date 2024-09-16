package golden.data.api.controller;

import golden.data.api.dto.historicoCompraDTO.ListagemHistoricoCompraDTO;
import golden.data.api.model.HistoricoCompra;
import golden.data.api.dto.historicoCompraDTO.HistoricoCompraDTO;
import golden.data.api.repository.HistoricoCompraRepository;
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
@RequestMapping("historico-compra")
@Tag(name = "Histórico de Compras", description = "Operações relacionadas ao histórico de compras dos consumidores")
public class HistoricoCompraController {

    @Autowired
    private HistoricoCompraRepository repository;

    @Operation(summary = "Cadastrar histórico de compra", description = "Registra uma nova entrada no histórico de compras de um consumidor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Histórico de compra cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(
            @RequestBody @Valid @Parameter(description = "Dados do histórico de compra", required = true) HistoricoCompraDTO dados) {
        repository.save(new HistoricoCompra(dados));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Listar histórico de compras", description = "Retorna uma lista paginada do histórico de compras dos consumidores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista do histórico de compras retornada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou página de dados inexistente")
    })
    @GetMapping
    public Page<ListagemHistoricoCompraDTO> listar(
            @Parameter(description = "Parâmetros de paginação", example = "page=0&size=10&sort=data,desc") Pageable paginacao) {
        return repository.findAll(paginacao).map(ListagemHistoricoCompraDTO::new);
    }

    @Operation(summary = "Atualizar histórico de compra", description = "Atualiza as informações de uma compra no histórico de um consumidor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informações do histórico de compra atualizadas com sucesso"),
            @ApiResponse(responseCode = "404", description = "Histórico de compra não encontrado")
    })
    @PutMapping
    @Transactional
    public ResponseEntity<Void> atualizar(
            @RequestBody @Valid @Parameter(description = "Dados atualizados do histórico de compra", required = true) HistoricoCompraDTO dados) {
        var historicoCompra = repository.getReferenceById(dados.idCmp());
        historicoCompra.atualizarInformacoes(dados);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Excluir histórico de compra", description = "Remove uma entrada do histórico de compras com base no ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Histórico de compra excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Histórico de compra não encontrado")
    })
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(
            @Parameter(description = "ID do histórico de compra a ser excluído", required = true, example = "1") @PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

