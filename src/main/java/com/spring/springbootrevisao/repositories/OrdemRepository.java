package com.spring.springbootrevisao.repositories;

import com.spring.springbootrevisao.entidades.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemRepository extends JpaRepository<Ordem,Long> {

}
