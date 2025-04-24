package br.com.cdb.bancodigital.model;

public class SeguroResponse {
    private String id;
    private String tipoSeguro;
    private String numeroPolica;

    // getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public String getNumeroPolica() {
        return numeroPolica;
    }

    public void setNumeroPolica(String numeroPolica) {
        this.numeroPolica = numeroPolica;
    }
}
