package com.spring.springbootrevisao.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="CATEGORIA")
public class Categoria implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME")
    private String nome;
    @JsonIgnore
    @ManyToMany(mappedBy = "categorias")
    private Set<Produto> produtos = new HashSet<>();
    public Categoria() {
    }
    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public Set<Produto> getProdutos() {return produtos;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id.equals(categoria.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
