package golden.data.api.controller;

import golden.data.api.login.loginDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class login {
    @PostMapping
    public void cadastrar(@RequestBody loginDTO dados){
        System.out.println(dados);
    }
}
