package com.spring.springbootrevisao.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.springbootrevisao.entidades.pk.OrdemItemPK;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "ORDEM_ITEM")
public class OrdemItem implements Serializable {
    public static final long serialVersionUID = 1L;
    @EmbeddedId
    private OrdemItemPK id = new OrdemItemPK();
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
    @JsonIgnore
    public Ordem getOrdem(){return id.getOrdem();}
    public void setOrdem(Ordem ordem){id.setOrdem(ordem);}
    @JsonIgnore
    public Produto getProduto(){return id.getProduto();}
    public void setProduto(Produto produto){id.setProduto(produto);}
    public Integer getQuantidade() {return quantidade;}
    public void setQuantidade(Integer quantidade) {this.quantidade = quantidade;}
    public Double getPreco() {return preco;}
    public void setPreco(Double preco) {this.preco = preco;}
    public Double getSubTotal() {return preco * quantidade;}
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrdemItem other = (OrdemItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
