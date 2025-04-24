package br.com.cdb.bancodigital.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Seguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cartao_id", nullable = false)
    private Cartao cartao;

    @Column(nullable = false)
    private String tipoSeguro;

    @Column(nullable = false)
    private BigDecimal valorApolice;

    @Column(nullable = false)
    private Date dataContratacao;

    @Column(nullable = false)
    private String condicoesAcionamento;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public BigDecimal getValorApolice() {
        return valorApolice;
    }

    public void setValorApolice(BigDecimal valorApolice) {
        this.valorApolice = valorApolice;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getCondicoesAcionamento() {
        return condicoesAcionamento;
    }

    public void setCondicoesAcionamento(String condicoesAcionamento) {
        this.condicoesAcionamento = condicoesAcionamento;
    }
}

