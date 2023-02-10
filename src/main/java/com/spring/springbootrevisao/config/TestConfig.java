package com.spring.springbootrevisao.config;

import com.spring.springbootrevisao.entidades.Ordem;
import com.spring.springbootrevisao.entidades.Usuario;
import com.spring.springbootrevisao.repositories.OrdemRepository;
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

    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario(null, "Pequeno Pedro", "pete@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario(null, "Wumpy Lumpy", "robert@gmail.com", "977777777", "123456");

        Ordem o1 = new Ordem(null,sdf.parse("22/06/2022 12:06:27"),u1);
        Ordem o2 = new Ordem(null,sdf.parse("22/06/2022 12:06:27"),u1);
        Ordem o3 = new Ordem(null,sdf.parse("22/07/2022 09:12:27"),u2);

        usuarioRepository.saveAll(Arrays.asList(u1,u2));
        ordemRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
