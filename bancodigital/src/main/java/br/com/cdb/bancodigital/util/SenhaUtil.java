package br.com.cdb.bancodigital.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtil {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encriptarSenha(String senha) {
        return encoder.encode(senha);
    }

    public static boolean verificarSenha(String senhaDigitada, String senhaArmazenada) {
        return encoder.matches(senhaDigitada, senhaArmazenada);
    }
}

 