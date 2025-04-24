package br.com.cdb.bancodigital.controller;

import br.com.cdb.bancodigital.model.Conta;
import br.com.cdb.bancodigital.model.TipoConta;
import br.com.cdb.bancodigital.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/contas")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService contaService;

    @PostMapping("/criar")
    public ResponseEntity<Conta> criar(@RequestParam Long clienteId, @RequestParam TipoConta tipo) {
        return ResponseEntity.ok(contaService.criarConta(clienteId, tipo));
    }

    @PostMapping("/{id}/depositar")
    public ResponseEntity<Conta> depositar(@PathVariable Long id, @RequestParam BigDecimal valor) {
        return ResponseEntity.ok(contaService.depositar(id, valor));
    }

    @PostMapping("/{id}/sacar")
    public ResponseEntity<Conta> sacar(@PathVariable Long id, @RequestParam BigDecimal valor) {
        return ResponseEntity.ok(contaService.sacar(id, valor));
    }

    @PostMapping("/aplicar-taxas")
    public ResponseEntity<Void> aplicarTaxaMensal() {
        contaService.aplicarTaxaMensalEmTodas();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Conta>> listarContasPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(contaService.listarContasCliente(clienteId));
    }
}