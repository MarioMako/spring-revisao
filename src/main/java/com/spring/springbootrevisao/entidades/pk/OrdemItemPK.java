package com.spring.springbootrevisao.entidades.pk;

import com.spring.springbootrevisao.entidades.Ordem;
import com.spring.springbootrevisao.entidades.Produto;

import java.util.Objects;

public class OrdemItemPK {
    private Ordem ordem;
    private Produto produto;

    public Ordem getOrdem() {return ordem;}
    public void setOrdem(Ordem ordem) {this.ordem = ordem;}
    public Produto getProduto() {return produto;}
    public void setProduto(Produto produto) {this.produto = produto;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemItemPK that = (OrdemItemPK) o;
        return ordem.equals(that.ordem) && produto.equals(that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordem, produto);
    }
}
