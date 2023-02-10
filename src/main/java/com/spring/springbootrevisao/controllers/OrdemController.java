package com.spring.springbootrevisao.controllers;

import com.spring.springbootrevisao.entidades.Ordem;
import com.spring.springbootrevisao.services.OrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/ordens")
public class OrdemController {

    @Autowired
    private OrdemService service;
    @GetMapping
    public ResponseEntity<List<Ordem>> findAll(){
        List<Ordem> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }
    @GetMapping(value ="/{id}")
    public ResponseEntity<Ordem> findById(@PathVariable Long id){
        Ordem obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
