package br.com.cdb.bancodigital.util;

import java.text.NumberFormat;
import java.util.Locale;

public class SaldoFormatter {

    public static String formatar(double valor) {
        NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formatador.format(valor);
    }
}
