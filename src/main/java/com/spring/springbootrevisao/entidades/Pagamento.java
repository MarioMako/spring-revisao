package com.spring.springbootrevisao.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PAGAMENTO")
public class Pagamento implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT")
    @Column(name = "MOMENTO")
    private Date momento;
    @JsonIgnore
    @OneToOne
    @MapsId
    private Ordem ordem;
    public Pagamento() {
    }
    public Pagamento(Long id, Date momento, Ordem ordem) {
        this.id = id;
        this.momento = momento;
        this.ordem = ordem;
    }
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Date getMomento() {return momento;}
    public void setMomento(Date momento) {this.momento = momento;}
    public Ordem getOrdem() {return ordem;}
    public void setOrdem(Ordem ordem) {this.ordem = ordem;}
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
        Pagamento other = (Pagamento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
