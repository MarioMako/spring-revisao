package com.spring.springbootrevisao.services;

import com.spring.springbootrevisao.entidades.Usuario;
import com.spring.springbootrevisao.repositories.UsuarioRepository;
import com.spring.springbootrevisao.services.exceptions.DatabaseException;
import com.spring.springbootrevisao.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }
    public Usuario findById(Long id){
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Usuario insert(Usuario obj){
        return usuarioRepository.save(obj);
    }

    public void deleteById(Long id){
        try{
            usuarioRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
    public Usuario update(Long id, Usuario obj){
        try{
            Usuario entity = usuarioRepository.getReferenceById(id);
            updateData(entity,obj);
            return usuarioRepository.save(entity);
        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Usuario entity, Usuario obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
