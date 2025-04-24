package br.com.cdb.bancodigital.util;

public class CpfValidator {

    public static boolean isValid(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.chars().distinct().count() == 1) {
            return false;
        }

        try {
            int soma1 = 0;
            for (int i = 0; i < 9; i++) {
                soma1 += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            }

            int digito1 = 11 - (soma1 % 11);
            digito1 = (digito1 > 9) ? 0 : digito1;

            int soma2 = 0;
            for (int i = 0; i < 10; i++) {
                soma2 += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
            }

            int digito2 = 11 - (soma2 % 11);
            digito2 = (digito2 > 9) ? 0 : digito2;

            return digito1 == Character.getNumericValue(cpf.charAt(9)) &&
                   digito2 == Character.getNumericValue(cpf.charAt(10));

        } catch (NumberFormatException e) {
            return false;
        }
    }
}

