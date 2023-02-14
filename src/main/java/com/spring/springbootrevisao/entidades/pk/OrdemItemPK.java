package com.spring.springbootrevisao.entidades.pk;

import com.spring.springbootrevisao.entidades.Ordem;
import com.spring.springbootrevisao.entidades.Produto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class OrdemItemPK implements Serializable {
    public static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn(name="ORDEM_ID")
    private Ordem ordem;
    @ManyToOne
    @JoinColumn(name="PRODUTO_ID")
    private Produto produto;
    public OrdemItemPK() {
    }
    public OrdemItemPK(Ordem ordem, Produto produto) {
        this.ordem = ordem;
        this.produto = produto;
    }
    public Ordem getOrdem() {return ordem;}
    public void setOrdem(Ordem ordem) {this.ordem = ordem;}
    public Produto getProduto() {return produto;}
    public void setProduto(Produto produto) {this.produto = produto;}
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ordem == null) ? 0 : ordem.hashCode());
        result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
        OrdemItemPK other = (OrdemItemPK) obj;
        if (ordem == null) {
            if (other.ordem != null)
                return false;
        } else if (!ordem.equals(other.ordem))
            return false;
        if (produto == null) {
            if (other.produto != null)
                return false;
        } else if (!produto.equals(other.produto))
            return false;
        return true;
    }
}
