package com.spring.springbootrevisao.config;

import com.spring.springbootrevisao.entidades.Categoria;
import com.spring.springbootrevisao.entidades.Ordem;
import com.spring.springbootrevisao.entidades.Produto;
import com.spring.springbootrevisao.entidades.Usuario;
import com.spring.springbootrevisao.entidades.enums.OrdemStatus;
import com.spring.springbootrevisao.repositories.CategoriaRepository;
import com.spring.springbootrevisao.repositories.OrdemRepository;
import com.spring.springbootrevisao.repositories.ProdutoRepository;
import com.spring.springbootrevisao.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.util.*;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private OrdemRepository ordemRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario(null, "Pequeno Pedro", "pete@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario(null, "Wumpy Lumpy", "robert@gmail.com", "977777777", "123456");

        Ordem o1 = new Ordem(null,sdf.parse("22/06/2022 12:06:27"),u1, OrdemStatus.PROCESSAMENTO);
        Ordem o2 = new Ordem(null,sdf.parse("22/06/2022 12:06:27"),u1,OrdemStatus.ENVIADO);
        Ordem o3 = new Ordem(null,sdf.parse("22/07/2022 09:12:27"),u2,OrdemStatus.PREPARANDO);

        Categoria cat1 = new Categoria(null, "Electronicos");
        Categoria cat2 = new Categoria(null, "Livros");
        Categoria cat3 = new Categoria(null, "Computadores");

        Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        p1.getCategorias().add(cat2);
        p2.getCategorias().add(cat1);
        p3.getCategorias().add(cat1);
        p3.getCategorias().add(cat3);
        p4.getCategorias().add(cat1);
        p3.getCategorias().add(cat3);
        p5.getCategorias().add(cat2);

        usuarioRepository.saveAll(Arrays.asList(u1,u2));
        ordemRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
    }
}
