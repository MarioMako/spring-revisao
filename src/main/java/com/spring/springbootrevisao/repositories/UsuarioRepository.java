package com.spring.springbootrevisao.repositories;

import com.spring.springbootrevisao.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
