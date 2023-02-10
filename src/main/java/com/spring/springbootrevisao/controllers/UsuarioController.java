package com.spring.springbootrevisao.controllers;

import com.spring.springbootrevisao.entidades.Usuario;
import com.spring.springbootrevisao.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }
    @GetMapping(value ="/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        Usuario obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
