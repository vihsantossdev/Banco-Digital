package br.com.cdb.bancodigital.model;

public class SeguroRequest {
    private String tipoSeguro;
    private String cartaoId;

    // getters and setters

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public String getCartaoId() {
        return cartaoId;
    }

    public void setCartaoId(String cartaoId) {
        this.cartaoId = cartaoId;
    }
}

