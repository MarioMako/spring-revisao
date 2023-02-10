package com.spring.springbootrevisao.controllers;

import com.spring.springbootrevisao.entidades.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping
    public ResponseEntity<Usuario> findAll(){
        Usuario u = new Usuario(1L,"Pedrinho","peter@gmail.com","8888-888","thesis");
        return ResponseEntity.ok().body(u);
    }
}
