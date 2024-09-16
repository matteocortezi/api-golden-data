package golden.data.api.controller;

import golden.data.api.model.CadastroEmpresa;
import golden.data.api.dto.empresaDTO.CadastroEmpresaDTO;
import golden.data.api.repository.CadastroEmpresaRepository;
import golden.data.api.dto.empresaDTO.ListagemEmpresasDTO;
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
@RequestMapping("cadastro-empresa")
@Tag(name = "Cadastro de Empresas", description = "Operações relacionadas ao cadastro de empresas")
public class CadastroEmpresaController {

    @Autowired
    private CadastroEmpresaRepository repository;

    @Operation(summary = "Cadastrar nova empresa", description = "Registra uma nova empresa no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Empresa cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(
            @RequestBody @Valid @Parameter(description = "Dados da nova empresa", required = true) CadastroEmpresaDTO dados) {
        repository.save(new CadastroEmpresa(dados));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Listar empresas cadastradas", description = "Retorna uma lista paginada das empresas cadastradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de empresas cadastradas"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @GetMapping
    public Page<ListagemEmpresasDTO> listar(
            @Parameter(description = "Parâmetros de paginação", example = "page=0&size=10&sort=nome,asc") Pageable paginacao) {
        return repository.findAll(paginacao).map(ListagemEmpresasDTO::new);
    }

    @Operation(summary = "Atualizar informações de uma empresa", description = "Atualiza os dados de uma empresa já existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informações da empresa atualizadas com sucesso"),
            @ApiResponse(responseCode = "404", description = "Empresa não encontrada")
    })
    @PutMapping
    @Transactional
    public ResponseEntity<Void> atualizar(
            @RequestBody @Valid @Parameter(description = "Dados atualizados da empresa", required = true) CadastroEmpresaDTO dados) {
        var empresa = repository.getReferenceById(dados.idEmp());
        empresa.atualizarInformacoes(dados);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Excluir uma empresa", description = "Remove uma empresa do sistema com base no ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Empresa excluída com sucesso"),
            @ApiResponse(responseCode = "404", description = "Empresa não encontrada")
    })
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(
            @Parameter(description = "ID da empresa a ser excluída", required = true, example = "1") @PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

