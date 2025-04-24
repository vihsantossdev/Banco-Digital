package br.com.cdb.bancodigital.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(nullable = false)
    private TipoConta tipoConta;

    @Column(nullable = false)
    private BigDecimal saldo;

    @Column(nullable = false)
    private BigDecimal taxaManutencao;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getTaxaManutencao() {
        return taxaManutencao;
    }

    public void setTaxaManutencao(BigDecimal taxaManutencao) {
        this.taxaManutencao = taxaManutencao;
    }
}
