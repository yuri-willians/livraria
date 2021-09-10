package br.com.totemti.livraria.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.totemti.livraria.controllers.dto.LoginDTO;

@RestController
@RequestMapping(value = "/autenticacao")
public class AutenticacaoController {

    private AuthenticationManager authenticationManager;

    @Autowired
    public AutenticacaoController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public ResponseEntity<String> store(@RequestBody @Valid LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken login = 
        new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getSenha());
        authenticationManager.authenticate(login);

        return ResponseEntity.ok().body("teste");
    }
}
