package br.com.cdb.bancodigital.dto;

import java.util.Date;

public class SeguroDTO {

    private Long id;
    private String tipo;
    private Double valorCobertura;
    private Date dataVencimento;

    public SeguroDTO() {}

    public SeguroDTO(Long id, String tipo, Double valorCobertura, Date dataVencimento) {
        this.id = id;
        this.tipo = tipo;
        this.valorCobertura = valorCobertura;
        this.dataVencimento = dataVencimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValorCobertura() {
        return valorCobertura;
    }

    public void setValorCobertura(Double valorCobertura) {
        this.valorCobertura = valorCobertura;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
