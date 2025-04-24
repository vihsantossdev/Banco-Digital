package br.com.cdb.bancodigital.controller;

import br.com.cdb.bancodigital.dto.AuthRequest;
import br.com.cdb.bancodigital.dto.AuthResponse;
import br.com.cdb.bancodigital.service.JwtService;
import br.com.cdb.bancodigital.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;
    private final JwtService jwtService;

    public AuthController(UsuarioService usuarioService, JwtService jwtService) {
        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
    }

    // Rota para registrar um novo usuário
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest authRequest) {
        usuarioService.register(authRequest);
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }

    // Rota para fazer login e gerar o token JWT
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        String token = usuarioService.login(authRequest);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}

