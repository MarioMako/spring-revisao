package com.spring.springbootrevisao.repositories;

import com.spring.springbootrevisao.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
