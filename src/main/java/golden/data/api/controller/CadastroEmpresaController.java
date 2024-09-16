package golden.data.api.controller;

import golden.data.api.model.CadastroEmpresa;
import golden.data.api.dto.empresaDTO.CadastroEmpresaDTO;
import golden.data.api.repository.CadastroEmpresaRepository;
import golden.data.api.dto.empresaDTO.ListagemEmpresasDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("cadastro-empresa")
public class CadastroEmpresaController {

    @Autowired
    private CadastroEmpresaRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody CadastroEmpresaDTO dados){
        repository.save(new CadastroEmpresa(dados));
    }



    @Operation(description = "Busca as empresas que foram cadastradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna as empresas cadastradas em páginas"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou página de dados inexistente")

    })
    @GetMapping
    public Page<ListagemEmpresasDTO> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(ListagemEmpresasDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid CadastroEmpresaDTO dados){
        var empresa = repository.getReferenceById(dados.idEmp()
        );
        empresa.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

}
