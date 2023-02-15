package com.spring.springbootrevisao.services;

import com.spring.springbootrevisao.entidades.Usuario;
import com.spring.springbootrevisao.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return obj.get();
    }
    public Usuario insert(Usuario obj){
        return usuarioRepository.save(obj);
    }
    public void delete(Usuario obj){
        usuarioRepository.delete(obj);
    }
    public Usuario update(Long id, Usuario obj){
        Usuario entity = usuarioRepository.getReferenceById(id);
        updateData(entity,obj);
        return usuarioRepository.save(entity);
    }

    private void updateData(Usuario entity, Usuario obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
