package br.com.cdb.bancodigital.entity;

@Entity
@DiscriminatorValue("DEBITO")
public class CartaoDebito extends Cartao {
    private BigDecimal limiteDiario;

    public void pagar(BigDecimal valor) {
        // lógica de verificação do limite diário
    }
}
