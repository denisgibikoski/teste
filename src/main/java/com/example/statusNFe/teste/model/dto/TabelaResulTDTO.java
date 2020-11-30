package com.example.statusNFe.teste.model.dto;

public class TabelaResulTDTO {

    String estado;
    Integer numero;

    public TabelaResulTDTO() {
    }

    public TabelaResulTDTO(String estado, Integer numero) {
        this.estado = estado;
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
