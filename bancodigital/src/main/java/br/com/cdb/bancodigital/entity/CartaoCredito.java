package br.com.cdb.bancodigital.entity;

@Entity
@DiscriminatorValue("CREDITO")
public class CartaoCredito extends Cartao {
    private BigDecimal totalGastoMes;

    public void pagar(BigDecimal valor) {
        // lógica de verificação de limite e taxa
    }
}
