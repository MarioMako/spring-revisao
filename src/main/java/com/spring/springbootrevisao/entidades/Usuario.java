package com.spring.springbootrevisao.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String phone;
    private String senha;

    public Usuario() {
    }
    public Usuario(Long id, String nome, String email, String phone, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.phone = phone;
        this.senha = senha;
    }
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
