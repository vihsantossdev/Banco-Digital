package br.com.cdb.bancodigital.util;

import java.util.Random;

public class NumeroContaGenerator {

    public static String gerarNumeroConta() {
        Random random = new Random();
        int numero = 100000 + random.nextInt(900000); // Gera número de 6 dígitos
        return String.valueOf(numero);
    }
}
