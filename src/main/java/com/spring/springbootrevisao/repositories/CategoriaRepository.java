package com.spring.springbootrevisao.repositories;

import com.spring.springbootrevisao.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
