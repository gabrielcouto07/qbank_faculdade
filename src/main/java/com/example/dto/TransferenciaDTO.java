package com.example.dto;

public class TransferenciaDTO {
    private Long idOrigem;
    private Long idDestino;
    private Long contaId;
    private Double valor;

    public Long getIdOrigem() {
        return idOrigem;
    }

    public void setIdOrigem(Long idOrigem) {
        this.idOrigem = idOrigem;
    }

    public Long getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(Long idDestino) {
        this.idDestino = idDestino;
    }

    public Long getContaId() { 
        return contaId;
    }

    public void setContaId(Long contaId) { 
        this.contaId = contaId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
