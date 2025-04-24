package br.com.cdb.bancodigital.util;

import java.util.regex.Pattern;

public class EmailUtil {

    private static final Pattern EMAIL_PATTERN =
        Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public static boolean isEmailValido(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}

