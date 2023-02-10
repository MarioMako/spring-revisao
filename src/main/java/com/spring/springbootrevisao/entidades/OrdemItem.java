package com.spring.springbootrevisao.entidades;

import com.spring.springbootrevisao.entidades.pk.OrdemItemPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;

import java.io.Serializable;
import java.util.Objects;

public class OrdemItem implements Serializable {
    public static final long serialVersionUID = 1L;
    @EmbeddedId
    private OrdemItemPK id;
    @Column(name = "QUANTIDADE")
    private Integer quantidade;
    @Column(name="PRECO")
    private Double preco;
    public OrdemItem() {
    }
    public OrdemItem(Ordem ordem,Produto produto,Integer quantidade, Double preco) {
        id.setOrdem(ordem);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public Ordem getOrdem(){return id.getOrdem();}
    public void setOrdem(Ordem ordem){id.setOrdem(ordem);}
    public Produto getProduto(){return id.getProduto();}
    public void setProduto(Produto produto){id.setProduto(produto);}
    public Integer getQuantidade() {return quantidade;}
    public void setQuantidade(Integer quantidade) {this.quantidade = quantidade;}
    public Double getPreco() {return preco;}
    public void setPreco(Double preco) {this.preco = preco;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemItem ordemItem = (OrdemItem) o;
        return id.equals(ordemItem.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
