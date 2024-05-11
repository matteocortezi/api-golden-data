package golden.data.api.controller;

import golden.data.api.cadastroEmpresa.cadastroEmpresaDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("cadastro-empresa")
public class cadastroEmpresaController {
    @PostMapping
    public void cadastrar(@RequestBody cadastroEmpresaDto dados){
        System.out.println(dados);
    }

}
