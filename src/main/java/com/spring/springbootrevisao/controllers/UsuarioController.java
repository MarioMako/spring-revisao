package com.spring.springbootrevisao.controllers;

import com.spring.springbootrevisao.entidades.Usuario;
import com.spring.springbootrevisao.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody Usuario obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Usuario> delete(@RequestBody Usuario obj){
        service.delete(obj);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj){
        obj = service.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }

}
