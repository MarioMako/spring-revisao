package com.spring.springbootrevisao.services;

import com.spring.springbootrevisao.entidades.Ordem;
import com.spring.springbootrevisao.repositories.OrdemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class OrdemService {
    @Autowired
    private OrdemRepository ordemRepository;

    public List<Ordem> findAll(){
        return ordemRepository.findAll();
    }

    public Ordem findById(Long id){
        Optional<Ordem> obj = ordemRepository.findById(id);
        return obj.get();
    }
}
