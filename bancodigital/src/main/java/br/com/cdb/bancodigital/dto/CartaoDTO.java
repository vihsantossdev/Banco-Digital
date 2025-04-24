package br.com.cdb.bancodigital.dto;

public class CartaoDTO {

    private Long id;
    private String numero;
    private Double limite;
    private String status;

    public CartaoDTO() {}

    public CartaoDTO(Long id, String numero, Double limite, String status) {
        this.id = id;
        this.numero = numero;
        this.limite = limite;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


