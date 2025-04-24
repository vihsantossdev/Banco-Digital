package br.com.cdb.bancodigital.controller;

import br.com.cdb.bancodigital.model.Cartao;
import br.com.cdb.bancodigital.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    public ResponseEntity<Cartao> emitirCartao(@RequestBody Cartao cartao) {
        Cartao novoCartao = cartaoService.emitirCartao(cartao);
        return new ResponseEntity<>(novoCartao, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cartao> obterCartao(@PathVariable Long id) {
        Cartao cartao = cartaoService.obterCartao(id);
        if (cartao == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cartao, HttpStatus.OK);
    }

    @PostMapping("/{id}/pagamento")
    public ResponseEntity<Void> realizarPagamento(@PathVariable Long id, @RequestParam Double valor) {
        boolean pagamentoRealizado = cartaoService.realizarPagamento(id, valor);
        if (!pagamentoRealizado) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/limite")
    public ResponseEntity<Cartao> alterarLimite(@PathVariable Long id, @RequestParam Double novoLimite) {
        Cartao cartaoAtualizado = cartaoService.alterarLimite(id, novoLimite);
        if (cartaoAtualizado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cartaoAtualizado, HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> ativarDesativarCartao(@PathVariable Long id, @RequestParam Boolean ativo) {
        boolean statusAlterado = cartaoService.ativarDesativarCartao(id, ativo);
        if (!statusAlterado) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/senha")
    public ResponseEntity<Void> alterarSenha(@PathVariable Long id, @RequestParam String novaSenha) {
        boolean senhaAlterada = cartaoService.alterarSenha(id, novaSenha);
        if (!senhaAlterada) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/fatura")
    public ResponseEntity<Double> consultarFatura(@PathVariable Long id) {
        Double fatura = cartaoService.consultarFatura(id);
        if (fatura == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fatura, HttpStatus.OK);
    }
}
