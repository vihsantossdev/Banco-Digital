package br.com.cdb.bancodigital.service;

import com.banco.entity.Conta;
import com.banco.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta criarConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public Optional<Conta> obterContaPorId(Long id) {
        return contaRepository.findById(id);
    }

    public void excluirConta(Long id) {
        contaRepository.deleteById(id);
    }

    // Método para realizar um depósito em uma conta
    public Conta depositar(Long id, BigDecimal valor) {
        Optional<Conta> contaOptional = contaRepository.findById(id);
        if (contaOptional.isPresent()) {
            Conta conta = contaOptional.get();
            conta.setSaldo(conta.getSaldo().add(valor));
            return contaRepository.save(conta);
        }
        throw new RuntimeException("Conta não encontrada.");
    }

    // Método para realizar um saque de uma conta
    public Conta sacar(Long id, BigDecimal valor) {
        Optional<Conta> contaOptional = contaRepository.findById(id);
        if (contaOptional.isPresent()) {
            Conta conta = contaOptional.get();
            if (conta.getSaldo().compareTo(valor) >= 0) {
                conta.setSaldo(conta.getSaldo().subtract(valor));
                return contaRepository.save(conta);
            } else {
                throw new RuntimeException("Saldo insuficiente.");
            }
        }
        throw new RuntimeException("Conta não encontrada.");
    }

    // Método para realizar uma transferência entre duas contas
    public void transferir(Long idContaOrigem, Long idContaDestino, BigDecimal valor) {
        Optional<Conta> contaOrigemOptional = contaRepository.findById(idContaOrigem);
        Optional<Conta> contaDestinoOptional = contaRepository.findById(idContaDestino);

        if (contaOrigemOptional.isPresent() && contaDestinoOptional.isPresent()) {
            Conta contaOrigem = contaOrigemOptional.get();
            Conta contaDestino = contaDestinoOptional.get();

            if (contaOrigem.getSaldo().compareTo(valor) >= 0) {
                // Realizando a transferência
                contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
                contaDestino.setSaldo(contaDestino.getSaldo().add(valor));

                contaRepository.save(contaOrigem);
                contaRepository.save(contaDestino);
            } else {
                throw new RuntimeException("Saldo insuficiente para a transferência.");
            }
        } else {
            throw new RuntimeException("Uma das contas não foi encontrada.");
        }
    }

    // Método para consultar o saldo de uma conta
    public BigDecimal consultarSaldo(Long id) {
        Optional<Conta> contaOptional = contaRepository.findById(id);
        if (contaOptional.isPresent()) {
            return contaOptional.get().getSaldo();
        }
        throw new RuntimeException("Conta não encontrada.");
    }

    // Método para consultar o extrato de uma conta (simplificado como um histórico de transações)
    public String consultarExtrato(Long id) {
        Optional<Conta> contaOptional = contaRepository.findById(id);
        if (contaOptional.isPresent()) {
            Conta conta = contaOptional.get();
            // Aqui você pode adicionar lógica para pegar transações históricas
            // Para simplificação, vamos apenas retornar o saldo atual
            return "Extrato de Conta (ID: " + id + ")\nSaldo: " + conta.getSaldo();
        }
        throw new RuntimeException("Conta não encontrada.");
    }

    // Outros métodos relacionados a operações bancárias, como saldo, extrato, etc.
}
