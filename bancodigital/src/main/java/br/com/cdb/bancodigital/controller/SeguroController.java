package br.com.cdb.bancodigital.controller;

import br.com.cdb.bancodigital.model.Seguro;
import br.com.cdb.bancodigital.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seguros")
public class SeguroController {

    @Autowired
    private SeguroService seguroService;

    @PostMapping
    public ResponseEntity<Seguro> contratarSeguro(@RequestBody Seguro seguro) {
        Seguro novoSeguro = seguroService.contratarSeguro(seguro);
        return new ResponseEntity<>(novoSeguro, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seguro> obterSeguro(@PathVariable Long id) {
        Seguro seguro = seguroService.obterSeguro(id);
        if (seguro == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(seguro, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Seguro>> listarSeguros() {
        List<Seguro> seguros = seguroService.listarSeguros();
        return new ResponseEntity<>(seguros, HttpStatus.OK);
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelarSeguro(@PathVariable Long id) {
        boolean cancelado = seguroService.cancelarSeguro(id);
        if (!cancelado) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

