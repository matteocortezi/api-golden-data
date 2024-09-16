package golden.data.api.controller;

import golden.data.api.pagamento.DadosListagemPagamentos;
import golden.data.api.model.Pagamento;
import golden.data.api.pagamento.PagamentoDTO;
import golden.data.api.repository.PagamentoRepository;
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
@RequestMapping("pagamento")
@Tag(name = "Pagamentos", description = "Operações relacionadas ao gerenciamento de pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRepository repository;

    @Operation(summary = "Cadastrar um pagamento", description = "Registra as informações de um novo pagamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pagamento cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(
            @RequestBody @Valid @Parameter(description = "Dados do pagamento", required = true) PagamentoDTO dados) {
        repository.save(new Pagamento(dados));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Listar pagamentos", description = "Retorna uma lista paginada com os pagamentos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pagamentos retornada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou página de dados inexistente")
    })
    @GetMapping
    public Page<DadosListagemPagamentos> listar(
            @Parameter(description = "Parâmetros de paginação", example = "page=0&size=10&sort=data,asc") Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemPagamentos::new);
    }

    @Operation(summary = "Excluir um pagamento", description = "Remove um pagamento existente com base no ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pagamento excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pagamento não encontrado")
    })
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(
            @Parameter(description = "ID do pagamento que será excluído", required = true, example = "1") @PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

