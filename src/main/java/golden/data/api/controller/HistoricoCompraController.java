package golden.data.api.controller;

import golden.data.api.dto.historicoCompraDTO.ListagemHistoricoCompraDTO;
import golden.data.api.model.HistoricoCompra;
import golden.data.api.dto.historicoCompraDTO.HistoricoCompraDTO;
import golden.data.api.repository.HistoricoCompraRepository;
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
@RequestMapping("historico-compra")
public class HistoricoCompraController {

    @Autowired
    private HistoricoCompraRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody HistoricoCompraDTO dados){
        repository.save(new HistoricoCompra(dados));
    }


    @Operation(description = "Busca o histórico de compra realizado pelos consumidores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna as compras realizadas em páginas"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida ou página de dados inexistente")

    })
    @GetMapping
    public Page<ListagemHistoricoCompraDTO> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(ListagemHistoricoCompraDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid HistoricoCompraDTO dados){
        var historicoCompra = repository.getReferenceById(dados.idCmp());
        historicoCompra.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
