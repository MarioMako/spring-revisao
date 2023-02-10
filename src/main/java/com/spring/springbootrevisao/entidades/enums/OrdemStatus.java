package com.spring.springbootrevisao.entidades.enums;

public enum OrdemStatus {
    PROCESSAMENTO(0), PREPARANDO(1), ENVIADO(2), ENTREGUE(3);

    private Integer status;
    private OrdemStatus(Integer status) {this.status = status;}
    public Integer getStatus(){return status;}
    public static OrdemStatus valueOf(int status){
        for(OrdemStatus value : OrdemStatus.values()){
            if(value.getStatus()==status){
                return value;
            }
        }
        throw new IllegalArgumentException("Status da Ordem Inválido!");
    }
}
