package com.spring.springbootrevisao.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.springbootrevisao.entidades.enums.OrdemStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="ORDEM")
public class Ordem implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT")
    @Column(name = "MOMENTO")
    private Date momento;
    @Column(name="ORDEM_STATUS")
    private Integer ordemStatus;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CLIENTE_ID",nullable = false)
    private Usuario cliente;
    @JsonIgnore
    @OneToMany(mappedBy = "id.ordem")
    private Set<OrdemItem> items = new HashSet<>();
    @OneToOne(mappedBy = "ordem",cascade = CascadeType.ALL)
    private Pagamento pagamento;
    public Ordem() {
    }
    public Ordem(Long id, Date momento, Usuario cliente, OrdemStatus ordemStatus) {
        this.id = id;
        this.momento = momento;
        this.cliente = cliente;
        setOrdemStatus(ordemStatus);
    }
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Date getMomento() {return momento;}
    public void setMomento(Date momento) {this.momento = momento;}
    public Usuario getCliente() {return cliente;}
    public void setCliente(Usuario cliente) {this.cliente = cliente;}
    public OrdemStatus getOrdemStatus() {return OrdemStatus.valueOf(ordemStatus);}
    public void setOrdemStatus(OrdemStatus ordemStatus) {if(ordemStatus != null){this.ordemStatus = ordemStatus.getStatus();}}
    public Pagamento getPagamento() {return pagamento;}
    public void setPagamento(Pagamento pagamento) {this.pagamento = pagamento;}
    public Set<OrdemItem> getItems(){return items;}
    public Double getTotal(){double sum = 0.0;for (OrdemItem x : items){sum += x.getSubTotal();}return sum;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordem ordem = (Ordem) o;
        return id.equals(ordem.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
