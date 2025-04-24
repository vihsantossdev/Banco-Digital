package br.com.cdb.bancodigital.entity;

@Entity
@DiscriminatorValue("CORRENTE")
public class ContaCorrente extends Conta {
    @Override
    public void aplicarManutencaoOuRendimento() {
        // lógica da taxa de manutenção com base na categoria
    }
}

