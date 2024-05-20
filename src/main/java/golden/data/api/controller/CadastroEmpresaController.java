package golden.data.api.controller;

import golden.data.api.cadastroConsumidor.DadosListagemConsumidores;
import golden.data.api.cadastroEmpresa.CadastroEmpresa;
import golden.data.api.cadastroEmpresa.CadastroEmpresaDto;
import golden.data.api.cadastroEmpresa.CadastroEmpresaRepository;
import golden.data.api.cadastroEmpresa.DadosListagemEmpresas;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("cadastro-empresa")
public class CadastroEmpresaController {

    @Autowired
    private CadastroEmpresaRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody CadastroEmpresaDto dados){
        repository.save(new CadastroEmpresa(dados));
    }
    @GetMapping
    public List<DadosListagemEmpresas> listar() {
        return repository.findAll().stream().map(DadosListagemEmpresas::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid CadastroEmpresaDto dados){
        var empresa = repository.getReferenceById(dados.id_emp());
        empresa.atualizarInformacoes(dados);
    }

}
