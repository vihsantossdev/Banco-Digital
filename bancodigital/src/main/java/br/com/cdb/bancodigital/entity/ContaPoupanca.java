package br.com.cdb.bancodigital.entity;

@Entity
@DiscriminatorValue("POUPANCA")
public class ContaPoupanca extends Conta {
    @Override
    public void aplicarManutencaoOuRendimento() {
        // lógica do rendimento
    }
}
