package golden.data.api.controller;

import golden.data.api.login.Login;
import golden.data.api.login.LoginDTO;
import golden.data.api.login.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")

public class LoginController {
    @Autowired
    private LoginRepository repository;

    @PostMapping
    private void Cadastrar(@RequestBody LoginDTO dados){
        repository.save(new Login(dados));

    }

}
