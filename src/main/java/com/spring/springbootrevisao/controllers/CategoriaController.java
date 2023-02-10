package com.spring.springbootrevisao.controllers;

import com.spring.springbootrevisao.entidades.Categoria;
import com.spring.springbootrevisao.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;
    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }
    @GetMapping(value ="/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
