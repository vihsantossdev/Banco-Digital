package br.com.cdb.bancodigital.model;

public class CartaoRequest {
    private String tipoCartao;
    private String clienteId;

    // getters and setters

    public String getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }
}
