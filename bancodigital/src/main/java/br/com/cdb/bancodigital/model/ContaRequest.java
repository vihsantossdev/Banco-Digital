package br.com.cdb.bancodigital.model;

public class ContaRequest {
    private String tipoConta;
    private String clienteId;

    // getters and setters

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }
}

